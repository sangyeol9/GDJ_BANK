const checkAll = document.getElementById("checkAll");
const wishlist = document.getElementsByClassName("wishlist");
const btn = document.getElementById("btn");

btn.addEventListener("click",function(){
let ar = [];
    for(let i =0; i<wishlist.length;i++){
        
        if(wishlist[i].checked)
        {
            ar.push(wishlist[i].value)
        }
    }
    $.ajax({
        method:'post',
        url : '/wishlist/delete',
        traditional : true,
        data : {
            productNum : ar
        },
        success : function(res){
          if(res.trim()>0){
            //location.reload();
            for(let i =0; i<wishlist.length;i++){
                if(wishlist[i].checked){
                wishlist[i].parentNode.parentNode.remove();
                i--;
                }
             }
          }              
        },
        error : function(er){
            alert("실패")
        }
    })
    console.log(ar);
})

checkAll.addEventListener("click",function(){
    console.log('checkAll')
    if(checkAll.checked)
        for(let i=0; i<wishlist.length;i++){
            wishlist[i].checked = true;
        }
    else 
        for(let i=0; i<wishlist.length;i++){
             wishlist[i].checked = false;
        }   
})

for(let i=0; i<wishlist.length;i++){
    wishlist[i].addEventListener("click",function(){
        console.log('check');
        let count = 0;
        for(let i=0; i<wishlist.length;i++){
            if(wishlist[i].checked){
                count++;
            }
        }
        if(wishlist.length==count)
        checkAll.checked = true;
        else checkAll.checked= false;
    })
}