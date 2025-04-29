# Password Manager

Este proyecto es una **aplicación de consola en Java** que permite **gestionar contraseñas** de manera segura, **encriptándolas** antes de almacenarlas en un archivo `.txt`.  

## Estructura de Directorios

```
TRABAJOGITENTORNOS/
├── .idea/
├── data/
│   └── password.txt
└── src/
    ├── Main.java
    ├── PasswordManager.java
    ├── PasswordGenerator.java
    ├── EncryptionUtils.java
    └── PasswordEntry.java
```

## Descripción de Archivos

- **Main.java**:  
    Contiene el **menú interactivo** que permite al usuario navegar entre opciones como añadir contraseñas, ver contraseñas guardadas, generar nuevas contraseñas, etc.  
    También incluye dos métodos:
    
    - Mostrar el menú.
    - Pedir la clave maestra.
    
- **PasswordManager.java**:  
    Gestiona la lógica de:
    
    - Añadir nuevas contraseñas para servicios (pidiendo nombre del servicio y contraseña).
    - Llamar a métodos de **encriptación** y **desencriptación**.
    - Guardar los datos en el archivo `password.txt`.
    - Mostrar contraseñas desencriptadas.
    
- **PasswordGenerator.java**:  
    Tiene dos métodos:
    
    - Generar una **clave maestra** obligatoriamente de **16 caracteres**.
    - Generar **contraseñas aleatorias** de la longitud que especifique el usuario (útil para crear contraseñas fuertes para servicios).
    
- **EncryptionUtils.java**:  
    Maneja la **encriptación** y **desencriptación** de contraseñas usando:
    
    - **AES** (Advanced Encryption Standard).
    - **Base64** para la codificación de los datos cifrados.
    
- **PasswordEntry.java**:  
    Modelo que representa una entrada de contraseña (servicio y contraseña asociada).  
    Guarda los datos en un **ArrayList**, utilizando **getter** y **setter**.
    

## Funcionamiento Básico

1. El usuario introduce una **clave maestra** válida (16 caracteres).
    
2. Puede añadir contraseñas para distintos servicios.
    
3. Las contraseñas se **encriptan** antes de guardarse en el archivo `password.txt`.
    
4. También puede **visualizar** las contraseñas desencriptadas si lo desea.
    
5. Opcionalmente, puede generar contraseñas aleatorias seguras para los servicios.
    

## Tecnologías usadas

- **Java SE**
    
- **Criptografía AES**
    
- **Base64 Encoding**
    
- **Manejo de archivos (I/O)**
    
- **ArrayList** para almacenamiento temporal de datos.
    

## Notas

- El archivo `data/password.txt` actúa como base de datos local (No se sube al repositorio).
    
- Todas las contraseñas guardadas están encriptadas para proteger la información sensible.
    
- La seguridad de los datos depende en gran parte de la **fortaleza de la clave maestra**.
    
- Es importante recordar la clave maestra, ya que sin ella **no se podrán desencriptar las contraseñas**.
