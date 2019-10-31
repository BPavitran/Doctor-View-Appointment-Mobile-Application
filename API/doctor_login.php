<?php
require "conn.php";
$username=$_POST["username"];
$user_pass=$_POST["password"];

$mysql_qry="select name,id,full_name from doctor where username like '$username' and password like '$user_pass';";
$result=mysqli_query($conn,$mysql_qry);
$response=array();
if(mysqli_num_rows($result)>0){
	//echo "Patient Login success";
	$row=mysqli_fetch_row($result);
	$name=$row[0];
	$id=$row[1];
	$full_name=$row[2];
	$code="login_success";
	array_push($response,array("code"=>$code,"name"=>$name,"id"=>$id,"full_name"=>$full_name));
	echo json_encode($response);
}
	else{
		//echo "Login not success";
		$code="login_failed";
		$message="User not found...Please try again...";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	}
?>