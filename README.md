# AREP-AplicacionSegura

A continuación se presenta el desarrollo de una aplicación web segura que:
  - Permitir el acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
  - Debe tener al menos dos computadores comunicandose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado. 
  
## Prerequisitos
Tener instalado:
  - Java 1.8 
  - Apache Maven 
 
## Ejecución 
  - Para compilar y descargar dependencias ejecutar: mvn package
  - Para compilar la clase donde tenemos el Main: mvn exec:java -Dexec.mainClass="arep.SecureServer"
 
## Desarrollo

1. Creamos el certificado al que llamaremos tallerkeystore y a continuación respondemos cada una de las preguntas:

  ![Captura](https://user-images.githubusercontent.com/48154086/79678663-6d43ff00-81c3-11ea-997c-8ef58ac48529.PNG)
  
2. Ejecutamos el proyecto con el comando mvn package y luego  mvn exec:java -Dexec.mainClass="arep.SecureServer" como se muestra a continuación:

  ![Captura1](https://user-images.githubusercontent.com/48154086/79678664-6e752c00-81c3-11ea-98c6-1584ca6d76bd.PNG)
  
3. Abrimos el navegador y digitamos https://localhost:5678 y nos muestra el siguiente mensaje:

  ![Captura2](https://user-images.githubusercontent.com/48154086/79678666-70d78600-81c3-11ea-91ce-558d48d65528.PNG)
  
4. Seleccionamos la opción de "ocultar configuración avanzada"

  ![Captura3](https://user-images.githubusercontent.com/48154086/79678668-7208b300-81c3-11ea-80dd-c5db50839058.PNG)
  
5. Cambiamos la url agregandole el siguiente parámetro https://localhost:5678/hello y nos aparecerá el mensaje que seleccionamos en el código en este caso Hello World.

  ![Captura4](https://user-images.githubusercontent.com/48154086/79678669-73d27680-81c3-11ea-9177-87b259a047b8.PNG)
  
 
 ``` java
            public class SecureServer {
              public static void main(String[] args) {
                  port(getPort());
                  //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath ,truststorePassword);
                  secure("keys/tallerkeystore.p12", "arep1234", null, null);
                  get("/hello", (req, res) -> "Hello World");
              }

              static int getPort() {
                    if (System.getenv("PORT") != null) {
                        return Integer.parseInt(System.getenv("PORT"));
                    }
                    return 5678;
                }


          }

```

6. Entramos en el ícono de No es segura en rojo y damos click a la opción de Certificado. 

![Captura7](https://user-images.githubusercontent.com/48154086/79679041-e6455580-81c7-11ea-9ae3-79bcbb34aaca.PNG)

7. A continuación entramos a ver la información del certificado que se generó. 

![Captura5 0](https://user-images.githubusercontent.com/48154086/79678670-759c3a00-81c3-11ea-8104-2b065a171bc7.PNG)

![Captura5](https://user-images.githubusercontent.com/48154086/79678671-76cd6700-81c3-11ea-8c1c-c8677db0f8b1.PNG)

  

