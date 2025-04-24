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

    public static String desencriptar (String contrasennaCifrada, String clave){
        try {
            SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key); // Modo desencriptación
            byte[] datosDecodificados = Base64.getDecoder().decode(contrasennaCifrada);
            byte[] datosDescifrados = cipher.doFinal(datosDecodificados);
            return new String(datosDescifrados);

        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException |
                 NoSuchPaddingException | NoSuchAlgorithmException e) {
            System.out.println("La clave que has introducido no coincide con la que se uso para la encriptacion");
        }
        return null;
    }
}