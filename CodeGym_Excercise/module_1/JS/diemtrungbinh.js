let vatLy;
let hoaHoc;
let sinhHoc;
let demo = +prompt("")
vatLy=prompt('nhập điểm môn vật lý ');
hoaHoc=prompt('nhập điểm môn hóa học ');
sinhHoc=prompt('nhập điểm môn sinh học ');
let diemVatLy=parseInt(vatLy);
let diemHoaHoc=parseInt(hoaHoc);
let diemSinhHoc=parseInt(sinhHoc);
let sum=diemVatLy+diemHoaHoc+diemSinhHoc;
let average=sum/3;
document.write('Điểm trung bình 3 môn là '+average);
document.write('<br>');
document.write('Tổng điểm 3 môn là '+sum)