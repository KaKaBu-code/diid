// 具体页面数据生成

// 生成图片项
function createPageImage(path) {
    let str = `<div class="img-item">
                    <div class="img" style="background-image: url('${path}')">
                    </div>
               </div>`;
    return $(str);
}

// 根据请求的data数据更新页面
function updatePage(data) {
    let $classes = $(".content>.content-l>.main-content>.article>.nav>.classes");
    let $miniHeader = $(".content>.content-l>.main-content>.article>.nav>.mini-header");
    let $header = $(".content>.content-l>.main-content>.article>h1>a");
    let $tagItem =  $(".content>.content-l>.main-content>.article>.tags>.tag-item");
    let $imgLists =  $(".content>.content-l>.main-content>.article>.images>.imgs-list");
    let $introBody =  $(".content>.content-l>.main-content>.article>.intro>.body");

    console.log("更新页面");
    // 导航栏文字
    $classes.text(data.intro.tags.split("|")[1]);
    // 导航栏小标题
    $miniHeader.text(data.intro.header);
    // 文章标题
    $header.text(data.intro.header);
    // 文章tag
    $tagItem.text(data.intro.tags.split("|")[0]);
    // 文章图片
    $imgLists.empty();
    data.article.images.forEach(function (val) {
       $imgLists.append(createPageImage(val));
    });
    // 文章主体内容
    $introBody.html(data.article.article);
}

// 发送ajax请求获取具体的页面数据
function getPage() {
    $.ajax({
        url: "/article/info/"  + window.currentPageIndex,
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log("获取页面数据");
            console.log(data);
            // 更新页面
            updatePage(data);
        }
    });
}

$(function () {
    // 获取当前页面的索引！！！
    window.currentPageIndex =
        window.location.href.substring(window.location.href.lastIndexOf("/") + 1);
    // window.alert(window.currentPageIndex);
    console.log(window.currentPageIndex);

    // 请求数据
    getPage();

});