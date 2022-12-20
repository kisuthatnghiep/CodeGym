<%--
  Created by IntelliJ IDEA.
  User: SON VUONG
  Date: 12/2/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="style-login.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="bootstrap.login.js">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<%--header--%>
<div id="header">
    <div class="container">
        <div class="row" style="padding: 10px;height: 75px">
            <div class="col-md-1 vertical" style="margin-top: 9px; margin-bottom: 9px">
                <a href=""><img src="image/logo_keeng.png" style="margin-top: 6px" alt="image"/></a>
            </div>
        </div>
    </div>
</div>
<%--center--%>
<div class="overlay" style="height: 900px">
    <form action="${pageContext.request.contextPath}/login?action=login" method="post" style="margin-top: 150px">
        <div class="con">
            <header class="head-form">
                <h2>Đăng nhập</h2>
            </header>
            <br>
            <div class="field-set">
                <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>
                <input class="form-input" id="txt-input" type="text" name="account" placeholder="Tài Khoản">
                <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageLoginAccount}">
                    <c:out value="${messageLoginAccount}"/>
                    <c:set var="messageLoginAccount" value="" scope="session"/>
                </c:if>
                </p>
                <br>
                <span class="input-item">
        <i class="fa fa-key"></i>
       </span>
                <input class="form-input" type="password" placeholder="Mật Khẩu" id="pwd"  name="password">
                <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageLoginPassword}">
                    <c:out value="${messageLoginPassword}"/>
                    <c:set var="messageLoginPassword" value="" scope="session"/>
                </c:if>
                </p>
                <br>
                <button class="log-in"> Đăng nhập </button>
            </div>
            <div class="other">
                <button class="btn submits frgt-pass" style="margin-top: 9px">Chưa có tài khoản?</button>
                <a href="http://localhost:8080/register/register.jsp" style="text-decoration: none;color:black">
                    <button type="button" class="btn submits" style="margin-top: 10px">Đăng ký
                        <i class="fa fa-user-plus" aria-hidden="true"></i>
                    </button></a>
            </div>
        </div>
    </form>
</div>
<%--Footer--%>
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
                        <img src="image/logo_mocha.png" alt="">
                        <img src="image/logo_onbox.png" alt="">
                    </div>
                    <div class="logo">
                        <img src="image/logo_onvideo.png" alt="">
                        <img src="image/logo_songkhoe.png" alt="">
                    </div>
                    <div class="logo">
                        <img src="image/logo_tiin.png" alt="">
                        <img src="image/logo_viettelstudy.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr style="color: white; margin: 0">
    <div id="footer-bottom">
        <div class="container">
            <div class="row" style="padding-top: 30px; padding-bottom: 30px">
                <div class="col-md-1" style="vertical-align: bottom">
                    <img src="https://musicmd1fr.keeng.net/bucket-image-keeng/web_v5//images/logo_keeng_footer.png" width="200%">
                    <img src="https://musicmd1fr.keeng.net/bucket-image-keeng/web_v5//images/gov-dathongbao.png" width="230" height="86">
                </div>
                <div class="col-md-11 sizetext" style="padding-left: 300px">
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
</body>
</html>
