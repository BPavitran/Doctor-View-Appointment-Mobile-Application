<?php
require "conn.php";
$id=$_GET["id"];

$mysql_qry="select * from doctor where id like '$id'";
$result=mysqli_query($conn,$mysql_qry);
$response=array();
if(mysqli_num_rows($result)>0){
	$row=mysqli_fetch_row($result);
	$name=$row[1];
	$surname=$row[2];
	$full_name=$row[3];
	$age=$row[4];
	$specialization=$row[5];
	$gender=$row[6];
	$blood=$row[7];
	$address=$row[8];
	$city=$row[9];
	$phone=$row[10];
	$NIC=$row[11];
	$email=$row[12];	
	$username=$row[14];
	array_push($response,array("name"=>$name,"surname"=>$surname,"full_name"=>$full_name,"age"=>$age,"specialization"=>$specialization,"gender"=>$gender,"blood"=>$blood,"NIC"=>$NIC,"address"=>$address,"city"=>$city,"email"=>$email,"phone"=>$phone,"username"=>$username));
	echo json_encode($response);
}
?>