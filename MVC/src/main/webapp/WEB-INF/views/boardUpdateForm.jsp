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
</head>
<body>
 
<div class="container">
  <h2>Spring MVC 01</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    	<form action="${cpath }/boardUpdate.do" method="post">
    		<input type="hidden" name="idx" value="${vo.idx }">
    	<table class="table table-bordered">
    		<tr>
    			<td>제목</td>
    			<td><input type="text" class="form-control" name="title" value="${vo.title }"></td>
    		</tr>
    		<tr>
    			<td>내용</td>
    			<!--<td>${fn:replace(vo.content,newLineChar,"<br>") }</td>-->
    			<td><textarea rows="10" class="form-control" name="content">${vo.content }</textarea></td>
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
    				<button type="submit" class="btn btn-primary btn-sm">수정</button>
    				<button type="reset" class="btn btn-warning btn-sm">취소</button>
    				<a href="<c:url value='/boardList.do' />" class="btn btn-info btn-sm" role="button">목록</a>
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
    <div class="panel-footer">지능형 IoT융합 SW전문가과정(박하연)</div>
  </div>
</div>

</body>
</html>
