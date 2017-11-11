<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.containera {
	/* border: 1px solid #000; */
	
}

.rolelog {
	height: 50px;
	line-height: 50px;
	font-size: 35px;
	padding-left: 40%;
	/* border-bottom: 1px solid #000; */
}

.rolepancel {
	height: 320px;
}

.label {
	margin-left: 30%;
	float: left;
}

.input-group {
	margin-top: 10px;
	height: 30px;
	margin-left: 30%;
	line-height: 30px;
}

.input-group .input {
	width: 200px;
}

textarea {
	height: 200px;
	resize: none;
}

.permission {
	margin-top: 200px;
	/*letter-spacing: 5px;*/
}

.rolesave {
	width: 100%;
	/* 	border-top: 1px solid #000; */
}

.rolesave button {
	margin-top: 17px;
	position: absolute;
	width: 100px;
	border: none;
	border-radius: 10px;
}

.rolesave button.esc {
	background-color: red;
	margin-left: 30%;
}

.rolesave button.save {
	margin-left: 50%;
	background-color: green;
}
</style>

<body>
	<div class="containera">
		 <label>${error }</label> 
		<!-- <form action="saverole" method="post"> -->
		<div class="rolelog">添加角色</div>
		<div class="rolepancel">
			<label class="label">名 称：</label>
			<div class="input-group">
				<input type="text" name="rolename" class="input" id="rolename" placeholder="请输入角色名称">
			</div>
			<label class="label">描 述：</label>
			<div class="input-group">
				<textarea rows="5" cols="50" name="rolescp" id="rolescp" placeholder="请输入角色描述"></textarea>
			</div>
			<div class="permission"></div>
			<div class="rolesave">
				<button class="esc" type="reset">取消</button>
				<button class="save" type="submit">保存</button>
			</div>
		</div>
		<!-- </form> -->
	</div>
</body>
<script>
	//添加
	$(".save").on("click", function() {
		//alert("${message }");
		var $containera = $(".containera");
		//input 输入框中的内容
		var rolename = $("#rolename").val();
		var rolescp = $("#rolescp").val();
		$.ajax({
			url : "saverole",
			type : "post",
			data : {
				//键 值
				rolesavename : rolename,
				rolesavescp : rolescp
			},
			success : function(data) {
				if (data.message == "success") {
					$(".role").trigger("click");
				} else {
					alert(data.message)
					$containera.load("addrole")
				}
			}
		});
	})
	$(".esc").on("click", function() {
		$(".role").trigger("click");
	});
</script>
</html>
