<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">


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
		

</html>