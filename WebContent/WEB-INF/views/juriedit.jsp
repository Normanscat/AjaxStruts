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

.jurilog {
	height: 50px;
	line-height: 50px;
	font-size: 35px;
	padding-left: 40%;
	/* border-bottom: 1px solid #000; */
}

.juripancel {
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

.depsave {
	width: 100%;
	/* 	border-top: 1px solid #000; */
}

.depsave button {
	margin-top: 17px;
	position: absolute;
	width: 100px;
	border: none;
	border-radius: 10px;
}

.depsave button.esc {
	background-color: red;
	margin-left: 30%;
}

.depsave button.save {
	margin-left: 50%;
	background-color: green;
}
</style>

<body>
	<div class="containera">
		<div class="jurilog">编辑权限</div>
		<div class="juripancel">
			<input type="hidden" name="jurieditid" value="${editjuri.id }"
				id="jurieditid"> <label class="label">权 限：</label>
			<div class="input-group">
				<input type="text" name="jurieditname" class="input"
					id="jurieditname" value="${editjuri.jurname }">
			</div>
			<label class="label">描 述：</label>
			<div class="input-group">
				<textarea rows="5" cols="50" name="jurieditscp" id="jurieditscp">${editjuri.jurscp }</textarea>
			</div>
			<div class="permission"></div>
			<div class="depsave">
				<button class="esc" type="reset">取消</button>
				<button class="save" type="submit">保存</button>
			</div>
		</div>
	</div>
</body>
<script>
	$(".save").on("click", function() {
		var $containera = $(".containera");
		//input 输入框中的内容
		var jurieditid = $("#jurieditid").val();
		var jurieditname = $("#jurieditname").val();
		var jurieditscp = $("#jurieditscp").val();
		$.ajax({
			url : "upjuri",
			type : "post",
			data : {
				//键 值
				juriupid : jurieditid,
				juriupname : jurieditname,
				juriupscp : jurieditscp
			},
			success : function(data) {
				$(".juri").trigger("click");
			}
		})
	});
	$(".esc").on("click", function() {
		$(".juri").trigger("click");
	});
</script>
</html>
