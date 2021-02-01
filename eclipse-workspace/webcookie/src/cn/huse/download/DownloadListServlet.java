package cn.huse.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huse.utils.DownloadUtils;

/*
tomcat由7.0.65升级到7.0.104后出现该问题
java.lang.IllegalArgumentException：
在请求目标中找到无效字符。有效字符在RFC 7230和RFC 3986中定义

1.在tomcat安装路径\conf\catalina.properties中，找到注释掉的一行
＃tomcat.util.http.parser.HttpParser.requestTargetAllow=| ，
改成tomcat.util.http.parser.HttpParser.requestTargetAllow=|{}，表示把｛｝放行

2.在./conf/service.xml中添加realxedQueryChars属性
<Connector port="8080" protocol="HTTP/1.1"
connectionTimeout="30000"
      maxThreads="800"
      minSpareThreads="50"
redirectPort="8443"
URIEncoding="ISO-8859-1"
relaxedQueryChars="[,],|,{,},^,&#x5c;,&#x60;,&quot;,&lt;,&gt;"/>
*/

/**
 * 树形的文件下载的代码实现
 */
public class DownloadListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收参数:
		String path = request.getParameter("filename");
		if(path != null){
			path = new String(path.getBytes("ISO-8859-1"),"UTF-8");
		}
		File file = new File(path);
		// 实现文件下载:设置两个头和一个流:
		// 获得文件名
		String filename = file.getName();
		response.setContentType(getServletContext().getMimeType(filename));
		// 设置另一个头：
		String agent = request.getHeader("User-Agent");
		if(agent.contains("Firefox")){
			filename = DownloadUtils.base64EncodeFileName(filename);
		}else{
			filename = URLEncoder.encode(filename, "UTF-8");
			filename = filename.replace("+", " ");
		}
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		// 设置输入流:
		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while((len = is.read(b))!=-1){
			os.write(b, 0, len);
		}
		is.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
