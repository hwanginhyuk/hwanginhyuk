<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/dashboard.css"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
body{margin:30px;}
</style>
<script>
$(document).ready(function() {
	$("#listButton").click(clickFunc);
});
function clickFunc() {
	$.ajax({
		url:"<%=request.getContextPath()%>/member/ajaxlist.do",
		dataType:"json",
		success:function(data){
			const buffer=['<table class="table table-hover">'];
				buffer.push('<tr>);
				buffer.push('<td>ID</td>');
				buffer.push('<td>PW</td>');
				buffer.push('<td>ADDR</td>');
				buffer.push('<td>TEL</td>');
				buffer.push('</tr>);
			json.memberlist.forEach(member=>{
				buffer.push('<tr>');
				buffer.push("<li>"+member.id+"</li>");
				buffer.push("<li>"+member.pw+"</li>");
				buffer.push("<li>"+member.addr+"</li>");
				buffer.push("<li>"+member.tel+"</li>");
				buffer.push('</tr>');
			});
			buffer.push("</table>");
			$("#listContainer").text(data).html(buffer.join(""));
		}
	});
}
 </script>
</head>
<body>
<h1>:: 메뉴 ::</h1>
<a href="<%=request.getContextPath()%>/member/list.do">회원리스트</a><br/>
<a href="#" id="listButton" >회원리스트(AJAX)</a><br/>
<div id="listContainer"></div>
</body>
</html>



