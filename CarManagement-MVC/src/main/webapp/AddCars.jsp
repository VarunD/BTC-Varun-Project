<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.io.*, java.util.*, javax.servlet.*, java.text.SimpleDateFormat, java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
	<style>
	.btn-primary
	{
		text-align:center;
		padding:10px;
		margin-rigth:auto;
		background-color:grey;
		align:center;
	}
	.mt-3
	{
	background-image:url('WhatsApp Image 2022-08-01 at 8.34.43 AM.jpeg');
	background-size:cover;
	background-repeat:no-repeat;
	margin:0px 0px 3px 20px;
	padding:10px;
	height:100vh;
	}
	h1
	{
	color:blue;
	text-align:center;
	}
	name
	{
	font-weight:bold;
	}
	</style>
<body>

	<div class="container mt-3">

		<h1>Adding  the Car</h1>
		
		<br>
		
		<form action="add-cars" method="post">
<%-- 
<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="registrationNumber">registrationNumber</label>
						<textarea class="form-control" id="registrationNumber" name="registrationNumber"
							rows="5" placeholder="Enter the registrationNumber"> </textarea>
					</div>
				</div>
			</div>
--%>


	<div class="row">
				<div class="col"> <%-- column wise--%>
					<div class="form-group">
						<label for="name">RegistrationNumber</label> <input type="text"
							class="form-control" id="registrationNumber" name="registrationNumber"
							value="1" placeholder="Enter Car registration Number" required minlength="4">
					</div>
				</div>

<%-- In this it will call the String abc--%>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Car Name</label> <input type="text"
						class="form-control" id="name" name="carName"
						<%--used to consider a box as a input form--%>
							placeholder="Enter Car Name">
							
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="CarBrand">Car Brand</label> <input type="text"
							class="form-control" id="CarBrand" name="CarBrand"
							placeholder="Enter Car Brand">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="carPrice">Car Price</label> <input
							type="text" class="form-control" id="carPrice"
							name="carPrice" placeholder="Enter Car Price">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="carColour">Car Colour</label> <input type="text"
							class="form-control" id="carColour" name="carColour"
							placeholder="Enter Car Colour">
					</div>
				</div>
			</div>	
	<%-- <a href="${pageContext.request.contextPath}
				class="btn btn-warning"> Back </a> 	 --%>				
				<div class="col-md-12 row">
				<div class="col-md-5"></div>
				<br>
				<br>
				<div class="col-md-2"><button type="submit" class="btn btn-primary" onclick="return addMessage(event)">Submit</button></div>
				<div class="col-md-5"></div>
			</div>
			
			<% 
			Date today= new Date();
			SimpleDateFormat  date= new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss'Z'");
			//Timestamp time = new Timestamp(System.currentTimeMillis());
			//System.out.println(new Timestamp(today.getTime()));
			Timestamp time = new Timestamp(today.getTime());
			%>
			
		 
			<div hidden class="row">
				<div class="col">
					<div class="form-group">
						<label for="name"></label> <input type="text" value="<%=date.format(time)%>"
						class="form-control" id="lastModified" name=lastModified
						<%--used to consider a box as a input form--%>
							placeholder="Enter number">
					</div>
				</div>
				
				<div hidden class="row">
				<div class="col">
					<div class="form-group">
						<label for="name"></label> <input type="text" value="<%=date.format(time)%>"
						class="form-control" id="lastModified" name=lastModified
						<%--used to consider a box as a input form--%>
							placeholder="Enter number">
					</div>
				</div>
		</form>		
	</div>
<script>

function addMessage()
{		
	alert("Car Details added sucessfully..");
}



</script>
</body>
</html>