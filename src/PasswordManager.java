import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<PasswordEntry> datos = new ArrayList<>();

    //Metodo para pedir al usuario los datos del servicio + la contraseña en texto plano
    //Encripta la contraseña y guarda el servicio + contraseña en un objeto de la clase PasswordEntry
    //Guarda el objeto en un array list de objetos(PasswordEntry)
    public static void annadirEntrada (String clave) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println("Nombre del servicio:");
        String nomServicio = sc.nextLine();
        System.out.println("Introduce la contraseña que quieres registrar en " + nomServicio + ": ");
        String contrasenna = sc.nextLine();
        String conEncryp = Encryption.encriptar(contrasenna, clave);
        datos.add(new PasswordEntry(nomServicio, conEncryp));
    }


    //Lo hace Ruben
    /*
    Añadir nueva contraseña (manual o generada).
    Buscar contraseña por servicio.
    Guardar y leer datos del archivo.
    Usa EncryptionUtils

    --
    añadirEntrada() → Añadir una nueva contraseña
    mostrarContraseña() → Buscar por nombre de servicio y mostrarla desencriptada
    guardar() / cargar() → Guarda y lee desde fichero
    Usa EncryptionUtils para cifrar/descifrar
    Crea objetos PasswordEntry para guardar la info
    --
    */
}
