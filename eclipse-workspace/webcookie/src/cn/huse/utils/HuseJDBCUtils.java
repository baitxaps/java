package cn.huse.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class HuseJDBCUtils {
    // A static connectionPool ,to run only 1 exec
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // Get connectionPool method
    public static Connection getConnection()throws SQLException {
        return dataSource.getConnection();
    }

    // Get the connectionPool
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void release(Statement stmst, Connection conn) {
        if (stmst != null) {
            try {
                stmst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmst = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}



//<% // 注释内容 %>    <% /* 注释内容 */ %>

/*
 *
 *274
https://m.hehuoya.com/
HTML的注释:存在JSP的源码中，翻译成Servlet后这个注释也存在，在生成HTML响应到页面的时候这个注释也会存在
 <!-- 注释内容 -->
 
Java代码的注释:存在JSP的源码中，翻译成Servlet后Java代码的注释也会存在，但是生成HTML响应到页面后，这种注释就消失了
JSP注释:存在JSP的源码中，翻译Servlet后注释就没有了
JSP页面中的隐藏注释使用“<%--”和“--%>”创建，eg:<%-- 注释内容 --%>

JSP指令元素的语法：<%@ 指令名称 属性名称=属性的值 属性名称=属性的值 %>
JSP指令元素的分类：
	page指令：指示JSP的页面设置属性和行为
	include指令：指示JSP包含哪些其他页面
	taglib指令：指示JSP页面包含哪些标签库

Page指令属性
	language属性：声明使用脚本的语言。只能是java。
	extends属性：	标明JSP编译成Servlet的时候继承的类。默认值：HttpJspBase。
	session属性：		标明JSP中是否可以直接使用session对象。默认值是true。
	buffer属性：		标明JSP对客户端输出缓冲区大小。默认值8kb。
	autoFlush属性：	如果缓冲区大小溢出，是否自动刷出。默认true。
	import属性：		用于导入Java包或类。
	contentType属性：标明JSP被浏览器解析和打开的时候采用的默认的字符集。
	pageEncoding属性：JSP文件及JSP翻译后的Servlet保存到硬盘上采用字符集。
	isErrorPage属性：	处理JSP页面异常。
	errorPage属性：	处理JSP页面异常。
	isELIgnored属性：	通知JSP是否忽略EL表达式

JSP的内置对象：指的是可以直接在JSP页面中使用的对象
JSP当中有9大内置对象：
	request		：从客户端向服务器发送的请求对象
	response	：从服务器端向客户端作出响应对象
	session		：服务器为客户端创建会话对象
	application	：代表应用。获得的ServletContext对象。
	out			：向输出流写入内容的对象。
	page		：当前的JSP翻译成Servlet后的对象的引用。
	pageContext	：本JSP的页面的上下文对象。
	config		：本JSP的ServletConfig对象。
	exception	：表示JSP页面运行时产生的异常对象。
JSP的内置对象具体类型
	request		HttpServletRequest
	response	HttpServletResponse
	session		HttpSession
	application	ServletContext
	config		ServletConfig
	page		Object
	pageContext	PageContext
	out			JspWriter
	exception	Throwable

PageScope：页面范围。
	页面范围指的是在当前的页面内有效，出了这个页面，用pageContext保存的数据就无效了。
RequestScope：请求范围。
	从客户端向服务器发送一次请求，服务器对这次请求作出了响应之后，用request保存的数据就无效了。
SessionScope：会话范围。
	每个浏览器向服务器发送请求（多次请求）。将该会话结束。
ApplicationScope：应用范围。
	在整个应用中任意的地方都可以获取

JSP的动作标签用于在JSP页面中提供业务逻辑功能，避免在JSP页面中直接编写Java代码，造成jsp页面难以维护
常用的动作标签
<jsp:forward/>	：请求转发。
<jsp:include/>：包含（动态包含）。
<jsp:param/>：传递参数


EL和JSTL一起使用取代JSP页面中嵌入Java代码写法
EL获取数据
EL执行运算
EL获取web开发常用的对象
EL调用Java方法
语法：${ EL表达式 }


*/







