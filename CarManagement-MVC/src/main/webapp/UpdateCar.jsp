<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.io.*, java.util.*, javax.servlet.*, java.text.SimpleDateFormat, java.sql.Timestamp "%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>


<style>

	
	
	.btn-primary
	{
		
		display:block;
		text-align:center;
		padding:10px;
		margin-left:-45%;
		background-color:grey;
		align:center;
		padding-left:center;
		position: absolute;
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
	
	body
	{
	background-image:url("C:\Users\Varun D\Downloads\whiteCar.jpg"); 
	
	}
	
	h1
	{
	color:black;
	text-align:center;
	}
	

	</style>
</head>
<body style="background-image: url('C:\Users\Varun D\Downloads\whiteCar.jpg');">

<div class="bccolour">


	<div class="container mt-3">

		<h1>Update Car Details..</h1>
		<form action="updatingCar" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="id">Registration Number</label> <input type="number"
							value="${cars.registrationNumber}" class="form-control" id="registrationNumber" name="registrationNumber"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Car Name</label> <input type="text"
							value="${cars.carName }" class="form-control" id="carName"
							<%-- HERE THE VALUE ARE THE PREVIOUSLY GIVEN DATAS  --%>
							name="carName" placeholder="Enter Car Name">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="brand">Car Brand</label> <input type="text"
							value="${cars.carBrand }" class="form-control"
							id="carBrand" name="carBrand"
							placeholder="Enter Car Brand">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="Price">Car Price</label> <input
							type="text" class="form-control" id="carPrice"
							value="${cars.carPrice }" name="carPrice"
							placeholder="Enter Car Price">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="Colour">Car Colour</label> <input type="text"
							value="${cars.carColour }" class="form-control" id="carColour"
							name="carColour" placeholder="EnterCar Colour">
					</div>
				</div>
				
			<% 
			Date today= new Date();
			
			SimpleDateFormat  date= new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss");
			//java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
            //   .parse("2012-07-10 14:58:00.000000");
			Timestamp time = new Timestamp(System.currentTimeMillis());
			%>
				
				<div hidden class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">last</label> <input type="text" value="<%=date.format(time)%>"
						class="form-control" id="lastModified" name=lastModified
						<%--used to consider a box as a input form--%>
							placeholder="Enter number">
					</div>
					<br>
				</div>
				
				
			</div>
<%-- 
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="address">Address</label>
						<textarea class="form-control" id="address" name="address"
							rows="5" placeholder="Enter Address"> ${employee.address } </textarea>
					</div>
				</div>
			</div>
--%>
			
  				<div class="vertical-center">
  				<br>
  				<br>
  				<br>
  				<br>
  			<center>
			<button type="submit" class="btn btn-primary" onclick="return addMessage(event)">Submit</button>
			<br>
			</center>
			</div>
			
			</div>
		</form>

	</div>
</div>

<script>
function addMessage()
{
	alert("Car details updated sucessfully..");
}
</script>
</body>
</html>


