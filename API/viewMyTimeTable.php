<?php
require "conn.php";
$id=$_GET["id"];

$response=array();

$sql="select day,time from time_table where doctor_id='$id'";
$result=mysqli_query($conn,$sql);

if($result){
	while($row=mysqli_fetch_array($result)) {
		array_push($response,array("Day"=>$row['day'],"Time"=>$row['time']));
	}
}

echo json_encode($response);
?>