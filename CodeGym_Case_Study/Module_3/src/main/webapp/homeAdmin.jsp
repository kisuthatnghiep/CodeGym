<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/2/2022
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
    <script src="asset/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="asset/CSS/style.css">
</head>
<body>
<div id="header">
    <div class="container">
        <div class="row" style="padding: 10px;height: 75px">
            <div class="col-md-1 vertical">
                <a href=""><img src="sourcePicture/logo_keeng.png" style="margin-top: 6px"/></a>
            </div>
            <div class="col-md-2 vertical" id="menu">
                <ul id="nav">
                    <li style="margin-bottom: -18px"><a style="color:#7aaf16; font-weight: 700; width: 90px" href="#">NHẠC</a>
                        <ul class="subnav">
                            <li><a href="">Bài hát</a></li>
                            <li><a href="">MV</a></li>
                            <li><a href="">Album</a></li>
                            <li><a href="">EDM</a></li>
                        </ul></li>

                </ul>
            </div>
            <div class="col-md-6 avatar vertical">
                <div class="input-group">
                    <input class="form-control border-end-0 border" type="search" placeholder="Tìm kiếm" id="example-search-input">
                    <span class="input-group-append">
                    <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-0 border ms-n5" type="button">
                        <i class="bi bi-search"></i>
                    </button>
                </span>
                </div>
            </div>
            <div class="col-md-3 vertical signIn">
                <a id="avatar" href="" style = "margin-left: 60px">Admin</a>
                <img src="sourcePicture/keeng_ver5_02.png"/>
                <a href="http://localhost:8080/login/login.jsp">Đăng xuất</a>
            </div>
        </div>
    </div>
</div>
<div id="content">
    <div id="slider">
        <div class="container p-0">
            <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="3000">
                        <img src="sourcePicture/1669777843552_org.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="3000">
                        <img src="sourcePicture/1669806008334_org.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="sourcePicture/1669880347398_org.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
    <div id="main-content">
        <div class="container">
            <div class="row">
                <div class="w-50 d-inline-block"
                     style="background-color: white; margin-top: 20px; border-right: 10px #EAEAEAFF solid">
                    <h3>Tổng doanh thu </h3>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Số tiền</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">Tổng doanh thu</th>
                            <td><c:out value="${totalPrice*1.0}"/></td>
                        </tr>
                        <tr>
                            <th scope="row">Doanh thu ca sĩ</th>
                            <td><c:out value="${totalPrice*0.8}"/></td>
                        </tr>
                        <tr>
                            <th scope="row">Lợi nhuận web</th>
                            <td colspan="2"><c:out value="${totalPrice*0.2}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="w-50 d-inline-block"
                     style="background-color: white; margin-top: 20px; border-left: 10px #EAEAEAFF solid">
                    <h3>Doanh thu theo tháng/năm</h3>
                    <form action="${pageContext.request.contextPath}/AdminServlet?action=priceByDate" method="post">
                        <div class="d-inline-block" style="width: 30%">
                            <label for="formGroupExampleInput" class="form-label">Tháng</label>
                            <select class="form-select" name="month" aria-label="Default select example" id="formGroupExampleInput">
                                <option selected id="0" class="focus" value="0">----</option>
                                <option id="1" class="focus" value="1">1</option>
                                <option id="2" class="focus" value="2">2</option>
                                <option id="3" class="focus" value="3">3</option>
                                <option id="4" class="focus" value="4">4</option>
                                <option id="5" class="focus" value="5">5</option>
                                <option id="6" class="focus" value="6">6</option>
                                <option id="7" class="focus" value="7">7</option>
                                <option id="8" class="focus" value="8">8</option>
                                <option id="9" class="focus" value="9">9</option>
                                <option id="10" class="focus" value="10">10</option>
                                <option id="11" class="focus" value="11">11</option>
                                <option id="12" class="focus" value="12">12</option>
                            </select>
                        </div>
                        <div class="d-inline-block" style="width: 30%; margin-left: 10px">
                            <label for="formGroupExampleInput1" class="form-label">Năm</label>
                            <select class="form-select" name="year" aria-label="Default select example" id="formGroupExampleInput1">
                                <option value="2022">2022</option>
                                <option value="2021">2021</option>
                                <option value="2020">2020</option>
                            </select>
                        </div>
                        <div class="d-inline-block" style="width: 30%; margin-left: 10px">
                            <button class="btn btn-primary" onclick="passSelected()">Tìm kiếm</button>
                        </div>
                    </form>
                    <hr>
