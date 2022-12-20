let singer = '';
function referenceDeleteSinger(id) {
    singer = id;
}
function passSelected(){
    let focusElements = document.getElementsByClassName("focus");
    for (let focusElement of focusElements) {
        focusElement.removeAttribute("selected");
    }
    t = document.getElementById(document.getElementById("formGroupExampleInput").value);
    console.log(t);
    t.setAttribute("selected", null);
}
