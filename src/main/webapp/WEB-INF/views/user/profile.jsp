<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!--Profile section-->
<section class="profile">
	<!--User info container-->
	<div class="profileContainer">

		<!--User image-->
		<div class="profile-left">
			<div class="profile-img-wrap story-border"
				onclick="popup('.modal-image')">

				<form id="userProfileImageForm">
					<input type="file" name="profileImageFile" style="display: none;"
						id="userProfileImageInput" />
				</form>

				<img class="profile-image" src="/upload/${dto.user.profileImageUrl}"
					onerror="this.src='/images/person.jpeg'" id="userProfileImage" />
			</div>
		</div>
		<!--User image end-->

		<!--User info, upload photo, subscribe-->
		<div class="profile-right">
			<div class="name-group">
				<h2>${dto.user.name}</h2>

				<c:choose>
					<c:when test="${dto.pageOwnerState}">
						<button class="cta" onclick="location.href='/image/upload'">Upload post</button>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${dto.subscribeState}">
								<button class="cta" onclick="toggleSubscribe(${dto.user.id}, this)">Unfollow</button>
							</c:when>
							<c:otherwise>
								<button class="cta blue" onclick="toggleSubscribe(${dto.user.id},this)">Follow</button>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>

				<button class="modi" onclick="popup('.modal-info')">
					<i class="fas fa-cog"></i>
				</button>
			</div>

			<div class="subscribe">
				<ul>
					<li><a href=""> Posts<span>${dto.imageCount}</span>
					</a></li>
					<li><a href="javascript:subscribeInfoModalOpen(${dto.user.id});"> Following<span>${dto.subscribeCount}</span>
					</a></li>
				</ul>
			</div>
			<div class="state">
				<h4>${dto.user.bio}</h4>
				<h4>${dto.user.website}</h4>
			</div>
		</div>
		<!--User info, upload photo, subscribe end-->

	</div>
</section>

<!--Post section-->
<section id="tab-content">
	<!--Post container-->
	<div class="profileContainer">
		<!--Just-->
		<div id="tab-1-content" class="tab-content-item show">
			<!--Post container, GRID-->
			<div class="tab-1-content-inner">

				<!--Items-->
				<c:forEach var="image" items="${dto.user.images}">
					<div class="img-box">
						<a href=""> <img src="/upload/${image.postImageUrl}" />
						</a>
						<div class="comment">
							<a href="#" class=""> <i class="fas fa-heart"></i><span>${image.likeCount}</span>
							</a>
						</div>
					</div>
				</c:forEach>
				<!--Items end-->
			</div>
		</div>
	</div>
</section>

<!--Logout, edit user info modal-->
<div class="modal-info" onclick="modalInfo()">
	<div class="modal">
		<button onclick="location.href='/user/1/update'">Edit user info</button>
		<button onclick="location.href='/logout'">Logout</button>
		<button onclick="closePopup('.modal-info')">Cancel</button>
	</div>
</div>
<!--Logout, edit user info modal end-->

<!--Change profile photo modal-->
<div class="modal-image" onclick="modalImage()">
	<div class="modal">
		<p>Change profile photo</p>
		<button onclick="profileImageUpload(${dto.user.id}, ${principal.user.id})">Upload photo</button>
		<button onclick="closePopup('.modal-image')">Cancel</button>
	</div>
</div>

<!--Change profile photo modal end-->

<div class="modal-subscribe">
	<div class="subscribe">
		<div class="subscribe-header">
			<span>Following</span>
			<button onclick="modalClose()">
				<i class="fas fa-times"></i>
			</button>
		</div>

		<div class="subscribe-list" id="subscribeModalList">

		</div>
	</div>

</div>

<script src="/js/profile.js"></script>

<%@ include file="../layout/footer.jsp"%>
