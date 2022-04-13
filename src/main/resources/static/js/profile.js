/**
  1. User profile page
  (1) User profile page subscribe, unsubscribe
  (2) Show subscriber information modal
  (3) Subscribe and unsubscribe in info modal
  (4) Changing user profile photo
  (5) Open or close user info menu
  (6) User information modal
  (7) Profile image menu modal
  (8) Close subscriber info modal
 */

// (1) User profile page subscribe, unsubscribe
function toggleSubscribe(toUserId, obj) {
	if ($(obj).text() === "Unfollow") {
		$.ajax({
			type: "delete",
			url: "/api/subscribe/" + toUserId,
			dataType: "json"
		}).done(res => {
			$(obj).text("Follow");
			$(obj).toggleClass("blue");
		}).fail(error => {
		});
	} else {
		$.ajax({
			type: "post",
			url: "/api/subscribe/" + toUserId,
			dataType: "json"
		}).done(res => {
			$(obj).text("Unfollow");
			$(obj).toggleClass("blue");
		}).fail(error => {
		});
	}
}

// (2) Show subscriber information modal
function subscribeInfoModalOpen(pageUserId) {
	$(".modal-subscribe").css("display", "flex");
	$.ajax({
		url: `/api/user/${pageUserId}/subscribe`,
		dataType: "json"
	}).done(res => {
		console.log(res.data);

		res.data.forEach((u) => {
			let item = getSubscribeModalItem(u);
			$("#subscribeModalList").append(item);
		})
	}).fail(error => {
		console.log("subscription loading fail", error);
	});
}

// (3) Subscribe and unsubscribe in info modal
function getSubscribeModalItem(u) {
	let item = `<div class="subscribe__item" id="subscribeModalItem-${u.id}">
	<div class="subscribe__img">
		<img src="/upload/${u.profileImageUrl}" onerror="this.src='/images/person.jpeg'"/>
	</div>
	<div class="subscribe__text">
		<h2>${u.username}</h2>
	</div>
	<div class="subscribe__btn">`;
	if(!u.equalUserState) {
		if(u.subscribeState) {
			item += `\t\t<button class="cta" onclick="toggleSubscribe(${u.id}, this)">Unfollow</button>`;
		} else {
			item += `\t\t<button class="cta blue" onclick="toggleSubscribe(${u.id}, this)">Follow</button>`;
		}
	}
	item += `
	</div>
</div>`;
	return item;
}

// (4) Changing user profile photo
function profileImageUpload(pageUserId, principalId) {

	if (pageUserId != principalId) {
		return;
	}

	$("#userProfileImageInput").click();

	$("#userProfileImageInput").on("change", (e) => {
		let f = e.target.files[0];

		if (!f.type.match("image.*")) {
			alert("You should upload the image");
			return;
		}

		// send data to form
		let profileImageForm = $("#userProfileImageForm")[0];

		// use FormData object
		let formData = new FormData(profileImageForm);

		$.ajax({
			type: "put",
			url: `/api/user/${principalId}/profileImageUrl`,
			data: formData,
			contentType: false, // need to protect from parsing by x-www-form-urlencoded
			processData: false, // need to protect from parsing by QueryString
			enctype: "multipart/form-data",
			dataType: "json"
		}).done(res => {
			// change image if sending picture success
			let reader = new FileReader();
			reader.onload = (e) => {
				$("#userProfileImage").attr("src", e.target.result);
			}
			reader.readAsDataURL(f); // execute reader.onload
		}).fail(error => {
			console.log("error", error);
		});

	});

}

// (5) Open or close user info menu
function popup(obj) {
	$(obj).css("display", "flex");
}

function closePopup(obj) {
	$(obj).css("display", "none");
}

// (6) User information modal
function modalInfo() {
	$(".modal-info").css("display", "none");
}

// (7) Profile image menu modal
function modalImage() {
	$(".modal-image").css("display", "none");
}

// (8) Close subscriber info modal
function modalClose() {
	$(".modal-subscribe").css("display", "none");
	location.reload();
}
