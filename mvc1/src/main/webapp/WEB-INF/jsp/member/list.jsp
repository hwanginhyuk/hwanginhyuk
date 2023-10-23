<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script>
 window.onload=function(){}
 </script>
</head>
<body>
<a href="<%=request.getContextPath()%>/menu.html">메뉴</a><br/>
<%
List<MemberBean> list=(List<MemberBean>)request.getAttribute("memberlist");
for(MemberBean bean:list){
out.print("<a href='#'>");	
out.print(bean.getId());
out.print("</a><br/>");
}
%>
</body>
</html>