<?php
include_once("conexion.php");

$result=array();
$result['datos'] =array();
$select="SELECT * from libros";
$mostrar=mysqli_query($con,$select);

while ($row = mysqli_fetch_array($mostrar)) 
{
    $index['id']=$row['0'];
     $index['titulo']=$row['1'];   
      $index['autor']=$row['2'];
       $index['categoria']=$row['3'];
        $index['nro_paginas']=$row['4'];
         $index['editorial']=$row['5'];
          $index['referencia']=$row['6'];

          array_push($result['datos'],$index);
}
$result["success"]="1";
echo json_encode($result);
mysqli_close($con);