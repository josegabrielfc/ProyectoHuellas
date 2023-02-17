
// Esta librería ha sido desarrollada para la version de Arduino 1.8.5
// y en caso de encontrarse BUGS en futuras versiones de Arduino
// El soporte lo encontrarán en el Canal de Youtube "Innova Domotics"
// https://www.youtube.com/c/innovadomotics en el vídeo dedicado al
// SENSOR DE HUELLA cuyas actualizaciones estarán en enlaces descargables 
// en la descripción del vídeo
//--------------------------------------------------------------------
// Esta librería no se ha testeado con versiones anteriores de Arduino
//--------------------------------------------------------------------

#include <InnovaS_Dactilar.h>

#include <SoftwareSerial.h>

// pin #2 - Entrada desde el Sensor  (cable verde)
// pin #3 - Salida de desde Arduino  (cable blanco)

SoftwareSerial MySerial(2, 3);

uint32_t ClaveSensorHuella = 0;
InnovaS_Dactilar MySensorDactilar = InnovaS_Dactilar(&MySerial, ClaveSensorHuella);

void setup()
{ 
    Serial.begin(57600);
    Serial.println("Sensor de Huella");
  
    //Setea la velocidad de comunicacion con el sensor de huella
    //Iniciar verificando los valores de 9600 y 57600
    MySensorDactilar.begin(57600);
    
    if (MySensorDactilar.VerificarClave()) {
      Serial.println("Sensor de Huella Encontrado :)  :) ");
    } else {
      Serial.println("No fue posible encontrar al sensor de Huella  :(  :( ");
      while (1);
    }
}

void loop()                     
{ 
  Serial.println("SELECCIONE LA ACCION QUE DESEA REALIZAR"); // indica que se realize una accion y este mensaje es visto enla compu por el momento
  char incomingByte;
 
  while (true) //INGRESA AUN LAZO QUE ESPERA UN CARACTER
  { 
    while (! Serial.available());
    
    incomingByte = Serial.read();  
    if (incomingByte=='E'){Serial.println("Enrolamiento"); } 
    if (incomingByte=='D'){Serial.println("Eliminar Huella"); } 
    if (incomingByte=='H') {Serial.println("Detectar Huella"); } 
    if (incomingByte=='B') {Serial.println("Borrar Todos"); } 
    break;//luego de recibir el caracter en esta linea sale del lazo
  }
  
  //BORRAR TODOS LOS DATOS
  if (incomingByte=='B'){BorrarAllUsers();} 
  //REGISTRA LOS USUARIOS
  if (incomingByte=='E'){RegisOneUser();}
  //ELIMINA UN USUARIO
  if (incomingByte=='D'){DeleteOneUser();}
  //BUSCA SI EL USUARIO SE ENCUENTRA ENROLADO
  if (incomingByte=='H'){DetectarUser();}          
}

void BorrarAllUsers(void) 
{
   byte TotalRegistrados = (byte)MySensorDactilar.ContarRegistrados();
   Serial.print("El sensor tiene "); Serial.print(TotalRegistrados); Serial.println(" usuarios registrados");
   EliminarBaseDatos();
   TotalRegistrados = (byte)MySensorDactilar.ContarRegistrados();
   if (TotalRegistrados==0)
   {
      Serial.print("El sensor tiene "); Serial.print(TotalRegistrados); Serial.println(" usuarios registrados");
      Serial.println("TODOS LOS USUARIOS FUERON BORRADOS");
      delay(2000);
   }
}
  
void RegisOneUser(void) 
{
  Serial.println("Ingrese el Numero del ID de la huella a guardar (1 -127): ");
  int my_id = 0;
  
  while (true) 
  {
    while (! Serial.available());
      
    char c = Serial.read();
        
    if (! isdigit(c)) break;
    my_id *= 10;
    my_id += c - '0';
    
    Serial.print("c: "); Serial.println(c);
    Serial.print("my_id: "); Serial.println(c);
  }
  Serial.print("Enrolando ID #");
  Serial.println(my_id);delay(1000);  
  while (SDACTILAR_Enrolar(my_id));
}

