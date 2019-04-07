<?php
$username = " ";
$password = " ";
$database = " ";
$link = mysqli_connect("127.0.0.1", $username, $password, $database);
$output=array();
$LINK_NO=$_REQUEST["link_no"];

/* Select queries return a resultset */
if ($result = mysqli_query($link, "SELECT LINKS FROM EVENTS WHERE LINK_N0='$LINK_N0'")) {
while ($row=$result->fetch_assoc()){
$output[]=$row;
}
}
mysqli_close($link);
echo json_encode($output);
?>