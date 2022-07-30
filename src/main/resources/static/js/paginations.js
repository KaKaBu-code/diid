// 生成分页小按钮

function createPaginations(text, isActived) {
    let pgLiStr;
    if (isActived) {
        pgLiStr = `<li class="pg-active"><a href="#">${text}</a></li>`
    } else {
        pgLiStr = `<li><a href="#">${text}</a></li>`
    }
    let $ret = $(pgLiStr);

    // 分页按钮点击事件处理
    $ret.click(function () {
        // window.alert(text);
        if (text == "...") {
            return;
        }
        getArticle(
            (text == "«" ? 1 : text == "»" ? window.pages : window.parseInt(text)),
            window.articles,
            window.pglists);
    })
    return $ret;
}