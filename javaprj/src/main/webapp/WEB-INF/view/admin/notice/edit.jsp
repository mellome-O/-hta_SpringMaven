<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="shortcut icon" href="">
<link href="../css/style.css" type="text/css" rel="stylesheet">

</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<!-- --- visual block----------------------------------------------------------------------------------->
	<div id="visual">
		<div class="content-box" style="position: static">

			<!-- <div style="
            width:100px; height:100px; border:1px solid red;
        background: url(https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png);
        background-size: cover;
        background-attachment:fixed;">
        <span style="left:1000px; top:1000px; position:absolute;">왜저랩사진</span>
      <img src="https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png"> -->
			<!-- <span style="margin-left:-50px">웅이왜저랩사진</span> -->
			<!-- <img src="http://cdn.sketchpan.com/member/m/mssng486/mandala/1332657085387/0.png"> -->
			<!-- </div> -->
		</div>
	</div>
	<!-- --- body block----------------------------------------------------------------------------------->
	<div id="body">
		<div class="content-box">
			<jsp:include page="../../inc/aside.jsp"></jsp:include>
			<main>
			<section>
				<h1>공지사항</h1>

				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>

				<section>
					<form action="edit" method="post">
						<h1>공지사항 내용</h1>
						<table>
							<tbody>
								<tr>		
									<th>카테고리</th>
									<td>
									<select name="category">
									<option value ="학습">학습</option>
									<option value ="결제">결제</option>
									<option value ="기타">기타</option>
									</select>
									</td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input name="title" value="${notice.title}"></td>
								</tr>
								<tr>
									<th>작성일</th>
									<td>${notice.regDate}</td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea name="content">${notice.content}</textarea></td>
								</tr>
							</tbody>
						</table>
						<div>
							<input type="hidden" name="id" value="${notice.id}"> <input
								type="submit" value="저장">
							<!-- <input type="submit" value="취소" onclick="history.back(-1);"> -->
							<a href="detail?id=${notice.id}">취소</a>
						</div>
					</form>
				</section>

				<tbody>
					<c:forEach var="n" items="${list}">
						<tr>
							<td class="num">${n.id}</td>
							<td class="title"><a href="detail?id=${n.id}">
									${n.title} <span>[23]</span>
							</a></td>
							<td class="writer">${n.writerId}</td>
							<td class="date">${n.regDate}</td>
							<td class="hit">${n.hit}</td>
						</tr>
					</c:forEach>

					<!--     <tr>
                                    <td class="num">2</td>
                                    <td class="title">유투브에 jQuery와 Angular 프레임워크 1강이 등록되었습니다.</td>
                                    <td class="writer">newlec</td>
                                    <td class="date">2019-02-18</td>
                                    <td class="hit">177</td>
                                </tr>

                                <tr>
                                    <td class="num">1</td>
                                    <td class="title">앞으로 모든 강의를 무료로 새로 시작합니다.</td>
                                    <td class="writer">newlec</td>
                                    <td class="date">2018-11-18</td>
                                    <td class="hit">767</td>
                                </tr> -->
				</tbody>
				</table>
			</section>

			</main>
			<!-- <div style="clear:left;">막내</div> -->
		</div>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>

</html>