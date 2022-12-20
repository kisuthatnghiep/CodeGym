function doitien(){
let    Amount=document.getElementById("Amount").value;
 let   To =document.getElementById("To").value;
    let   From =document.getElementById("From").value;
    let Result="Result: " +Amount*To/From
// if (Froma == "USD" && Toa == "USD") {
//      Result ="Result: "+ Amount+"$";
// }
// else if(Froma=="VNĐ" && Toa=="USD"){
//          Result ="Result: "+ Amount / 23000+"$";
//     }
//         else if(Froma=="USD" && Toa=="VNĐ") {
//     Result = "Result: " + Amount * 23000 + "VNĐ";
// }
// else if(Froma=="VNĐ" && Toa=="VNĐ"){
//         Result ="Result: "+ Amount+"VNĐ";
// }
//
//     else if (Froma == "USD" && Toa == "YEN") {
//         Result ="Result: "+Amount*144+"¥";
//     }
//     else if(Froma=="YEN" && Toa=="USD") {
//         Result ="Result: " +Amount /144 + "$";
//     }
//     else if (Froma == "VNĐ" && Toa == "YEN") {
//         Result ="Result: "+ Amount/163+"¥";
//     }
//     else if(Froma=="YEN" && Toa=="VNĐ"){
//         Result ="Result: "+ Amount*163+"VNĐ";
//     }
//     else{
//         Result ="Result: "+ Amount+"¥";
//     }

            document.getElementById("Result").innerHTML= Result;
            }