const b1 = document.getElementById("b1");
const b2 = document.getElementById("b2");

b1.addEventListener("click",(e) => {
    b1.innerHTML = "test";
})

//
$("#b2").click( ()=>{

});

$('#b2').on("click",function(){
    $('#b2').html('test');
    $('#b2').attr('속성명')
    $('#b2').attr('속성명','value')
    $('#b2').prop('속성명')
    $('#b2').pro('속성명','value')
    
})