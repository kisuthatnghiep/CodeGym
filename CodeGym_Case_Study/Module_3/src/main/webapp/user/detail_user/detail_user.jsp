<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/2/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/asset/bootstrap/css/bootstrap.min.css">
  <script src="/asset/bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
  <link rel="stylesheet" href="/asset/CSS/style.css">
</head>
<body>
<div id="header">
  <div class="container">
    <div class="row" style="padding: 10px;height: 75px">
      <div class="col-md-1 vertical">
        <a href="${pageContext.request.contextPath}/UserServlet"><img src="../../sourcePicture/logo_keeng.png" style="margin-top: 6px"/></a>
      </div>
      <div class="col-md-2 vertical" id="menu">
        <ul id="nav">
          <li style="margin-bottom: -18px"><a style="color:#7aaf16; font-weight: 700;width: 90px;" href="#">NHẠC</a>
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
          <form action="${pageContext.request.contextPath}/UserServlet?action=searchDetail" method="post" style="width: 620px">
          <input class="form-control border-end-0 border" type="search" name="search" placeholder="Tìm kiếm" id="example-search-input">
          </form>
          <span class="input-group-append">
                    <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-0 border ms-n5" type="button">
                        <i class="bi bi-search"></i>
                    </button>
                </span>
        </div>
      </div>
      <div class="col-md-3 vertical signIn">
        <a id="avatar" style="margin-left: 60px" href=""><c:out value="${user.getName()}"/></a>
        <img src="../../sourcePicture/keeng_ver5_02.png"/>
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
            <img src="../../sourcePicture/1669777843552_org.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item" data-bs-interval="3000">
            <img src="../../sourcePicture/1669806008334_org.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="../../sourcePicture/1669880347398_org.jpg" class="d-block w-100" alt="...">
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
            <img src="../../sourcePicture/avatardeatil.jpg"
                 style="width: 70%;border-radius: 50%" alt="">
          </div>
          <div class="col-md-8">
            <form class="row g-3" id="info-form">
              <div class="col-md-6">
                <fieldset disabled>
                  <label for="input-account" class="form-label">Tài khoản</label>
                  <input type="text" class="form-control" id="input-account" value="${user.getAccount()}">
                </fieldset>
              </div>
              <div class="col-md-6">
                <label for="inputPassword4" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="inputPassword4"  value="${user.getPassword()}">
              </div>
              <div class="col-12">
                <label for="input-name" class="form-label">Họ và tên</label>
                <input type="text" class="form-control" id="input-name"  value="${user.getName()}">
              </div>
              <div class="col-12">
                <label for="inputEmail" class="form-label">Email</label>
                <input type="email" class="form-control" id="inputEmail" value="${user.getEmail()}">
              </div>
              <div class="col-md-6">
                <label for="inputPhone" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="inputPhone" value="${user.getPhone()}">
              </div>
              <div class="col-md-6">
                <fieldset disabled>
                  <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Ví</label>
                    <input type="text" id="disabledTextInput" class="form-control" value="${user.getWallet()} (USD)">
                    <p style="color: red;"><c:out value="${notify}"/></p>
                  </div>
                </fieldset>
              </div>
              <div class="col-12">
                <button style="margin-right: 10px" type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                  Tạo PlayList</button>
                <a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle"
                     role="button">Nạp tiền</a>
              </div>
            </form>
          </div>
        </div>
        <div style="margin-top: 20px;margin-bottom:20px;background-color: white;">
          <h3>Danh sách play list</h3>
          <table class="table table-hover" style="margin-top:30px">
            <tr>
              <th>Tên danh sách</th>
              <th>Ngày tạo</th>
              <th></th>
            </tr>
            <c:forEach var="dtl" items="${listPlayListUser}">
              <tr>
                <td><c:out value="${dtl.getName()}"/></td>
                <td><c:out value="${dtl.getDate()}"/></td>
              </tr>
            </c:forEach>
          </table>
          <div class="col-12">

          </div>
        </div>
        <div id="song-list">
          <h3>Danh sách bài hát</h3>
          <h4>Tổng tiền đã chi: <c:out value="${sumPrice}"/></h4>
          <table class="table table-hover" style="margin-top:30px">
            <tr>
              <th>Tên bài hát</th>
              <th>Mô tả</th>
              <th>Giá tiền</th>
              <th></th>
            </tr>
            <c:forEach var="song" items="${listSongUser}">
              <tr>
                <td><a href="audioPlayer/audioPlayer.jsp" onclick="playAudio('${song.getName()}','${song.getLink()}')">
                  <c:out value="${song.getName()}"/></a></td>
                <td><c:out value="${song.getDescription()}"/></td>
                <td><c:out value="${song.getPrice()}"/></td>
                <td><a href="#"><i class="bi bi-file-earmark-plus"  data-bs-toggle="modal" data-bs-target="#addToPlaylist"
                                   style="font-size:20px " onclick="referenceDeleteSongUser(${song.getId()})"></i></a></td>
              </tr>
            </c:forEach>
          </table>
          <div class="col-12">
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%--modal createPlayList--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="${pageContext.request.contextPath}/UserServlet?action=createPlayList" method="post">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">Play List</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <table class="col-sm-8">
            <tr>
              <th class="col-sm-2"><label for="name">Name</label></th>
              <th class="col-sm-6"><input type="text" id="name" name="name" style="font-size: 20px"></th>
            </tr>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-light" data-bs-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-light">Create</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%--modal nap tien--%>
<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="exampleModalToggleLabel" style="text-align: center">Nạp Tiền</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="${pageContext.request.contextPath}/UserServlet?action=recharge" method="post">
        <div class="modal-body">
          <input style="font-size: 20px;width: 400px" type="number" name="wallet"
                 placeholder="Số tiền bạn muốn nạp">&emsp;<c:out value="USD"/>
        </div>
        <div class="modal-footer">
          <button class="btn btn-primary" type="submit">Nạp</button>
        </div>
      </form>
    </div>
  </div>
</div>
<%--modal xoa playlist--%>


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
            <img src="../../sourcePicture/logo_mocha.png" alt="">
            <img src="../../sourcePicture/logo_onbox.png" alt="">
          </div>
          <div class="logo">
            <img src="../../sourcePicture/logo_onvideo.png" alt="">
            <img src="../../sourcePicture/logo_songkhoe.png" alt="">
          </div>
          <div class="logo">
            <img src="../../sourcePicture/logo_tiin.png" alt="">
            <img src="../../sourcePicture/logo_viettelstudy.png" alt="">
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
<script src="referenceDeleteSongUser.js"></script>

<%--modal add song to playlist--%>
<div class="modal fade" id="addToPlaylist" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2">Thêm vào Playlist</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="${pageContext.request.contextPath}/UserServlet?action=addSongToPlayList" method="post">
        <div class="modal-body">
          <input name="songId" id="songId" hidden>
          <select class="form-select" aria-label="Default select example" name="playListId">
            <c:forEach items="${listPlayListUser}" var="playlist">
              <option value="${playlist.getId()}"><c:out value="${playlist.getName()}"/></option>
            </c:forEach>
          </select>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">Xác nhận</button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy bỏ</button>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="user/detail_user/referenceDeleteSongUser.js"></script>
</body>
</html>

