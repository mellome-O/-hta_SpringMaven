
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
<link rel="shortcut icon" href="">
<meta charset="UTF-8">
<title>Document</title>

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
					<h1>공지사항 내용</h1>
					<table>
						<tbody>
							<tr>
								<th>제목</th>
								<td>${notice.title}</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${notice.regDate}</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td>
								<c:forEach var="file" items="${noticeFiles}">
								<a href="/upload/${file.name}" download>${file.name}</a>
								</c:forEach>
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${notice.content}</td>
							</tr>
						</tbody>
					</table>
					<div>
						<a href="edit?id=${notice.id}">수정</a> <a
							href="del?id=${notice.id}">삭제</a>
					</div>
				</section>
				<section>
                   <h1></h1>
                   <ul>
                      <li><span>이전글</span><a href="detail?id=${prev.id}">${prev.title}</a></li>
                      <li><span>다음글</span><a href="detail?id=${next.id}">${next.title}</a></li>
                   </ul>
                </section>
				
				


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