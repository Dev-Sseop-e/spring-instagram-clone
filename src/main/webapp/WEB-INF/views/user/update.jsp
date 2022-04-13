<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!--Profile setting main-->
<main class="main">
	<!--Profile setting section-->
	<section class="setting-container">
		<!--Profile setting article-->
		<article class="setting__content">

			<!--Profile setting id range-->
			<div class="content-item__01">
				<div class="item__img">
					<img src="#" onerror="this.src='/images/person.jpeg'" />
				</div>
				<div class="item__username">
					<h2>${principal.user.username}</h2>
				</div>
			</div>
			<!--Profile setting id range end-->

			<!--Profile edit-->
			<form id="profileUpdate" onsubmit="update(${principal.user.id}, event)">
				<div class="content-item__02">
					<div class="item__title">Name</div>
					<div class="item__input">
						<input type="text" name="name" placeholder="Name"
							value="${principal.user.name}" required="required" />
					</div>
				</div>
				<div class="content-item__03">
					<div class="item__title">Username</div>
					<div class="item__input">
						<input type="text" name="username" placeholder="Username"
							value="${principal.user.username}" readonly="readonly" />
					</div>
				</div>
				<div class="content-item__04">
					<div class="item__title">Password</div>
					<div class="item__input">
						<input type="password" name="password" placeholder="Password" required="required" />
					</div>
				</div>
				<div class="content-item__05">
					<div class="item__title">Website</div>
					<div class="item__input">
						<input type="text" name="website" placeholder="Website"
							value="${principal.user.website}" />
					</div>
				</div>
				<div class="content-item__06">
					<div class="item__title">Bio</div>
					<div class="item__input">
						<textarea name="bio" id="" rows="3">${principal.user.bio}</textarea>
					</div>
				</div>
				<div class="content-item__07">
					<div class="item__title"></div>
					<div class="item__input">
						<span><b>Privacy</b></span> <span>Enter your personal information even if the account is used for business or pets.
							It is not included in public profiles.</span>
					</div>
				</div>
				<div class="content-item__08">
					<div class="item__title">Email</div>
					<div class="item__input">
						<input type="text" name="email" placeholder="Email"
							value="${principal.user.email}" readonly="readonly" />
					</div>
				</div>
				<div class="content-item__09">
					<div class="item__title">Phone number</div>
					<div class="item__input">
						<input type="text" name="phone" placeholder="Phone number"
							value="${principal.user.phone}" />
					</div>
				</div>
				<div class="content-item__10">
					<div class="item__title">Gender</div>
					<div class="item__input">
						<input type="text" name="gender" value="${principal.user.gender}" />
					</div>
				</div>

				<!--Submit button-->
				<div class="content-item__11">
					<div class="item__title"></div>
					<div class="item__input">
						<button>Submit</button>
					</div>
				</div>
				<!--Submit button end-->

			</form>
			<!--Profile edit form end-->
		</article>
	</section>
</main>

<script src="/js/update.js"></script>

<%@ include file="../layout/footer.jsp"%>
