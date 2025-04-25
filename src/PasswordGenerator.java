import java.util.Scanner;

public class PasswordGenerator {
    //Lo hace Jhon
    /*
    Aquí puedes añadir un metodo para generar contraseñas fuertes automáticamente
    Debera crear una contraseña en base a unos criterios dados por el usuario: Longitud, incluye x nª de mayus, incluye x nº de numeros, incluye x nº
    de caracteres especiales, la longitud que halla solicitado el usuario...
    */
    private static String pedirClaveMaestra(Scanner sc) {
        String clave = "";
        boolean confirmada = false;

        while (!confirmada) {
            do {
                System.out.print("Introduce una clave de 16 caracteres para encriptar tus contraseñas: ");
                clave = sc.nextLine();
            } while (clave.length() != 16);

            System.out.println("Has introducido la clave: " + clave);
            System.out.println("⚠️ Recuerda: debes usar siempre la misma clave para desencriptar.");

            String respuesta = "";
            while (!respuesta.equals("s") && !respuesta.equals("n")) {
                System.out.print("¿Estás seguro de usar esta clave? (S/N): ");
                respuesta = sc.nextLine().toLowerCase();
            }

            if (respuesta.equals("s")) {
                confirmada = true;
            }
        }

        return clave;
    }


}

