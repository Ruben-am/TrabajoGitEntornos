
    // IMPORTANTE leer intrucciones antes de hacer
    //Lo hace Jhon
    /*
    Pide la clave maestra al usuario (Clave para encriptar tiene que ser si o si de 16 caracteres)
    Muestra un menú en consola (tipo while + switch)
    Llama a métodos de PasswordManager según lo que elija el usuario
    */
    import javax.crypto.*;
    import java.io.*;
    import java.security.*;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) throws IOException {
            // 1. Crear carpeta "data" si no existe
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }

            // 2. Crear el fichero si no existe
            File passwordFile = new File(dataDir, "password.txt");
            if (!passwordFile.exists()) {
                passwordFile.createNewFile();
            }

            Scanner sc = new Scanner(System.in);
            String clave = PasswordGenerator.pedirClaveMaestra(sc);

            // 3. Instanciar el gestor con la clave
            PasswordManager gestor = new PasswordManager(passwordFile, clave);


        }
    }

