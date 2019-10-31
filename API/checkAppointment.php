<?php
require "conn.php";
$id=$_GET["id"];

$month = date('m');
$day = date('d');
$year = date('Y');

$today = $year . '-' . $month . '-' . $day;

$response=array();

$sql="select patient_id,date from patient_doctor where doctor_id='$id' and date > '$today'";
$result=mysqli_query($conn,$sql);

if($result){
	while($row=mysqli_fetch_array($result)) {
             $patient_id=$row["patient_id"];
			 $date=$row["date"];
			 
			 $sql1="select name, surname, phone from patient where id = '$patient_id'";
			 $result1=mysqli_query($conn,$sql1);
				
			 if(mysqli_num_rows($result1)>0){
				$rows=mysqli_fetch_row($result1);
				$name=$rows[0];
				$surname=$rows[1];
				$phone=$rows[2];
				
				array_push($response,array("Name"=>$name,"Surname"=>$surname,"Phone"=>$phone,"Date"=>$date));
			 }
	}				
}

echo json_encode($response);
?>