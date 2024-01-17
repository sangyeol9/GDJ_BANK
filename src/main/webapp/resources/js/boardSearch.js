const pager = document.getElementsByClassName('pager');
const searchForm = document.getElementById('searchForm');
const page = document.getElementById('page');
const kind= document.getElementById('kind');
const a = document.getElementsByClassName('a');

let k =  kind.getAttribute('data-kind');

for(let i =0;i<a.length;i++){
    if(a[i].value == k){
    a[i].setAttribute('selected',ture)
    break;
    }
}

for(let i = 0;i<pager.length;i++){
    
    pager[i].addEventListener("click",(e)=>{
       // e.preventDefault();
        console.log(e.target.getAttribute('data-page'));
       let p = e.target.getAttribute("data-page");
      // page.value=p;
    })
}

// for(p of pager){
//     p.addEventListener("click",(e) =>{
//         e.preventDefault();
//         let page = p.getAttribute("date-page");
//         console.log(page);
//         //searchForm.submit();
//     })
//   }