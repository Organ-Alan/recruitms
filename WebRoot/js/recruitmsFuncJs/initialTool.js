/*
 * 工具
 * @param {Object} resultObj 
 */
function build_page_info(result) {
	$("#page_info_area").append("当前第  " +
	result.startRow + " 页，总共  " + result.pages +
	" 页,总共  " + result.total + " 条记录。");
}

function build_page_nav(result) {
	var ul = $("<ul></ul>").addClass("pagination");

	var firstPageLi = '<li class="first"><a href="javascript:;">首页</a></li>';
	var prePageLi = '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>';
	var nextPageLi = '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>';
	var lastPageLi = '<li class="last"><a href="javascript:;">末页</a></li>';
	ul.append(firstPageLi).append(prePageLi);
	$.each(result.navigatepageNums, function(index, item) {
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		ul.append(numLi);
	});
	ul.append(nextPageLi).append(lastPageLi);
	var navEle = $("<nav></nav>").append(ul);
	$("#page_nav_area").append(ul);

}