<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Smart Farms</title>
<meta name="viewport" content="width=width-device,initial-scale =1" />
<link rel="stylesheet" 
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<script src="https://code.jquery.com/jquery-1.12.4.js" >
</script>

<style>
p,h2{margin: 0px}
 .header{
 background-color: orange;
 height: 100px;
 text-align: center;
 display: flex;
 align-items: center;
 }
 .footer{
 background-color: orange;
 height: 100px;
 text-align: center;
 display: flex;
 align-items: center;
 }
 .main{
 height: 800px;
 padding-top:30px;
 padding-bottom: 30px;
 }
 .details {
 list-style: none;
 }
</style>
</head>
<body>
<div class="header">
 <div class="container">
 <h2>LIST OF IOT </h2>
 </div>
</div>
<div class="main">
<div class="container">
 <div id="result" class="row">
 
 </div>
</div>
</div>
<div class="footer">
 <div class="container">
 <p>@TH CNTT 2</p>
 </div>
</div>

<script>
 $(document).ready(function(){
	 
 loadFarms();

 function loadFarms(){
	 $.ajax({
	 type:'GET',
	 contentType: "application/json",
	 dataType: 'json',
	 url: 'http://localhost:8080/Back_end03/sensor',
	 success: function(data){
	 var str="";
	 $.each(data, function(i, item){
	
	 str+='<div class="col-md-4 device">';
	 str+='<img class="img-thumbnail" src="./images/chart1.jpg"/>';
	 str+='<h5>'+item.SensorKeyName'</h5>';
	 str+='<h5>'+item.AttributeName'</h5>';
	 str+='<p>'+item.Value'</p>';
	 str+='<p>'+item.TimeAt'</p>';
	 str+='<p>'+item.Assetid'</p>';
	 str+='<ul class="details">';
	 str+='<li>';
	 str+='<span style="font-size: 32px; color: red;">';
	 str+='<i class="fas fa-temperature-high"></i> 29.5';
	 str+='</span>';
	
	 str+='<li>';
	 str+='<span style="font-size: 32px; color: blue;">';
	 str+='<i class="fas fa-water"></i> ';
	 str+='</span> ';
	 str+='</li>';
	 str+='</ul>';
	 str+='<a href="#" class="btn btn-primary btnsm" >Details</a>';
	
	 str+='</div>';
	 })
	 console.log(data);
	 console.log(str);
	 
	 $("#result").append(str);
	
	 },
	 error: function(data){
	 alert("error");
	 }
	 })
 	}
 })
</script>


</body>
</html>