void DeleteOneUser(void) 
{
  Serial.println("Ingrese el numero del ID que desea eliminar: ");
  uint8_t my_id = 0;
  
  while (true) {
    while (! Serial.available());
    char c = Serial.read();
    if (! isdigit(c)) break;
    my_id *= 10;
    my_id += c - '0';
  }
  Serial.print("Eliminando ID #");
  Serial.println(my_id);    
  delay(1000); 
  EliminarUN_ID_DACTILAR(my_id);     
}

void BuscarID_Huella(void) 
{
  int p = -1;
  p = MySensorDactilar.CapturarImagen();
  if (p != SDACTILAR_OK)  return;

  p = MySensorDactilar.GenerarImg2Tz();
  if (p != SDACTILAR_OK)  return;

  p = MySensorDactilar.BusquedaRapida();
  if (p != SDACTILAR_OK)  return;
  
  Serial.print("Encontrado ID #"); Serial.print(MySensorDactilar.Id_Dactilar); 
  Serial.print(" con seguridad: "); Serial.println(MySensorDactilar.Seguridad);

  if (MySensorDactilar.Id_Dactilar ==1){Serial.println("ID#1");}
  if (MySensorDactilar.Id_Dactilar ==2){Serial.println("ID#2");}
  if (MySensorDactilar.Id_Dactilar ==3){Serial.println("ID#3");}  
}

void DetectarUser(void) 
{
  char incomingByte;
  while (true) 
  {
    BuscarID_Huella();
    delay(100);         
    if (Serial.available()>0)
    {
      incomingByte = Serial.read();
      if (incomingByte=='X'){ break; }          
    }
  }     
}

void EliminarUN_ID_DACTILAR(uint8_t id) {
  uint8_t p = -1;
  
  p = MySensorDactilar.EliminarModelo(id);

  if (p == SDACTILAR_OK) {
    Serial.println("ID Eliminado!");
  } else if (p == SDACTILAR_PAQUETE_IN_ERROR) {
    Serial.println("Error en Comunicacion");
    return p;
  } else if (p == SDACTILAR_ERROR_UBICACION) {
    Serial.println("No es posible eliminar en dicha ubicacion");
    return p;
  } else if (p == SDACTILAR_ERROR_FLASH) {
    Serial.println("Error escribiendo en la flash");
    return p;
  } else {
    Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
    return p;
  }  
  delay(1000); 
}

void EliminarBaseDatos (void)
{
    uint8_t p = MySensorDactilar.VaciarBaseDatos();
    delay(100);
    switch (p) {
    case SDACTILAR_BD_OK:
      Serial.println("Exito - Base de Datos Eliminada");
      break;
    case SDACTILAR_BD_PAQUETE_ERROR:
      Serial.print("Error al recibir el paquete");
      break;
    case SDACTILAR_BD_ERROR:
      Serial.print("Error al eliminar");
      break;
    default:
      Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
      break;
    }
}

