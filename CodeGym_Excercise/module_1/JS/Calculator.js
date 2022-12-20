// let so1=document.getElementById(so1).value;
// let   so2=document.getElementById(so2).value;
function cong(){
let so1=+document.getElementById("so1").value;
 let   so2=+document.getElementById("so2").value;
  let Result="Result Addition: "+(so1+so2);
    document.getElementById("result").innerHTML=Result;
}
function tru(){
    let so1=+document.getElementById("so1").value;
    let   so2=+document.getElementById('so2').value;
 let Result="Result Subtraction: "+(so1-so2);
    document.getElementById("result").innerHTML=Result;

}
function nhan(){
    let so1=+document.getElementById('so1').value;
    let   so2=+document.getElementById('so2').value;
 let Result="Result Multiplication: "+(so1*so2);
    document.getElementById("result").innerHTML=Result;
}
function chia(){
    let so1=+document.getElementById('so1').value;
    let   so2=+document.getElementById('so2').value;
 let Result="Result Division: "+(so1/so2);
    document.getElementById("result").innerHTML=Result;
}
