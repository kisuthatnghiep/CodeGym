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
                <a id="avatar" href="" style = "margin-left: 60px"><c:out value="${singer.getName()}"/></a>
                <img src="sourcePicture/keeng_ver5_02.png" alt="img"/>
                <a href="http://localhost:8080/login/login.jsp">Đăng xuất</a>
            </div>
        </div>
    </div>
</div>
<div id="content">
    <div id="slider">
        <div class="container" style="padding: 0">
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
        <div id="information">
            <h3>Thông tin cá nhân</h3>
            <div class="col-md-4">
                <img src="https://i1-giaitri.vnecdn.net/2021/02/06/118694894-229278411819922-4206-7181-8473-1612576192.jpg?w=680&h=0&q=100&dpr=1&fit=crop&s=YhjfrEmnY22wXxWFc_t5fw" style="width: 70%" alt="">
            </div>
            <div class="col-md-8">
                <form class="row g-3" id="info-form">
                    <div class="col-md-6">
                        <fieldset disabled>
                        <label for="input-account" class="form-label">Tài khoản</label>
                        <input type="text" class="form-control" id="input-account" value="${singer.getAccount()}">
                        </fieldset>
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="inputPassword4"  value="${singer.getPassword()}">
                    </div>
                    <div class="col-12">
                        <label for="input-name" class="form-label">Họ và tên</label>
                        <input type="text" class="form-control" id="input-name"  value="${singer.getName()}">
                    </div>
                    <div class="col-12">
                        <label for="inputEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="inputEmail" value="${singer.getEmail()}">
                    </div>
                    <div class="col-md-6">
                            <label for="inputPhone" class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" id="inputPhone" value="${singer.getPhone()}">
                    </div>
                    <div class="col-md-6">
                        <fieldset disabled>
                        <div class="mb-3">
                            <label for="disabledTextInput" class="form-label">Thu nhập</label>
                            <input type="text" id="disabledTextInput" class="form-control" value="${singer.getIncome()} (USD)">
                        </div>
                    </fieldset>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">Cập nhật</button>
                    </div>
                </form>
            </div>
        </div>
        <div id="song-list">
            <h3>Danh sách bài hát</h3>
            <table class="table table-hover" style="margin-top:30px">
                <tr>
                    <th>STT</th>
                    <th>Tên bài hát</th>
                    <th>Mô tả</th>
                    <th>Giá tiền</th>
                    <th></th>
                </tr>
                <c:forEach var="song" items="${listSong}">
                    <tr>
                        <td><c:out value="${song.getId()}"/></td>
<%--                        <td><button >aaa</button></td>--%>
                        <td><a href="audioPlayer/audioPlayer.jsp" onclick="playAudio('${song.getName()}','${song.getLink()}')"><c:out value="${song.getName()}"/></a></td>
                        <td><c:out value="${song.getDescription()}"/></td>
                        <td><c:out value="${song.getPrice()}"/></td>
                        <td><a href="#"><i class="bi bi-trash" data-bs-toggle="modal" data-bs-target="#delete" onclick="referenceDeleteSong(${song.getId()})"></i></a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="col-12">
                <button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-bottom: 20px">Thêm bài hát</button>
            </div>
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
<%--Modal create song--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
                <form action="SingerServlet?action=createSong" method="post">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1" style="text-align: center">Tạo bài hát</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="col-12">
                    <label for="input-song" class="form-label">Tên bài hát</label>
                    <input type="text" name="nameSong" class="form-control" id="input-song">
                </div>
                <div class="col-12">
                    <label for="input-URL" class="form-label">URL</label>
                    <input type="text" name="url" class="form-control" id="input-URL">
                </div>
                <div class="col-12">
                    <label for="input-description" class="form-label">Mô tả</label>
                    <input type="text" name="description" class="form-control" id="input-description">
                </div>
                <div class="col-12">
                    <label for="input-price" class="form-label">Giá tiền</label>
                    <input type="text" name="price" class="form-control" id="input-price">
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Tạo bài hát</button>
            </div></form>
        </div>
    </div>
</div>

<!-- Modal delete -->
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xóa bài hát không?
            </div>
            <div class="modal-footer" id="delete-parameter">
                <a href="SingerServlet?action=delete" onclick="location.href=(this.href+'&id='+song);return false;" id="a">
                    <button type="button" class="btn btn-primary">Xác nhận</button></a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy bỏ</button>
            </div>
        </div>
    </div>
</div>
<script src="audioPlayer/audioPlayer.js"></script>
<script src="actionDelete.js"></script>
</body>
</html>
