<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.containera {
	/* border: 1px solid #4589AE; */
}

.containera .userlog {
	font-size: 25px;
	text-align: center;
	height: 50px;
	/* border-bottom: 1px solid #4589AE; */
}

.useradd {
	margin-top: 20px;
	height: 300px;
}

label {
	font-size: 20px;
	margin-left: 20px;
}

.input {
	width: 200px;
	height: 25px;
}

.input-group {
	margin-left: 25%;
	margin-top: 20px;
}

.depet {
	margin-left: 70px;
}

.select {
	width: 200px;
	height: 30px;
	font-size: 16px;
}

textarea {
	height: 200px;
	margin-left: 10px;
	resize: none;
}

.rolepancel {
	height: 400px;
}

.usersave {
	width: 500px;
	margin: 50px auto;
	display: flex;
	justify-content: space-between;
	align-content: center;
}

.usersave button {
	margin-top: 17px;
	width: 100px;
	height: 35px;
	border: none;
	border-radius: 10px;
}

.usersave button.esc {
	background-color: red;
}

.usersave button.save {
	background-color: green;
}

.juris {
	display: flex;
	justify-content: center;
	padding: 30px;
}
</style>

<body>
	<div class="containera">
		<div class="userlog">编辑用户</div>
		<div class="useradd">
			<div class="input-group">
				<input type="hidden" name="usereditid" value="${edituser.id }"
					id="userupid"> <label>用户名：</label> <input type="text"
					name="username" class="input" id="userusername"
					value="${edituser.username }"> <label>密　码：</label>
				<input type="password" name="password" class="input"
					id="userpassword" value="${edituser.password }">
			</div>
			<div class="input-group">
				<label>姓　名：</label> <input type="text" name="username" class="input"
					id="username" value="${edituser.name }"> <label>手　机：</label>
				<input type="text" name="phone" class="input" id="phone"
					value="${edituser.phone }">
			</div>
			<div class="input-group">
				<label>性　别：</label>&nbsp&nbsp男&nbsp&nbsp： <input type="radio"
					name="sex" id="sex" value="男" checked="checked">&nbsp&nbsp女&nbsp&nbsp： <input
					type="radio" name="sex" id="sex" value="女"> <label
					class="depet">　&nbsp;&nbsp;部　门：</label> <select class="select"
					id="userdep">
					<c:forEach var="item" items="${dep }">
						<option data-id="${item.id }">${item.departmentname }</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-group">
				<label>状　态：</label> 启用： <input type="radio" name="usersta"
					id="usersta" value="启用" checked="checked"> 禁用： <input type="radio"
					name="usersta" id="usersta" value="禁用"> <label
					class="depet">　&nbsp;&nbsp;角　色：</label> <select class="select"
					id="userrole">
					<c:forEach var="item" items="${role }">
						<option data-id="${item.id }">${item.rolename }</option>
					</c:forEach>
				</select>
			</div>
			<div class="juris">
				权　限：
				<c:forEach var="item" items="${juri }">
			${item.jurname }<input type="checkbox" data-id="${item.id }"
						id="juriid">
				</c:forEach>
			</div>
			<div class="usersave">
				<button class="esc" type="reset">取消</button>
				<button class="save" type="submit">保存</button>
			</div>
		</div>
	</div>
</body>
<script>
$(function() {
	$(".save").on("click", function() {
		var $containera = $(".containera");
		//input 输入框中的内容
		var userupid = $("#userupid").val();
		var userusername = $("#userusername").val();
		var userpassword = $("#userpassword").val();
		var username = $("#username").val();
		var phone = $("#phone").val();
		/* 获取被选中radio的val内容 */
		var sex = $("#sex:checked").val();
		/* 获取被选中option中文本框的内容 */
		var userdep = $("#userdep option:selected").data("id");
		var userrole = $("#userrole option:selected").data("id");
		var usersta = $("#usersta:checked").val();
		var juriid = $("#juriid:checked").data("id");
		$.ajax({
			url : "upuser",
			type : "post",
			data : {
				//键 值
				userupid : userupid,
				userupusername : userusername,
				useruppassword : userpassword,
				userupname : username,
				upphone : phone,
				upsex : sex,
				upuserdep : userdep,
				upuserrole : userrole,
				upusersta : usersta,
				juriid : juriid
			},
			success : function(data) {
				$(".user").trigger("click");
			},
		})
	});
	$(".esc").on("click", function() {
		$(".user").trigger("click");
	});
});
</script>

</html>