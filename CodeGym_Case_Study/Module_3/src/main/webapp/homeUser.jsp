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
                <a href="#"><img src="sourcePicture/logo_keeng.png" style="margin-top: 6px"/></a>
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
                    <form action="${pageContext.request.contextPath}/UserServlet?action=search" method="post">
                    <input class="form-control border-end-0 border" name="search" type="search" placeholder="Tìm kiếm"
                           id="example-search-input" style="width: 620px">
                    </form>
                    <span class="input-group-append">
                    <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-0 border ms-n5" type="button">
                        <i class="bi bi-search"></i>
                    </button>
                </span>
                </div>
            </div>
            <div class="col-md-3 vertical">
                <a id="avatar" href="UserServlet?action=detailUser" style = "margin-left: 60px"><c:out value="${user.getName()}"/></a>
                <img src="sourcePicture/keeng_ver5_02.png"/>
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
                <h3 style="font-family: sans-serif">Bài hát</h3>
                <p style="color: red;"><c:out value="${notify}"/></p>
                <div id="information">
                    <table class="table table-hover" style="margin-top:30px">
                        <tr>
                            <th>Tên bài hát</th>
                            <th>Ca sĩ</th>
                            <th>Mô tả</th>
                            <th>Giá tiền</th>
                            <th></th>
                        </tr>
                        <c:forEach var="song" items="${listSong}">
                            <c:if test="${song.getStatus() == 1}">
                                <tr>
                                    <td><c:out value="${song.getName()}"/></td>
                                    <td><c:out value="${listMapSinger.get(song.getSingerId()).getName()}"/></td>
                                    <td><c:out value="${song.getDescription()}"/></td>
                                    <td><c:out value="${song.getPrice()}"/></td>
                                    <td><a href="#"><i class="bi bi-cart4" data-bs-toggle="modal" data-bs-target="#buySong" onclick="referenceAddSong(${song.getId()})"></i></a></td>
                                </tr>
                            </c:if>
                            <c:if test="${song.getStatus() == -1}">
                                <tr>
                                    <td><c:out value="${song.getName()}"/></td>
                                    <td><c:out value="${listMapSinger.get(song.getSingerId()).getName()}"/></td>
                                    <td><c:out value="${song.getDescription()}"/></td>
                                    <td><c:out value="${song.getPrice()}"/></td>
                                    <td><i class="bi bi-check2-square"></i></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
                <h3  style="font-family: sans-serif">Playlist</h3>
                <div id="song-list">
                    <table class="table table-hover" style="margin-top:30px; text-align: center">
                        <tr>
                            <th class="col-sm-3">Tên danh sách bài hát</th>
                            <th class="col-sm-2">Ngày tạo</th>
                            <th class="col-sm-7">Danh sách bài hát</th>
                        </tr>
                        <c:forEach var="p" items="${listPlayList}">
                            <tr>
                                <td class="col-sm-3"><c:out value="${p.getName()}"/></td>
                                <td class="col-sm-2"><c:out value="${p.getDate()}"/></td>
                                <td class="col-sm-7">
                                    <table class="table table-borderless">
                                        <c:forEach items="${listSongPlayList}" var="s">
                                            <c:if test="${mapPlayListDetail.get(p.getId()*10+s.getId()) == p.getId()}">
                                                <tr>
                                                    <td class="col-sm-3"></td>
                                                    <td class="col-sm-6"><a href="audioPlayer/audioPlayer.jsp" onclick="playAudio
                                                            ('${listMapSongPlayList.get(s.getId()).getName()}',
                                                            '${listMapSongPlayList.get(s.getId()).getLink()}')">
                                                        <c:out value="${listMapSongPlayList.get(s.getId()).getName()}"/></a><br>
                                                        <p style="font-size: smaller"><c:out value="${listMapSinger.get(s.getSingerId()).getName()}"/></p>
                                                    </td>
                                                    <td class="col-sm-3"><a href="#"><i class="bi bi-trash" ></i></a></td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                </td>
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

<%--modal mua bai hat--%>
<div class="modal fade" id="buySong" tabindex="-1" aria-labelledby="exampleModalLabel3" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel3">Mua bài hát</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/UserServlet?action=buySong" method="post">
                <div class="modal-body">
                    <input name="songId" id="songId1" hidden>
                    <select class="form-select" aria-label="Default select example" name="playListId">
                        <c:forEach items="${listPlayList}" var="playlist">
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
<script src="referenceAddSong.js"></script>
<script src="audioPlayer/audioPlayer.js"></script>
<script src="actionDelete.js"></script>
</body>
</html>
