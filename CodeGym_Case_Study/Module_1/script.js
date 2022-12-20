let a=''
let b=''
let x=''
let y=''
let admin='admin'
let pwAdmin='123456'
let Item=function (img,name,price){
    this.image=img
    this.name=name
    this.price=price
    this.getImage=function (){
        return this.image
    }
    this.getName=function (){
        return this.name
    }
    this.getPrice=function (){
        return this.price
    }
    this.setImage=function (url){
        this.image=url
    }
    this.setName=function (name){
        this.name=name
    }
    this.setPrice=function (price){
        this.price=price
    }
}
// shoes
let shoes1=new Item('shoes/shoes1.webp','Nike Air Force',110)
let shoes2=new Item('shoes/shoes2.webp','Nike Dunk High Retro',125)
let shoes3=new Item('shoes/shoes3.webp','Nike Blazer Mid Vintage',105)
let shoes4=new Item('shoes/shoes4.webp','Nike Air Max 90',130)
let shoes5=new Item('shoes/shoes5.webp','Nike Pegasus Turbo Next Nature',150)
let shoes6=new Item('shoes/shoes6.webp','Air Jordan 1 Mid',125)
//clothing
let clothing1=new Item('clothing/clothing1.webp','Nike Sportwear Windrunner',110)
let clothing2=new Item('clothing/clothing2.webp','Nike Sportwear Sport Essentials',125)
let clothing3=new Item('clothing/clothing3.webp','Nike Solo Swoosh Hoodie',105)
let clothing4=new Item('clothing/clothing4.webp','Nike Solo Swoosh Pant',130)
let clothing5=new Item('clothing/clothing5.webp','Nike Therma-Fit Repel',150)
let clothing6=new Item('clothing/clothing6.webp','Nike Dri-FIT Challenger',125)
//collection
let collection1=new Item('collection/collection1.webp','Cap',110)
let collection2=new Item('collection/collection2.webp','Printed Neck Wrap',125)
let collection3=new Item('collection/collection3.webp','Little Kid Crew Sock',105)
let collection4=new Item('collection/collection4.webp','Fanny Pack',130)
let collection5=new Item('collection/collection5.webp','Blackpack',150)
let collection6=new Item('collection/collection6.webp','Neck Wrap',125)
//data
let shoes=[shoes1,shoes2,shoes3,shoes4,shoes5,shoes6]
let clothing=[clothing1,clothing2,clothing3,clothing4,clothing5,clothing6]
let collection=[collection1,collection2,collection3,collection4,collection5,collection6]

display()
function display() {
    let text1=''
for(let i=0;i<shoes.length;i++){
    text1+='<div style="width: 300px;margin-left: 50px;margin-top: 15px;text-align: center;display: inline-block">'
    text1+='<img style="width: 65%" src="'+shoes[i].getImage()+'">'+'<br>'
    text1+=shoes[i].getName()+'<br>'
    text1+='Price: $'+shoes[i].getPrice()+'<br>'
    text1+='<input style="width: 50px;height: 25px" type="button" onclick="del(shoes,'+i+')" value="Delete">'+'&ensp;'
    text1+='<input style="width: 50px;height: 25px" type="button" onclick="showModal(shoes,'+i+')" value="Edit">'
    text1+='</div>'
}
document.getElementById('shoesProduct').innerHTML=text1


let text2=''
for(let i=0;i<clothing.length;i++){
    text2+='<div style="width: 300px;margin-left: 50px;margin-top: 15px;text-align: center;display: inline-block">'
    text2+='<img style="width: 65%" src="'+clothing[i].getImage()+'">'+'<br>'
    text2+=clothing[i].getName()+'<br>'
    text2+='Price: $'+clothing[i].getPrice()+'<br>'
    text2+='<input style="width: 50px;height: 25px" type="button"  onclick="del(clothing,'+i+')" value="Delete">'+'&ensp;'
    text2+='<input style="width: 50px;height: 25px" type="button" onclick="showModal(clothing,'+i+')" value="Edit">'
    text2+='</div>'
}
document.getElementById('clothingProduct').innerHTML=text2

    let text3=''
    for(let i=0;i<collection.length;i++){
        text3+='<div style="width: 300px;margin-left: 50px;margin-top: 15px;text-align: center;display: inline-block">'
        text3+='<img style="width: 65%" src="'+collection[i].getImage()+'">'+'<br>'
        text3+=collection[i].getName()+'<br>'
        text3+='Price: $'+collection[i].getPrice()+'<br>'
        text3+='<input style="width: 50px;height: 25px" type="button"  onclick="del(collection,'+i+')" value="Delete">'+'&ensp;'
        text3+='<input style="width: 50px;height: 25px" type="button" onclick="showModal(collection,'+i+')" value="Edit">'
        text3+='</div>'
    }
    document.getElementById('collectionProduct').innerHTML=text3
}

function del(arr,i){
    if(confirm("Are you sure want to delete it?")===true) {
        arr.splice(i, 1)
        display()
    }
}
function showModal(arr,i) {
    modal.classList.add('open')
     a=arr
     b=i
}
function edit(arr,i){
    arr[i].setName(document.getElementById('nameItem').value)
    arr[i].setPrice(document.getElementById('priceItem').value)
    document.getElementById('nameItem').value=''
    document.getElementById('priceItem').value=''
display()
}
const modal=document.querySelector('.modal')
const modalClose=document.querySelector('.js-modal-close')
modalClose.addEventListener('click', hideModal)
function hideModal(){
    modal.classList.remove('open')
}

function add(arr,img){
 let nameProductAdd=document.getElementById('nameItem2').value
 let priceProductAdd=document.getElementById('priceItem2').value
    document.getElementById('priceItem2').value=''
    document.getElementById('nameItem2').value=''
    let imgProductAdd=img
    let collection7=new Item(imgProductAdd,nameProductAdd,priceProductAdd)
    arr.push(collection7)
    display()
}

const modaladd=document.querySelector('.modal-add')
const modalCloseadd=document.querySelector('.js-modal-close-add')
modalCloseadd.addEventListener('click', hideModaladd)
function hideModaladd() {
    modaladd.classList.remove('open')
}

function showModaladd(arr,img) {
    modaladd.classList.add('open')
    x=arr;
    y=img;
}

function checkLogin(){
    let username=document.getElementById('username').value
    let password=document.getElementById('password').value
    if(username===admin && pwAdmin===password){
        hideModalLogin()
    }
}
function hideModalLogin(){
    document.querySelector('.modal-login').classList.add('hide');
}