boolean SDACTILAR_Enrolar(int id) 
{
  int p = -1;
  Serial.println("INGRESANDO");delay(1000); 
  Serial.println("Esperando una huella valida para enrolar");delay(1000); 
  
  while (p != SDACTILAR_OK) {
    p = MySensorDactilar.CapturarImagen();
    switch (p) {
    case SDACTILAR_OK:
      Serial.println(" ");
      Serial.println("Imagen Tomada");
      break;
    case SDACTILAR_D_NO_DETECTADO:
      Serial.print(".");
      //Serial.println("No se encuentra al dedo");
      break;
    case SDACTILAR_PAQUETE_IN_ERROR:
      Serial.println("Error al recibir el paquete");
      break;
    case SDACTILAR_IMG_ERROR:
      Serial.println("Error al determinar la imagen");
      break;
    default:
      Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
      break;
    } 
  }

  // OK success!
  p = -1; 
  p = MySensorDactilar.GenerarImg2Tz(1);
  switch (p) {
    case SDACTILAR_OK:
      Serial.println("Imagen Convertida");
      break;
    case SDACTILAR_IMGCONFUSA:
      Serial.println("Image muy confusa");
      return false; 
    case SDACTILAR_PAQUETE_IN_ERROR:
      Serial.println("Paquetes Errados");
      return false; 
    case SDACTILAR_RASGOSERROR:
      Serial.println("No es posible detectar los rasgos caracteriticos");
      return false; 
    case SDACTILAR_IMGINVALIDA:
      Serial.println("Imagen invalida");
      return false; 
    default:
      Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
      return false; 
  }
  delay(1000); 
//------------------------------------
  Serial.println("Remover Pulgar");
  delay(2000);
  p = -1;
  while (p != SDACTILAR_D_NO_DETECTADO) {
    p = MySensorDactilar.CapturarImagen();
  }
  p = -1;
  Serial.println("Por favor vuelva a poner nuevamente el Pulgar");
  delay(1000); 
  while (p != SDACTILAR_OK) {
    p = MySensorDactilar.CapturarImagen();
    switch (p) {
    case SDACTILAR_OK:
      Serial.println(" ");
      Serial.println("Imagen Tomada");
      break;
    case SDACTILAR_D_NO_DETECTADO:
      Serial.print(".");
      //Serial.println("No se encuentra al dedo");
      break;
    case SDACTILAR_PAQUETE_IN_ERROR:
      Serial.println("Error al recibir el paquete");
      break;
    case SDACTILAR_IMG_ERROR:
      Serial.println("Error al determinar la imagen");
      break;
    default:
      Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
      break;
    }
  }
  // OK success!
  p = -1;
  p = MySensorDactilar.GenerarImg2Tz(2);
  switch (p) {
    case SDACTILAR_OK:
      Serial.println("Imagen Convertida");
      break;
    case SDACTILAR_IMGCONFUSA:
      Serial.println("Image muy confusa");
      return false; 
    case SDACTILAR_PAQUETE_IN_ERROR:
      Serial.println("Paquetes Errados");
      return false; 
    case SDACTILAR_RASGOSERROR:
      Serial.println("No es posible detectar los rasgos caracteriticos");
      return false; 
    case SDACTILAR_IMGINVALIDA:
      Serial.println("Imagen invalida");
      return false; 
    default:
      Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);
      return false; 
  }
  delay(1000); 
  // OK converted!
  p = -1;
  p = MySensorDactilar.CrearModelo();
  if (p == SDACTILAR_OK) 
  {
    Serial.println("Muestras de Huellas Emparejadas!");delay(1000); 
  } else if (p == SDACTILAR_PAQUETE_IN_ERROR) {
    Serial.println("Error de comunicacion");delay(1000); 
    return false; 
  } else if (p == SDACTILAR_ENROLL_MISMATCH) {
    Serial.println("Muestras de Huellas NO Emparejadas!");delay(1000); 
    return false; 
  } else {
    Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);delay(1000); 
    return false; 
  }   

  Serial.print("ID "); Serial.println(id);
  p = MySensorDactilar.GuardarModelo(id);
  if (p == SDACTILAR_OK) {
    Serial.println("EXITO - Huella Guardada!");delay(1000); 
  } else if (p == SDACTILAR_PAQUETE_IN_ERROR) {
    Serial.println("Error de comunicacion");delay(1000); 
    return false; 
  } else if (p == SDACTILAR_ERROR_UBICACION) {
    Serial.println("No se puede ubicar en la ubicacion asignada");delay(1000); 
    return false; 
  } else if (p == SDACTILAR_ERROR_FLASH) {
    Serial.println("Error escribiendo en la flash");delay(1000); 
    return false; 
  } else {
    Serial.print("Error Desconocido: 0x"); Serial.println(p, HEX);delay(1000); 
    return false; 
  }   
  return false; 
}
