import java.security.SecureRandom;

public class PasswordGenerator {

    // Metodo para generar una clave maestra de 16 caracteres
    public static String generarClaveMaestra() {
        return generateRandomString(16);
    }

    // Mtodo para generar una contraseña normal con una longitud configurable
    public static String generarPass(int length) {
        return generateRandomString(length);  
    }

    // Metodo auxiliar para generar una cadena aleatoria
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String claveMaestra = generarClaveMaestra();
        String pass = generarPass(12);

        System.out.println("Clave maestra: " + claveMaestra);
        System.out.println("Contraseña normal: " + pass);
    }
}