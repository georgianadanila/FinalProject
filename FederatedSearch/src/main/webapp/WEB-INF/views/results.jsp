<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
<h1 style="text-align: center;">Results about ${searchTerm}</h1>
  <c:forEach items="${mergeResultList}" var="item">
    <h3>
    		<a href="${item.poster}" target="_self">
			<img src="${item.poster}" style="margin-right: 10px; float: left; width: 270px; height: 400px;" /></a>
			<span style="color:#008000;"><span style="font-family:verdana,geneva,sans-serif;"><a href="${item.url}" target="_self">${item.title}</a></span></span>
	</h3>
		<div style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Genre</strong>: <span style="font-size:14px;">${item.genre}</span></span>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Overview: </strong>: <span style="font-size:14px;">${item.overview}</span></span></p>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>IMDB Rating: ${item.imdbRating}</strong></span></p>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Awards: </strong>: <span style="font-size:14px;">${item.awards}</span></span></p>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Actors: </strong>: <span style="font-size:14px;">${item.actors}</span></span></p>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Year: </strong>: <span style="font-size:14px;">${item.year}</span></span></p>
		<p style="margin-left: 120px;">
			<span style="font-family: georgia, serif; font-size: 16px;"><strong>Country: </strong>: <span style="font-size:14px;">${item.country}</span></span></p>
		<p> &nbsp; &nbsp; &nbsp; </p>
		<p>  &nbsp; &nbsp; &nbsp;</p>
		<p> &nbsp; &nbsp; &nbsp; </p>
		<p>  &nbsp; &nbsp; &nbsp;</p>
		</div>
  </c:forEach>
</body>
</html>