// 根据data生成文章简略项
function createArticle(data) {
    console.log(data.tags.split("|")+"--------打印");
    let num = data.tags.split("|")[2] != "#" ? data.tags.split("|")[2] : 1;
    let articleStr = `<div class="article">
                    <h1>${data.header}</h1>
                    <div class="tags">
                        <span class="tag-item tag-date" >${data.tags.split("|")[0]}</span>
                        <span class="tag-item tag-class">${data.tags.split("|")[1]}</span>
                    </div>
                    <div class="box">
                        <div class="box-img">
                            <div class="image" style="background-image: url('${data.image}')"></div>
                            <p class="box-introduce">
                            
                                <a href="/page/${num}" class="introduce-text">
                                    ${data.introduction}
                                </a>
                            </p>
                        </div>
                    </div>
                </div>`;
    return $(articleStr);
}