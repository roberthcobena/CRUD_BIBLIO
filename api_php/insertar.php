<?php
include_once("conexion.php");
$titulo=$_POST["titulo"];
$autor=$_POST["autor"];
$editorial=$_POST["editorial"];
$nro_paginas=$_POST["nro_paginas"];
$categoria=$_POST["categoria"];
$referencia=$_POST["referencia"];

$query="INSERT INTO libros(titulo,autor,categoria,nro_paginas,editorial,referencia) VALUES('$titulo','$autor','$categoria','$nro_paginas','$editorial','$referencia')";
$insert=mysqli_query($con,$query);
if ($insert) {
    echo ("Datos ingresados correctamente");
}else {
    echo("Datos NO ingresados, re-intente");
}