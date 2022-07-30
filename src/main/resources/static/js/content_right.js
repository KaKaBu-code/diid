// 右部面板中的音乐播放器设置
$(function () {
    let $headerClose = $(".music-player-header .header-close");
    let $headerArrow = $(".music-player-header .header-arrow");


    let musicBox = document.getElementById("music-box");
    let $musicBar = $(".music-box > .music-bar");
    let $musicPanel = $(".music-box .music-panel");
    let audio = document.getElementById("music");
    // 初始音量为0.3
    audio.volume = 1.0 * 30 / 100;


    let musicButtons = document.getElementById("music-buttons");
    let $playButton = $(".music-buttons .play-button");
    let $musicAdd = $(".music-buttons .sound-button .btn-add");
    let $musicNum = $(".music-buttons .sound-button .music-num");
    let $musicSub = $(".music-buttons .sound-button .btn-sub");


    let flag = false;
    let deg = 0;
    let timer;

    // 音量增加按钮添加click点击事件
    $musicAdd.click(function () {
        let volume = parseInt($musicNum.text());
        if (volume < 100) {
            volume += 1;
            $musicNum.text(volume);
            audio.volume = 1.0 * volume / 100;
        }
    });

    // 音量减少按钮添加click点击事件
    $musicSub.click(function () {
        let volume = parseInt($musicNum.text());
        if (volume > 0) {
            volume -= 1;
            $musicNum.text(volume);
            audio.volume = 1.0 * volume / 100;
        }
    });

    // 暂停播放按钮添加click点击事件
    $playButton.click(function () {
        flag = !flag;
        $playButton.toggleClass("music-pause");
        $playButton.toggleClass("music-play");
        if (flag) {
            audio.play();
            $musicBar.css({
                transform: "rotate(25deg)"
            });
            timer = setInterval(function () {
                deg += 10;
                $musicPanel.css({
                    transform: `rotate(${deg}deg)`
                }, 100)
            }, 300);
        } else {
            audio.pause();
            $musicBar.css({
                transform: "rotate(0deg)"
            });
            clearInterval(timer)
        }
    })

    // 播放器close关闭按钮添加click点击事件
    $headerClose.click(function () {
        audio.pause();
        $(".music-player").hide();
    });

    let arrowDown = false;
    // 播放器收缩按钮添加click点击事件
    $headerArrow.click(function () {
        arrowDown = !arrowDown;
        if (arrowDown) {
            $(musicButtons).slideUp();
            $(musicBox).slideUp();
        } else {
            $(musicButtons).slideDown();
            $(musicBox).slideDown();
        }
        $headerArrow.toggleClass("header-arrow-up");
        $headerArrow.toggleClass("header-arrow-down");
    })
});