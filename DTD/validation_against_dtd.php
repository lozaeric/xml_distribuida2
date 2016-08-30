<?php

if (!isset($argv[1])) {
  echo "Hay que pasar el archivo con la ruta completa!";
  exit(1);
}

$xmlFile = $argv[1];

try{
  $library = new DOMDocument();
  $library->validateOnParse = true;

  if ($library->load($xmlFile)) {
    if ($library->validate()) {
      echo "DTD Valido!";
    } else {
      echo "ATENCION! -> DTD NO VALIDO";
      exit(1);
    }
  } else {
    echo "XML erroneo";
  }


} catch (Exception $e) {
  echo "ATENCION! -> DTD NO VALIDO";
  exit(1);
}
exit(0);


 ?>
