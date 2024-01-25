const wish = document.getElementById("wish");
const checkAll = document.getElementById("checkAll");
const wishlist = document.getElementsByClassName("wishlist");
wish.addEventListener("click",function(e){
    let pn = e.target.getAttribute("data-wish")
    
    // fetch("/wishlist/add?productNum="+pn,{
    //     method:'GET'
    // })
    // .then(response => response.text())
    // .then(response=>{console.log(response)})

    $.ajax({
        url : '/wishlist/add',
        method : 'GET',
        data : {
            productNum : pn
        },
        success : function(){
            if(confirm("장바구니로 이동하겠니?")){
                location.href="/wishlist/list"
            }
            else{
                location.href="/product/list"
            }
        },
        error : function(){
            alert("에러났어요!")
        }
    })
        
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