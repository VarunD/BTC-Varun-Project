<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

<style>
.btn-warning
{
background-color:lightgreen;
}

.btn-danger
{
background-color:red;
}
<%--
.mt-3
{
background-image:url('WhatsApp Image 2022-08-02 at 2.16.03 PM.jpeg');
background-size:cover;
background-repeat:no-repeat;
margin:0px 0px 3px 30px;
padding:10px;
height:100vh;
}
--%>
body
{
background-image:url('WhatsApp Image 2022-08-02 at 2.16.03 PM.jpeg');
background-size:cover;
background-repeat:no-repeat;
}
#search
{
color:red;
}

.textsearch
{
align:center;
}


#delete
{
color:red;
}
</style>
</head>
<body>

	<div class=buttonDisplay> 
	<div  style ="text-align: center;"  id="add" class="toast_msg">${addMessage}</div>
	<div  style ="text-align: center;"  id="update" class="toast_msg">${updatemessage}</div>
	<div  style ="text-align: center;"   id="delete" class="toast_msg">${deleteMessage}
	</div>
	
	
	<div class="container mt-3">

		
		<h1 style="text-align:center;">Car Details</h1>
		
		<a href="insert-cars" class="btn btn-primary">Add Car</a>
		<br>
		<p></p>
		
		<div class="row">
		
			<form action="getAll" method="get"><%--no need slash --%>
			<p id=search>Search:	
			<input id="textsearch" type="text" name="keyword" style="width: 300px
			"placeholder="Enter Car registration Number or name" required></p>
			<button type="submit">Search</button>

			</form>
			</div>
			<br>
			<br>
			
			<table class="table table-hover"><%-- giver the light grey backgropund colour will be added to rows while the cursor hovers over them.. --%>
				<thead>
					<tr  style="background-color:light grey";>
				
						<th >Registration Number</th>
						<th scope="col">Car Name</th>
						<th scope="col">Car Brand</th>
						<th scope="col">Car Price</th>
						<th scope="col">Car Colour</th>	
						<th scope="col">Car Image</th>					
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="car" items="${getAllCars}">
						<tr >
					  
							<td class="table-plus">${car.registrationNumber}</td>
							<td>${car.carName}</td>
							<td>${car.carBrand}</td>
							<td>${car.carPrice}</td>
							<td>${car.carColour}</td>
							<td><img src="/image/${car.image}"width="30px"height="45px"></td>
							
							<td><a href="updateCar/${car.registrationNumber}" class="btn btn-warning">
									Update </a></td>
					
					<td>			
					<form method="get" action="deleteCar" >
					<input  type="text" name="registrationNumber" value="${car.registrationNumber}" hidden>
					<input  type="text" name="image" value="${car.image}" hidden>
					<button class="btn btn-danger" type="submit" onclick="confirmDelete()">Delete</button>
					</form>
				</td>
</tr>
			
					
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</div>

<script>
function confirmDelete()
{
	return confirm("Are you sure you want to delete?")
}

setTimeout (() =>{ document.getElementById('add').innerHTML="";}, 5000 );
setTimeout (() =>{ document.getElementById('update').innerHTML="";}, 5000 );
setTimeout (() =>{ document.getElementById('delete').innerHTML="";}, 5000 );


</script>
</body>
</html>