<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Searching Page</title>
<style type="text/css">
    .container {
        width: 700px;
        clear: both;
        margin-left: 300px;
    }
    .container input {
        width: 100%;
        clear: both;
    }
    .button {
    	margin-left: 600px;
    }

    </style>
</head>
<body>

		<p>
			&nbsp;</p>
		<p style="text-align: center;">
			&nbsp;</p>
		<h1 style="text-align: center;">
			<img alt="" src="http://www.ict.md/files/images/logo_jpg.jpg" style="width: 509px; height: 201px;" /></h1>
		<h1 style="text-align: center;">
			<span style="color: rgb(204, 102, 51); font-size: 48px;">FEDERATED &nbsp;SEARCH</span></h1>
		<p style="text-align: center;">
			<span style="font-family:tahoma,geneva,sans-serif;"><span style="font-family:verdana,geneva,sans-serif;"><span style="font-size:16px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Implemented by Georgiana Danila</span></span></span></p>
		<p style="text-align: center;">
			&nbsp;</p>
			
		<form action="results" method="post" target="_new">
		<div class="container">
		<input type="text" name="searchTerm"></div>
		<div class="button">
		<br>
		<input type="submit" value="Search">
		</div>
	</form>
	
</body>

</html>