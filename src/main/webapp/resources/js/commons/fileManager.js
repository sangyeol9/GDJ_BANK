
const fileAdd = document.getElementById('fileAdd');
const fileList = document.getElementById('fileList');
let coin =0;
fileAdd.addEventListener("click",function(){
    if(coin>=5){ 
        alert("5개 이하로 하시오");
        return;
    }
    console.log('fileManager');
    let div = document.createElement('div');
    let ac = document.createAttribute('class');
    let acc = document.createAttribute('id');
    acc.value = 'id'+coin;
    ac.value = 'input-group';
    div.setAttributeNode(ac);
    div.setAttributeNode(acc);
    let inp = document.createElement('input');
    let i1 = document.createAttribute('class');
    i1.value = 'form-control';
    let i2 = document.createAttribute('type');
    i2.value = 'file';
    let i3 = document.createAttribute('name');
    i3.value = 'attachs';
    inp.setAttributeNode(i1);
    inp.setAttributeNode(i2);
    inp.setAttributeNode(i3);
    
    div.appendChild(inp);

    let sp = document.createElement('span');
    let sp1 = document.createAttribute('class');
    sp1.value = 'input-group-text text-danger sp1';
    let spt = document.createTextNode('X');
    sp.setAttributeNode(sp1);
    sp.appendChild(spt);
	
    div.appendChild(sp);
    console.log(div);
    fileList.appendChild(div);
    coin++;

    /*

    filelist.addEventListener('click',(e)=>{
        console.log(e.target);

    })

    */

    if(coin>0){
        let span = document.getElementsByClassName('input-group-text text-danger sp1');
        let di = document.getElementsByClassName('input-group');
        console.log(span.length);
        for(let i=0; i<span.length;i++){
        span[i].addEventListener("click",function(){
           let del = document.getElementById("id"+i);
           del.remove();
           coin--;
           
        })
           
        }
        
        }

})

