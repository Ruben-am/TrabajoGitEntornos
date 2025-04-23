import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    public static String encriptar (String contrasenna, String clave) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key); // Modo encriptación
        byte[] datosCifrados = cipher.doFinal(contrasenna.getBytes());
        return Base64.getEncoder().encodeToString(datosCifrados);
    }

}

//Lo hace Ruben
    /*
    Aquí va toda la lógica de cifrado AES y descifrado.
    Se le pasa el texto y la clave, y devuelve texto cifrado (y viceversa).
    */