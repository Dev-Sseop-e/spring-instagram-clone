<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!--Popular posts-->
<main class="popular">
	<div class="exploreContainer">

		<!--Pop posts gallery(GRID)-->
		<div class="popular-gallery">

			<c:forEach var="image" items="${images}">
				<div class="p-img-box">
					<a href="${image.user.id}"> <img src="/upload/${image.postImageUrl}" />
					</a>
				</div>
			</c:forEach>

		</div>

	</div>
</main>

<%@ include file="../layout/footer.jsp"%>
