<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
table {
	border-collapse: collapse;
	margin: 20px auto;
	text-align: center;
}

table thead {
	border-bottom: 2px solid gray;
}

table th {
	height: 50px;
	width: 140px;
}

table tr td {
	height: 50px;
	width: 180px;
	line-height: 40px;
}

.edit {
	color: blue;
}

.depdelete {
	color: red;
}

button {
	margin: 15px;
	width: 90px;
	height: 30px;
	border: none;
}

button:hover {
	filter: grayscale(0.4);
}

.search {
	margin-left: 500px;
}

.search::hover {
	filter: grayscale(0.4);
}
</style>
<div class="content">
	<div>${message }</div>
	<button class="btn-add-panel">添加</button>
	<button class="btn-delete-panel">删除</button>
	<input type="text" class="search" placeholder="请输入关键字">
	<button id="search">搜索</button>
	<hr>
	<table>
		<thead>
			<th class="all-bt">全选</th>
			<th>序号</th>
			<th>名称</th>
			<th>描述</th>
			<th>时间</th>
		</thead>
		<tbody>
			<!-- varStatus获取当前索引或序号 -->
			<c:forEach var="item" items="${dep }" varStatus="status">
				<tr class="goods-content-item" data-id="${item.id }">
					<!-- count获取当前序号，从1开始 -->
					<!-- index获取当前索引，从0开始 -->
					<td><input type="checkbox" data-id="${item.id }"></td>
					<td>${status.count }-${status.index }</td>
					<td>${item.departmentname }</td>
					<td>${item.departmentscp }</td>
					<td>${item.departmenttime }</td>
					<td><a class="edit" data-id="${item.id }"><u>编辑</u></a> <a
						class="depdelete" data-id="${item.id }"><u>删除</u> </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	$(function() {
		$("tr:odd").css({
			"background-color" : "#DCDCDC"
		});
		function changeBackground() {
			var $table = $("table");
			// 查找所有行并修改背景色
			$table.find("tr").css("background-color", "");
			// 查找所有奇数行 并修改背景色
			$table.find("tr:odd").css("background-color", "#DCDCDC");
		}

		$(".all-bt").on("click", function() {
			var $this = $("table");
			// 查找table下所有的CheckBox
			var checkbox = $this.find("input[type='checkbox']");
			// 获取CheckBox的状态
			var checkeds = $this.find("input[type='checkbox']:checked");
			var ischecked = checkeds.length == checkbox.length;
			// 修改CheckBox的状态与当前状态相反
			checkbox.prop("checked", !ischecked);
		});
		$("td:not(:first-child)").on("click", function() {
			var $this = $(this).parent();
			var nowItem = $this.find("input[type='checkbox']");
			var checked = nowItem.prop("checked");
			// 改变CheckBox的状态与当前的状态相反
			nowItem.prop("checked", !checked);
		});
		//删除
		$(".depdelete").on("click", function() {
			var $content = $(".content");
			var $table = $("table");
			// 判断显示的CheckBox中选中的数量为不为0
			if ($("input:checked:not(:hidden)").length == 0) {
				// 为0时 弹出提示框
				alert("请选择删除项！");
			} else {
				// 不为0 弹出提问框 定义一个变量保存用户的选择
				var r = confirm("确定删除选中项？");
				// 如果为true 则继续执行下一步
				if (r == true) {
					var $this = $(this);
					// 获取角色id
					var depId = $this.data("id");
					$.ajax({
						url : "depdelete",
						type : "post",
						data : {
							deldepId : depId
						},
						success : function(data) {
							/* $this.parent().parent().hide(); */
							changeBackground();
							/* alert(depId); */
							$(".dep").trigger("click");
						}
					})
				}
			}
		});
		//编辑
		$(".edit").on("click", function() {
			var $content = $(".content")
			var $this = $(this);
			var depeditId = $this.data("id");
			$content.load("editdep", {
				depeditId : depeditId
			});
		});
		//添加
		$(".btn-add-panel").on("click", function() {
			var $conten = $(".content");
			$conten.load("adddep")
		});
		//批量删除
		$(".btn-delete-panel").on("click", function() {
			var listid = new Array();
			var i = 0;
			if ($("input:checked").length == 0) {
				// 为0时 弹出提示框
				alert("请选择删除项！");
			} else {
				// 不为0 弹出提问框 定义一个变量保存用户的选择
				var r = confirm("确定删除选中项？");
				// 如果为true 则继续执行下一步
				if (r == true) {
					$("input[type='checkbox']:checked").each(function() {
						var $this = $(this);
						listid[i] = $(this).data("id");
						i = i + 1;
						//alert("获取到的ID为" + listid);
					});
					$.ajax({
						url : "deldepall",
						type : "post",
						async : "ture",
						traditional : "true",
						dataType : "json",
						data : {
							listid : listid
						},
						success : function(data) {
							//alert("返回的数据为" + data);
							$(".dep").trigger("click");
						},
						error : function() {
							alert("传输出错");
						}
					});
				}
			}
		});
		$("#search").on("click", function() {
			var $conten = $(".content");
			var search = $(".search").val();
			alert(search);
			$conten.load("searchdep", {
				search : search
			})
		});
		$(".btn-add-panel").css({
			"background-color" : "green",
			"border-radius" : "15px",
		});
		$(".btn-delete-panel").css({
			"background-color" : "red",
			"border-radius" : "15px"
		});
		$("#search").css({
			"background-color" : "#cdcdcd",
			"border-radius" : "15px"
		});
	});
</script>