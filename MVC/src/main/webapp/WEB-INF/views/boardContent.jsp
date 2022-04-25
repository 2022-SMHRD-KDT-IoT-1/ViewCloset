<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<%pageContext.setAttribute("newLineChar", "\n"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.panel-default>.panel-heading, .panel-footer{
background-color:#445963 !important;
color:#eaeaea;
}
#maintext{
background-color:#1b3039 !important;
color:#eaeaea;
}
</style>
</head>
<body>
<!-- <ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
  <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
  <!-- <li><a data-toggle="tab" href="#menu2">Menu 2</a></li> -->
</ul>
<!-- <div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    <h3>HOME</h3>
    <p>Some content.</p>
  </div>--> 
<div id="home" class="tab-pane fade in active">
    <div class="jumbotron text-center" id="maintext">
  <h1>View Cloèst</h1>
  <p>Clothing analysis and location storage service</p>
</div>
<div class="container">

  <div class="panel panel-default">
    <div class="panel-heading">문의 내역 상세보기</div>
    <div class="panel-body">
    	<table class="table">
    		<tr>
    			<td>제목</td>
    			<td>${vo.title }</td>
    		</tr>
    		<tr>
    			<td>내용</td>
    			<td>${fn:replace(vo.content,newLineChar,"<br>") }</td>
    		</tr>
    		<tr>
    			<td>작성자</td>
    			<td>${vo.writer }</td>
    		</tr>
    		<tr>	
    			<td>작성일</td>
    			<td>${fn:split(vo.indate," ")[0] }</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<a href="<c:url value='/boardUpdateForm.do/${vo.idx }' />" class="btn btn-primary btn-sm" role="button">수정</a>
    				<a href="<c:url value='/boardDelete.do/${vo.idx }' />" class="btn btn-warning btn-sm" role="button">삭제</a>
    				<a href="<c:url value='/boardList.do' />" class="btn btn-info btn-sm" role="button">목록</a>
    			</td>
    		</tr>
    	</table>
    </div>
    <div class="panel-footer">@MATCH&FIX</div>
  </div>
</div>

</body>
</html>
