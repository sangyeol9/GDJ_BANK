console.log("agreement");

const checka = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");
let coin =0;
checka.addEventListener("click",function(){
    if(checka.checked){
        coin +=5;
    for(let i=0;i<document.getElementsByClassName('checks').length;i++){
        document.getElementsByClassName('checks')[i].checked = true;
    }}
    else{
        coin -= 5;
	for(let i=0;i<document.getElementsByClassName('checks').length;i++){
        document.getElementsByClassName('checks')[i].checked = false;
    }}
})
for(let i=0;i<checks.length;i++){
    checks[i].addEventListener("click",function(){
        
            if(this.checked) coin++;
            else coin--;
            console.log(coin);

        if(coin==5) checka.checked = true;
        else checka.checked = false;
        
    })
}


// $('.checks').click(function(){
//     console.log($(this).prop('checked'));
// })