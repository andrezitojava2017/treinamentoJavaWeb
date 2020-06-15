<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload com AJAX e JavaScript</title>
</head>
<body>

<h3>UPLOAD FILE</h3>

<input type="file" id="file" name="file" onchange="upload();"/>
<img alt="img" src="" id="img" width="200" height="200"/>
</body>

<script type="text/javascript">

function upload(){
	var img = document.getElementById("img");
	var file = document.querySelector("input[type=file]").files[0];
	var reader = new FileReader();
	
	reader.onloadend = function(){
		img.src = reader.result;
		
		// mostra o valor da base64
		console.log(reader.result);
		
	};
	
	if(file){
		reader.readAsDataURL(file);
		// mostra o valor da base64
		console.log(reader.result);
	} else {
		img.src = "";
	}
}


</script>
</html>