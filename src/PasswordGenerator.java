import java.util.Scanner;

public class PasswordGenerator {
    //Lo hace Jhon
    /*
    Aquí puedes añadir un metodo para generar contraseñas fuertes automáticamente
    Debera crear una contraseña en base a unos criterios dados por el usuario: Longitud, incluye x nª de mayus, incluye x nº de numeros, incluye x nº
    de caracteres especiales, la longitud que halla solicitado el usuario...
    */
    public static String pedirClaveMaestra(Scanner sc) {
        String clave = "";
        boolean confirmada = false;
    
        while (!confirmada) {
            System.out.print("Introduce una clave de 16 caracteres para encriptar tus contrase\u00D1as: ");
            clave = sc.nextLine();
    
            while (clave.length() != 16) {
                System.out.println("La clave debe tener exactamente 16 caracteres.");
                System.out.print("Vuelve a introducir la clave: ");
                clave = sc.nextLine();
            }
    
            System.out.println("Has introducido la clave: " + clave);
            System.out.println("Recuerda: debes usar siempre la misma clave para desencriptar.");
    
            String respuesta = "";
            System.out.print("¿Est\u00E1s seguro de usar esta clave? (S/N): ");
            respuesta = sc.nextLine().trim().toLowerCase();
    
            while (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.print("Respuesta no v\u00E1lida. Por favor, introduce S o N: ");
                respuesta = sc.nextLine().trim().toLowerCase();
            }
    
            if (respuesta.equals("s")) {
                confirmada = true;
            }
        }
    
        return clave;
    }
    


}

