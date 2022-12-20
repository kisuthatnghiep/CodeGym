<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/3/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MP3 Player</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
            rel="stylesheet"
    />
    <script
            type="module"
            src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
            nomodule
            src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
    ></script>
    <link rel="stylesheet" href="audioPlayer.css">
</head>
<body>
<div class="music">
    <div class="music-thumb">
        <img src="https://source.unsplash.com/random" alt="" />
    </div>
    <h3 class="music-name">Beautiful in white</h3>
    <input type="range" name="range" id="range" class="range" />
    <audio src="https://data.chiasenhac.com/down2/2261/6/2260237-44280fbe/128/Phao%20Hong%20-%20Dat%20Long%20Vinh.mp3" id="song"></audio>
    <div class="timer">
        <div class="duration">2:10</div>
        <div class="remaining">-3:10</div>
    </div>
    <div class="controls">
        <ion-icon name="infinite-outline" class="play-infinite"></ion-icon>
        <ion-icon name="play-back" class="play-back"></ion-icon>
        <div class="play">
            <div class="player-inner">
                <ion-icon name="play" class="play-icon"></ion-icon>
            </div>
        </div>
        <ion-icon name="play-forward" class="play-forward"></ion-icon>
        <ion-icon name="repeat-outline" class="play-repeat"></ion-icon>
    </div>
</div>
<script src="audioPlayer.js"></script>
<script src="../actionDelete.js"></script>
</body>
</html>
