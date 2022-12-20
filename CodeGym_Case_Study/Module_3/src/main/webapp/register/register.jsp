<%--
  Created by IntelliJ IDEA.
  User: huyng
  Date: 02/12/2022
  Time: 08:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%--header--%>
<div id="header">
  <div class="container">
    <div class="row" style="padding: 10px;height: 75px">
      <div class="col-md-1 vertical">
        <a href=""><img src="image/logo_keeng.png" style="margin-top: 6px" alt="image"/></a>
      </div>
    </div>
  </div>
</div>
<div id="center">
  <div class="container">
    <div class="row py-5 mt-4 align-items-center">

      <!-- Left side -->
      <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
        <img src="image/image-left-side.jpg" alt="image" class="img-fluid mb-5 d-none d-md-block">
        <h1 style="text-align: center">Tạo tài khoản</h1>
      </div>

      <!-- Registeration Form -->
      <div class="col-md-7 col-lg-6 ml-auto">
        <form method="post" action="${pageContext.request.contextPath}/register?action=create">
          <div class="row">
            <!-- Account -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-2">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-user text-muted"></i>
              </span>
                <input type="text" class="form-control" placeholder="Tài khoản (tối thiểu 6 kí tự)" name="account"
                required="required">
              </div>
              <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageAccount}">
                <c:out value="${messageAccount}"/>
                <c:set var="messageAccount" value="" scope="session"/>
              </c:if>
              </p>
            </div>
            <!-- Password -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-2">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                 <i class="fa fa-lock text-muted"></i>
              </span>
                <input id="password" type="password" class="form-control" placeholder="Mật khẩu"
                        name="password">
              </div>
              <div>
                <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messagePassword}">
                  <c:out value="${messagePassword}"/>
                  <c:set var="messagePassword" value="" scope="session"/>
                </c:if>
                </p>
                <div id="messageWarningPassword">
                  <p class="text-muted m-0 p-0">---Mật khẩu phải tuân theo định dạng sau---</p>
                  <p class="text-muted my-0 p-0">1. Tối thiểu một kí tự viết hoa</p>
                  <p class="text-muted my-0 p-0">2. Tối thiểu một kí tự số</p>
                  <p class="text-muted my-0 p-0">3. Tối thiểu một kí tự đặc biệt</p>
                  <p class="text-muted my-0 p-0">4. Giới hạn từ 6-8 kí tự</p>
                </div>
              </div>
            </div>

            <!-- Password Confirm -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-2">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-lock text-muted"></i>
              </span>
                <input type="password" class="form-control" placeholder="Xác nhận mật khẩu" name="passwordConfirm">
              </div>
              <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messagePasswordConfirm}">
                <c:out value="${messagePasswordConfirm}"/>
                <c:set var="messagePasswordConfirm" value="" scope="session"/>
              </c:if>
              </p>
            </div>

            <!-- Full Name -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-3">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-address-card-o text-muted"></i>
              </span>
                <input type="text" class="form-control" placeholder="Họ và tên" name="name">
              </div>
            </div>

            <!-- Email -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-3">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-envelope text-muted"></i>
              </span>
                <input type="text" class="form-control" placeholder="Địa chỉ email" name="email">
              </div>
              <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageEmail}">
                <c:out value="${messageEmail}"/>
                <c:set var="messageEmail" value="" scope="session"/>
              </c:if>
              </p>
            </div>
            <!-- Role -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-3">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-black-tie text-muted"></i>
              </span>
                <select id="job" name="role" class="form-control custom-select bg-white border-left-0 border-md">
                  <option value="">Chọn kiểu tài khoản </option>
                  <option value="user">Người dùng</option>
                  <option value="singer">Ca sĩ</option>
                </select>
              </div>
              <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageRole}">
                <c:out value="${messageRole}"/>
                <c:set var="messageRole" value="" scope="session"/>
              </c:if>
              </p>
            </div>
            <!-- Telephone -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group mb-3">
              <span class="input-group-text px-4 bg-white justify-content-center" style="width: 70px">
                <i class="fa fa-phone-square text-muted"></i>
              </span>
                <input type="text" class="form-control" placeholder="Số điện thoại" name="telephone">
              </div>
              <p class="text-danger m-0 p-0" style="font-size: 14px"><c:if test="${not empty messageTelephone}">
                <c:out value="${messageTelephone}"/>
                <c:set var="messageTelephone" value="" scope="session"/>
              </c:if>
              </p>
            </div>
            <!-- Submit Button -->
            <div class="form-group col-lg-4 mx-auto mb-0">
              <button id="button-submit" type="submit"
                      class="btn btn-primary btn-block py-2" onsubmit="submitForm()">
                <span class="font-weight-bold">Tạo tài khoản</span>
              </button>
            </div>
            <!-- Divider Text -->
            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
              <div class="border-bottom w-100 ml-5"></div>
              <div class="border-bottom w-100 mr-5"></div>
            </div>
            <!-- Already Registered -->
            <div class="text-center w-100">
              <p class="text-muted font-weight-bold">Đã có tài khoản?
                <a href="http://localhost:8080/login/login.jsp"
                   class="text-primary ml-2">Chuyển về trang đăng nhập</a></p>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
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
</body>
</html>
<script>
  // Password format hidden show
  let myInput = document.getElementById("password");
  // When the user clicks on the password field, show the message box
  myInput.onfocus = function() {
    document.getElementById("messageWarningPassword").style.display = "block";
  }
  // When the user clicks outside of the password field, hide the message box
  myInput.onblur = function() {
    document.getElementById("messageWarningPassword").style.display = "none";
  }
</script>
