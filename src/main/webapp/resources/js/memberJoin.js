let password = document.getElementById("password");
let password2 = document.getElementById("password2");
let btn = document.getElementById("Btn");

btn.addEventListener("click",(e) => { 
    if(password.value != password2.value){
        e.preventDefault();
        alert("비밀번호가 일치하지 않습니다.");
        location.href = "/member/join";
    }

})