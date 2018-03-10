/*
 * 工具
 * @param {Object} resultObj 
 */
function build_page_info(result) {
	$("#page_info_area").append(
			"当前第  " + result.startRow + " 页，总共  " + result.pages + " 页,总共  "
					+ result.total + " 条记录。");
}

function logout(){
	$.ajax({
		type : "get",
		url : "/recruitms/admin/logout",
		dataType : 'json',
		async:true,
		success : function(resp) {
			if (resp.code == 0) {
				//将token存在本地存储，然后跳转到主页面
				location.href="login.jsp";

			} else {
				$('#LoadError').click();
				return;
			}
		}
	});
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

// 取得所有的复选框对象数组
function GetAllCheckBox() {
	var div = document.getElementById("Balls");
	var inputs = div.getElementsByTagName("input");
	// 定义复选框数组，用来返回
	var checkboxs = new Array();
	var nIndex = 0;
	for (var i = 0; i < inputs.length; i++) {
		// 通过type是否为checkbox来判断复选框
		if (inputs[i].type == "checkbox") {
			checkboxs[nIndex] = inputs[i];
			nIndex++;
		}
	}
	return checkboxs;
}

// 全选
function selAll() {
	var checkboxs = GetAllCheckBox();
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = true;
	}
}

// 全清
function clearAll() {
	var checkboxs = GetAllCheckBox();
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = false;
	}
}

// 反选
function reverseAll() {
	var checkboxs = GetAllCheckBox();
	for (var i = 0; i < checkboxs.length; i++) {
		if (checkboxs[i].checked == true) {
			checkboxs[i].checked = false;
		} else {
			checkboxs[i].checked = true;
		}
	}
}
function getAllids() {
	// 得到chekbox对象
	var checkbox = document.getElementsByName("che");
	// alert("checkbox的长度为："+checkbox.length);
	var id = "";
	// 当选中时，拿到它的value值，并拼起来
	// 需要注意的是，这样拼出来的id字符串，是以 ","结尾的，所以在使用的时候，应先将 ","去掉，也可在if中做判断
	// 当为最后一个时，拼的时候不加 ","
	for (var i = 0; i < checkbox.length; i++) {
		if (checkbox[i].checked) {
			id = id + checkbox[i].value + ",";
		}
	}
	// alert("id为："+id);
	return id;
}
var DataDeal = {
        //将从form中通过$('#refer').serialize()获取的值转成json
        formToJson: function (data) {
            data=data.replace(/&/g,"\",\"");
            data=data.replace(/=/g,"\":\"");
            data="{\""+data+"\"}";
            return data;
        }
    };