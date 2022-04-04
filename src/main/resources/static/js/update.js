// (1) 회원정보 수정
function update(userId, event) {

    let data = $("#profileUpdate").serialize();

    $.ajax({
        type: "put",
        url: "/api/user/${userId}",
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json"
    }).done(res => {
        location.href='/user/${userId}'
        console.log("success")
    }).fail(error => {
        console.log("fail")
    });

}