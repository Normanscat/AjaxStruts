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

.jurisave {
	width: 100%;
	/* 	border-top: 1px solid #000; */
}

.jurisave button {
	margin-top: 17px;
	position: absolute;
	width: 100px;
	border: none;
	border-radius: 10px;
}

.jurisave button.esc {
	background-color: red;
	margin-left: 30%;
}

.jurisave button.save {
	margin-left: 50%;
	background-color: green;
}
</style>

<body>
	<div class="containera">
		<div class="rolelog">添加权限</div>
		<div class="rolepancel">
			<span id="err"><font color="red">${message }</font></span> <label
				class="label">权 限：</label>
			<div class="input-group">
				<input type="text" name="juriname" class="input" id="juriname"
					placeholder="请输入权限名称名">
			</div>
			<label class="label">描 述：</label>
			<div class="input-group">
				<textarea rows="5" cols="50" name="rolescp" id="juriscp"
					placeholder="请输入权限描述"></textarea>
			</div>
			<div class="permission"></div>
			<div class="jurisave">
				<button class="esc" type="reset">取消</button>
				<button class="save" type="submit">保存</button>
			</div>
		</div>
	</div>
</body>
<script>
	$(".save").on("click", function() {
		var $containera = $(".containera")
		//input 输入框中的内容
		var juriname = $("#juriname").val();
		var juriscp = $("#juriscp").val();
		$.ajax({
			url : "savejuri",
			type : "post",
			data : {
				//键 值
				jurisavename : juriname,
				jurisavescp : juriscp
			},
			success : function(data) {
				//alert("啊啊")
				//自动点击
				if (data.message == "success") {
					$(".juri").trigger("click");
				} else {
					alert(data.message)
					$containera.load("addjuri")
				}
			}
		})
	});
	$(".esc").on("click", function() {
		$(".juri").trigger("click");
	});
</script>
</html>
