console.log('joinCheck');

const btn = document.getElementById("Btn");
const p = document.getElementById("password");
const pw2 = document.getElementById("password2")
const pwRe= document.getElementById("pwResult");
const pwRe2 = document.getElementById("pwResult2");
const must = document.getElementsByClassName("must");
p.addEventListener("blur",function(){
    console.log(p.value);
    if(pw2.value != p.value){
      pwRe2.setAttribute("class","no");
      pwRe2.innerText = "비밀번호가 다릅니다";
  }
      else{
      pwRe2.innerText = "비밀번호 일치";
      pwRe2.setAttribute("class","yes");        
      } 

  if(p.value.length < 8 )
  {
    pwRe.innerText = "8글자 이상을 입력하시오";
    pwRe.setAttribute("class","no");
  }
  else{ pwRe.innerText = "양식에 적합";
  pwRe.setAttribute("class","yes");
    }
})

pw2.addEventListener("keyup",function(){
    if(pw2.value != p.value){
    pwRe2.innerText = "비밀번호가 다릅니다";
    pwRe2.setAttribute("class","no");
}
    else{ pwRe2.innerText = "비밀번호 일치";
    pwRe2.setAttribute("class","yes");        
}
})

btn.addEventListener("click",function(){
  let result =0;
  for(let i=0; i<must.length;i++){
    if(must[i].value == "")
    {
      alert("공백없이 입력해라");
      return ;
    }
  }

  if(must[3].value.endsWith('.com')){
    result =1;
  }
  if(result ==0){
      alert("이메일 형식오류")
      return;
    }
  if(pwRe2.getAttribute('class') =='yes')
    if(pwRe.getAttribute("class") == 'yes')
      btn.setAttribute("type","sumbit");
    
  if(pwRe.getAttribute("class") == 'no' )
    alert("비밀번호 8글자 이상 입력")
  else if(pwRe2.getAttribute("class") == 'no')
    alert("2차 비밀번호 확인 필요");
})