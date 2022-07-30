// 首页设置

// 更新页面分页列表（分页逻辑处理）
function updatePageLists(current, pages, articles, pglists) {
    console.log("当前页=" + current + ":" + "总页数=" + pages);
    if (current === "...") {
        return;
    }

    window.pages = pages;
    window.articles = articles;
    window.pglists = pglists;

    let totals = window.parseInt(pages);
    let num = current == "«" ? 1 : current == "»" ? totals : window.parseInt(current);


    pglists.empty();
    if (num <= 3) {
        pglists.append(createPaginations("«", false));
        for (let i = 1; i <= 5 && i <= totals; i++) {
            pglists.append(createPaginations("" + i, i == num));
        }
        if (totals > 5) {
            pglists.append(createPaginations("...", false));
        }
        pglists.append(createPaginations("»", false));
    } else if (totals - num <= 2) {
        pglists.prepend(createPaginations("»", false));
        for (let i = totals; i >= 1 && i >= totals - 4; i--) {
            pglists.prepend(createPaginations("" + i, i == num));
        }
        if (totals - 5 > 0) {
            pglists.prepend(createPaginations("...", false));
        }
        pglists.prepend(createPaginations("«", false));
    } else {
        pglists.append(createPaginations("«", false));
        pglists.append(createPaginations("...", false));
        for (let i = num -2; i <= num + 2; i++) {
            pglists.append(createPaginations( "" + i, i == num));
        }
        pglists.append(createPaginations("...", false));
        pglists.append(createPaginations("»", false));
    }
}

// 发送ajax请求获取首页页面数据（current代表当前页）,上来直接执行
function getArticle(current, articles, pglists) {
    $.ajax({
        url: "/article/intro",
        type: "GET",
        dataType: "json",
        data: {
            current: current
        },
        success: function (data) {
            console.log("请求数据");
            console.log(data);
            articles.empty();
            console.log(data.data)
            data.data.forEach(function (item) {//
                // 文章列表添加文章项
                articles.append(createArticle(item));
                console.log("插入数据" + item);
            });
            // 返回顶部
            retToTop(document.body);
            // 更新分页列表
            updatePageLists(data.current, data.pages, articles, pglists);
        }
    });
}

// 返回顶部，刷新的时候自动向上滚动。
function retToTop(item) {
    let speed= Math.floor(-item.scrollTop / 30);
    let timer = window.setInterval(function(){
        if ( item.scrollTop <= 0 ) {
            window.clearInterval(timer);
        }
        item.scrollTop += speed;
    },10);
}

$(function () {
    let $notice = $(".notice");
    let $noticeClose = $(".notice-close");

    let $articles = $(".articles");// 浏览器直接打印的时机是赋值之后阿。

    let $pglists = $(".pagination>.list");


    // 公告栏的close的click点击事件
    $noticeClose.click(function () {
        window.alert("点击关闭");
        $notice.hide();
    });

    // 默认获取第1页数据
    getArticle(1, $articles, $pglists);
});