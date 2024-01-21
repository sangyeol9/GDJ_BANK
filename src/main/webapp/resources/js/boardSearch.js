let list = document.getElementById("searchList");
let val = document.getElementsByClassName("searchVal");
let btn = document.getElementById("searchBtn");

btn.addEventListener("click",(e) => {
   
    for(let i=0; i<val.length;i++){
        if(val[i].selected == true){
      val[i].setAttribute("selected",true);
      break;
      }
    }
   

})
