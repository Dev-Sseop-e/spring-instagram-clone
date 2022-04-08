/**
  1. 유저 프로파일 페이지
  (1) 유저 프로파일 페이지 구독하기, 구독취소
  (2) 구독자 정보 모달 보기
  (3) 구독자 정보 모달에서 구독하기, 구독취소
  (4) 유저 프로필 사진 변경
  (5) 사용자 정보 메뉴 열기 닫기
  (6) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
  (7) 사용자 프로파일 이미지 메뉴(사진업로드, 취소) 모달 
  (8) 구독자 정보 모달 닫기
 */

// (1) 유저 프로파일 페이지 구독하기, 구독취소
function toggleSubscribe(toUserId, obj) {
	if ($(obj).text() === "Unfollow") {
		$.ajax({
			type: "post",
			url: "/api/subscribe/" + toUserId,
			dataType: "json"
		}).done(res => {
			$(obj).text("Follow");
			$(obj).toggleClass("blue");
		}).fail(error => {
		});
	} else {
		$.ajax({
			type: "delete",
			url: "/api/subscribe/" + toUserId,
			dataType: "json"
		}).done(res => {
			$(obj).text("Unfollow");
			$(obj).toggleClass("blue");
		}).fail(error => {
		});
	}
}

// (2) 구독자 정보  모달 보기
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

function getSubscribeModalItem(u) {
	let item = `<div class="subscribe__item" id="subscribeModalItem-${u.id}">
\t<div class="subscribe__img">
\t\t<img src="/upload/${u.profileImageUrl}" onerror="this.src='/images/person.jpeg'"/>
\t</div>
\t<div class="subscribe__text">
\t\t<h2>${u.username}</h2>
\t</div>
\t<div class="subscribe__btn">`;
	if(!u.equalUserState) {
		if(u.subscribeState) {
			item += `\t\t<button class="cta" onclick="toggleSubscribe(${u.id}, this)">Unfollow</button>`;
		} else {
			item += `\t\t<button class="cta blue" onclick="toggleSubscribe(${u.id}, this)">Follow</button>`;
		}
	}
	item += `
\t</div>
</div>`;
	return item;
}

// (3) 유저 프로파일 사진 변경 (완)
function profileImageUpload() {
	$("#userProfileImageInput").click();

	$("#userProfileImageInput").on("change", (e) => {
		let f = e.target.files[0];

		if (!f.type.match("image.*")) {
			alert("이미지를 등록해야 합니다.");
			return;
		}

		// 사진 전송 성공시 이미지 변경
		let reader = new FileReader();
		reader.onload = (e) => {
			$("#userProfileImage").attr("src", e.target.result);
		}
		reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
	});
}

// (4) 사용자 정보 메뉴 열기 닫기
function popup(obj) {
	$(obj).css("display", "flex");
}

function closePopup(obj) {
	$(obj).css("display", "none");
}


// (5) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
function modalInfo() {
	$(".modal-info").css("display", "none");
}

// (6) 사용자 프로파일 이미지 메뉴(사진업로드, 취소) 모달
function modalImage() {
	$(".modal-image").css("display", "none");
}

// (7) 구독자 정보 모달 닫기
function modalClose() {
	$(".modal-subscribe").css("display", "none");
	location.reload();
}