<%--                Phần code <c:out> của Tú--%>
                    <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">Số tiền</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Tổng doanh thu</th>
                        <td><c:out value="${sumPriceByDate*1.0}"/></td>
                    </tr>
                    <tr>
                        <th scope="row">Doanh thu ca sĩ</th>
                        <td><c:out value="${sumPriceByDate*0.8}"/></td>
                    </tr>
                    <tr>
                        <th scope="row">Lợi nhuận web</th>
                        <td colspan="2"><c:out value="${sumPriceByDate*0.2}"/></td>
                    </tr>
                    </tbody>
                </table>
<%--                Kết thúc code <c:out> của Tú--%>
                </div>
            </div>
            <div class="row">
                <div id="information" >
                    <h3>Danh sách ca sĩ</h3>
                    <table class="table table-hover" style="margin-top: 30px">
                        <tr>
                            <th>Tài khoản</th>
                            <th>Họ và tên</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Thu nhập</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${listSinger}" var="singer">
                            <tr>
                                <td><c:out value="${singer.getAccount()}"/></td>
                                <td><c:out value="${singer.getName()}"/></td>
                                <td><c:out value="${singer.getEmail()}"/></td>
                                <td><c:out value="${singer.getPhone()}"/></td>
                                <td><c:out value="${singer.getIncome()}"/></td>
                                <td><a href="#"><i class="bi bi-trash" data-bs-toggle="modal" data-bs-target="#deleteSinger" onclick="referenceDeleteSinger(${singer.getId()})"></i></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <div id="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-2 center">
                    <h3><a href="#">Nhạc</a></h3>
                    <ul>
                        <li><a href="#">Bài hát</a></li>
                        <li><a href="#">Video</a></li>
                        <li><a href="#">Album</a></li>
                    </ul>
                </div>
                <div class="col-md-2 center" style="margin-top: 40px">
                    <ul>
                        <li><a href="#">BXH</a></li>
                        <li><a href="#">Chủ đề</a></li>
                        <li><a href="#">Nghệ sĩ</a></li>
                    </ul>
                </div>
                <div class="col-md-1">

                </div>
                <div class="col-md-7" style="padding: 60px">
                    <div class="logo">
                        <img src="sourcePicture/logo_mocha.png" alt="">
                        <img src="sourcePicture/logo_onbox.png" alt="">
                    </div>
                    <div class="logo">
                        <img src="sourcePicture/logo_onvideo.png" alt="">
                        <img src="sourcePicture/logo_songkhoe.png" alt="">
                    </div>
                    <div class="logo">
                        <img src="sourcePicture/logo_tiin.png" alt="">
                        <img src="sourcePicture/logo_viettelstudy.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr style="color: white">
    <div id="footer-bottom">
        <div class="container">
            <div class="row" style="padding-top: 30px">
                <div class="col-md-1" style="vertical-align: bottom">
                    <img src="https://musicmd1fr.keeng.net/bucket-image-keeng/web_v5//images/logo_keeng_footer.png" width="200%">
                    <img src="https://musicmd1fr.keeng.net/bucket-image-keeng/web_v5//images/gov-dathongbao.png" width="230" height="86">
                </div>
                <div class="col-md-11 sizetext">
                    <h3>Mạng xã hội Keeng: Âm nhạc</h3>
                    Cơ quan chủ quản: Công ty Truyền thông Viettel (Viettel Media) – Chi nhánh Tập đoàn Công nghiệp – Viễn thông Quân đội.
                    <br>
                    Chịu trách nhiệm nội dung: Ông Võ Thanh Hải
                    <br>
                    Địa chỉ giao dịch: Tầng 4, Tòa nhà The Light (CT2 Trung Văn), đường Tố Hữu, Nam Từ Liêm, Hà Nội
                    <br>
                    Chăm sóc khách hàng: 198 (Miễn phí)
                    <span>Quảng cáo:hoptac@viettel.com.vn</span>
                    <br>
                    <span>Hợp tác nội dung: hoptac@keeng.vn</span>
                    <br>
                    Giấy phép: Số 365/GP-BTTTT do Bộ Thông tin và Truyền thông cấp ngày 28/07/2017
                    <br>
                    <a href="http://keeng.vn/info?type=gioi-thieu">Giới thiệu</a> |
                    <a href="http://keeng.vn/info?type=quy-dinh-su-dung">Quy định sử dụng</a>|
                    <a href="/info?type=gop-y-bao-loi">Góp ý - Báo lỗi</a> |
                    <a href="/info?type=lien-he-hop-tac">Liên hệ quảng cáo</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal delete -->
<div class="modal fade" id="deleteSinger" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xóa ca sĩ không?
            </div>
            <div class="modal-footer" id="delete-parameter">
                <a href="AdminServlet?action=deleteSinger" onclick="location.href=(this.href+'&singerId='+singer);return false;" id="a">
                    <button type="button" class="btn btn-primary">Xác nhận</button></a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy bỏ</button>
            </div>
        </div>
    </div>
</div>
<script src="actionDeleteSinger.js"></script>
</body>
</html>
