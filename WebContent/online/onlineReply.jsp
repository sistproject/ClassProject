<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="tab_panel_title">수강평</div>
	<c:if test="${sessionScope.id!=null }">
		<button>
			<table class="table">
				<tr>
					<td><textarea rows="10" cols="100" name="msg"></textarea> <%--<c:set var="page" value="${param.page}"/> 
								              									<input type="hidden" name=cno value="${page}">--%>
						<input type="hidden" name=cno value="${ondVO.cno}"> 
						<input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger">
						<c:forEach var="rvo" items="${rList }">
							<li>
								<article>
									<header>
										<figure class="avatar">
											<c:if test="${sessionScope.id==rvo.id }">
												<span class="btn btn-xs btn-success updateBtn"
													data-no="${rvo.no }">수정</span>
												<span class="btn btn-xs btn-danger delBtn"
													data-no="${rvo.no }" data-cno="${ondVO.cno }">삭제</span>
											</c:if>
										</figure>
										<address>
											By <a href="#">${rvo.name }</a>
										</address>
										<time datetime="2045-04-06T08:15+00:00">${rvo.dbday }</time>
									</header>
									<div class="comcont">
										<pre style="white-space: pre-wrap; border: none; background-color: white;">${rvo.msg }</pre>
									</div>
								</article>
							</li>
							<li style="display: none" id="m${rvo.no }" class="updateli">
								<button>
									<table class="table">
										<tr>
											<td>
												<textarea rows="7" cols="25" name="msg">${rvo.msg }</textarea>
												<input type="hidden" name=cno value="${ondVO.cno }">
												<input type="hidden" name=no value="${rvo.no }"> <input type="submit" value="댓글수정" class="btn btn-sm btn-danger">
											</td>
										</tr>
									</table>
								</button>
							</li>
						</c:forEach>
						</td>
				</tr>
			</table>
		</button>
	</c:if>
</body>
</html>