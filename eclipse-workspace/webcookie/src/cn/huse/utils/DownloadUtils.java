package cn.huse.utils;


//使用超链接的方式实现文件的下载
//在<a href=”文件的路径”>超链接</a>
//注意：超链接的方式，如果浏览器不能识别这种格式的文件，提示下载，如果支持该格式的文件，直接打开。
//通过手动编写代码的方式实现文件的下载

//设置两个头和一个流
//Content-Type			:文件的MIME的类型
//Content-Disposition	:浏览器支持该格式的文件，提示下载
//设置代表该文件的输入流(输出流是固定 response.getOutputStream())


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
//import sun.misc.BASE64Encoder;

public class DownloadUtils {
	public static String base64EncodeFileName(String fileName) {
		Base64.Encoder encoder = Base64.getEncoder();
		try {
			return "=?UTF-8?B?"
					+ new String(encoder.encodeToString(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	 public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
	        if (agent.contains("MSIE")) {
	            // IE浏览器(版本太低的也无法打开)
	            filename = URLEncoder.encode(filename, "utf-8");
	            filename = filename.replace("+", " ");
	        } else if (agent.contains("Firefox")) {
	            // 火狐浏览器
	            Base64.Encoder encoder = Base64.getEncoder();
	            filename = "=?utf-8?B?" + encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
	        } else {
	            // 其它浏览器
	            filename = URLEncoder.encode(filename, "utf-8");
	        }
	        return filename;
	    }
}
