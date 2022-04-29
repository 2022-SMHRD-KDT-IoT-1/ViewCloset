<%@page import="kr.board.entity.Inquiry"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function goForm() {
		location.href = "${cpath}/boardInsertForm.do";
	}
</script>
<style type="text/css">
.panel-default>.panel-heading, .panel-footer {
	background-color: #445963 !important;
	color: white;
}

#maintext, #maintext2 {
	background-color: #1b3039 !important;
	color: #eaeaea;
}

#navcolor {
	background-color: #708690;
	color: #eaeaea;
}

a:link {
	color: #1b3039;
}
</style>

</head>
<body>


	<ul class="nav nav-tabs" id="navcolor">
		<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
		<li><a data-toggle="tab" href="#menu1">문의사항</a></li>
		<!-- <li><a data-toggle="tab" href="#menu2">Menu 2</a></li> -->
	</ul>
	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<div class="jumbotron text-center" id="maintext">
				<h1>View Cloèst</h1>
				<p>Clothing analysis and location storage service</p>
			</div>
			<div class="container">
				<h1>뷰 클로제는</h1>

				<blockquote>
					<p>고객님이 소유한 의류 분석 및 위치 저장 서비스를 통해 고객 여러분의 간편한 패션 생활을 추구합니다.</p>
					<footer>@MATCH&FIX</footer>
				</blockquote>
			</div>


			<div class="container">
				<div class="row">

					<!--  <form class="form-horizontal" action="/action_page.php">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">관리자 ID:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" placeholder="Enter id">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">관리자 비밀번호:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">로그인</button>
      <button type="submit" class="btn btn-default">회원가입</button>
    </div>
  </div>
</form>
-->

					<div class="col-sm-6">
						<h3>SNS</h3>
						<a href="#"><p>카카오톡</p></a> <a href="#"><p>인스타그램</p></a> <a
							href="#"><p>유튜브</p></a>
					</div>

					<div class="col-sm-6">
						<h3>062-655-3509</h3>
						<p>평일상담: 10:00 ~ 17:00</p>
						<p>점심시간: 12:00 ~ 14:00</p>
					</div>
				</div>
			</div>
		</div>
		<div id="menu1" class="tab-pane fade">
			<div id="home" class="tab-pane fade in active">
				<div class="jumbotron text-center" id="maintext2">
					<h1>View Cloèst</h1>
					<p>Clothing analysis and location storage service</p>
				</div>
				<div class="container">
					<div class="panel panel-default">
						<div class="panel-heading">뷰 클로제 고객문의 내역</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<td>순차</td>
										<td>문의종류</td>
										<td>기타문의</td>
										<td>상세문의</td>
										<td>이메일</td>
										<td>작성일</td>
									</tr>
								</thead>
								<c:forEach var="vo" items="${list }">
									<c:url var="contentlink" value="/inquiryContent.do/${vo.idx }">
										<!--<c:param name="idx" value="${vo.idx}"></c:param>-->
									</c:url>
									<tbody>
										<tr>
											<td>${vo.idx }</td>
											<td><a href="${contentlink}">${vo.in_check}</a></td>
											<td>${vo.in_other }</td>
											<td>${vo.in_content }</td>
											<td>${vo.in_email }</td>
											<td>${vo.in_date}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
						<div class="panel-footer">@MATCH&FIX</div>
					</div>
				</div>
			</div>
</body>
</html>