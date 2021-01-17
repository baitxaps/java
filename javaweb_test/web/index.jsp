<%--
  netstat -ano
  tasklist

  Created by IntelliJ IDEA.
  User: chenhairong
  Date: 2021/1/17
  Time: 12:26
  To change this template use File | Settings | File Templates.

  Application Server was not connected before run configuration stop,
  reason: javax.management.InstanceNotFoundException: Catalina:type=Server
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>web</title>
  </head>
  <body>
  <form action="success.html" method="post">
    姓名:<input type="text" name="name"/><br/>
    性别:<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
  </form>
  </body>
</html>

<%--请求头：--%>
<%--Referer		：代表网页的来源。（防盗链）。--%>
<%--User-Agent	：获得客户端浏览器类型。--%>

<%--响应行--%>
    <%--协议版本--%>
    <%--状态码--%>
        <%--200	：代表响应成功--%>
        <%--302	：需要进行重定向操作--%>
        <%--304	：需要查找本地缓存--%>
        <%--404	：请求资源不存在--%>
        <%--500	：服务器内部错误--%>
<%--状态码描述--%>
<%--响应头--%>
<%--通常一个key对应一个value，也有一个key对应多个value。--%>
<%--记住响应头：--%>
        <%--Location：重定向的路径。--%>
        <%--Refresh	：定时刷新。--%>
        <%--Content-Disposition：文件下载的时候使用。--%>
<%--响应体--%>
        <%--就是显示到浏览器上页面的代码--%>


<%--Servlet:
其实就一个运行在web服务器上的小的Java程序，
用于处理从web客户端发送的请求，并且对请求作出响应 --%>
<%--编写一个Java类实现Servlet的接口--%>
<%--配置Servlet--%>


<%--<Host name="www.baidu.com"  appBase="C:\web_page" -->--%>
  <%--unpackWARs="true" autoDeploy="true">--%>
  <%--<!-- hosts path:C:\Windows\System32\drivers\etc -->--%>
  <%--<Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"--%>
         <%--prefix="localhost_access_log." suffix=".txt"--%>
         <%--pattern="%h %l %u %t &quot;%r&quot; %s %b"/>--%>
  <%--<Context path="/" docBase ="web_page"></Context>--%>
<%--</Host>--%>