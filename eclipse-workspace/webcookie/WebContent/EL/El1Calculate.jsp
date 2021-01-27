<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>el get array data</h1>
<%
String[] arrs = {"aa","bb"};
pageContext.setAttribute("arrs",arrs);
%>
${arrs[0]}
${arrs[1]}

<h1>el get list data</h1>
<%
 List<String> list= new ArrayList<String>();
 list.add("1");
 list.add("2");
 pageContext.setAttribute("list",list);
%>
${ list[0] }
${ list[1] }

<h1>el get map data</h1>
<%
 Map<String,Integer> map= new HashMap<String,Integer>();
 map.put("a",1);
 map.put("b",2);
 map.put("c.c",3);
 pageContext.setAttribute("map",map);
%>
${ map.a }
${ map.b }
${ map["c.c"] }

<h1>el calculate the data</h1>
<%
 pageContext.setAttribute("n1",20);
 pageContext.setAttribute("n2","30");
 pageContext.setAttribute("n3",20);
 pageContext.setAttribute("n4","50");
%>
${ n1+n2 } <br/>
${n1 <n2 } -- ${n1 lt n2 } <br/>
${n1 >n2 } -- ${n1 gt n2 } <br/>
${n1 ==n2 } -- ${n1 eq n2 } <br/>
${n1 >=n2 } -- ${n1 ge n2 } <br/>
${n1 <=n2 } -- ${n1 le n2 } <br/>
${n1 !=n2 } -- ${n1 ne n2 } <br/>

${(n1 !=n2)  && (n3<n4) } -- ${(n1 != n2) and (n3<n4) } <br/>
${!(n1 <=n2) || (n3<n4) } -- ${not (n1 < n2) or (n3<n4) } <br/>

${ n1 < n2 ? "n1 less than n2" : "n1 not equal to n2" }

${ not  empty user }
</body>
</html>

















