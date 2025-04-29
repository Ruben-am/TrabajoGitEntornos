import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {
    private final File archivo;
    private final String clave;
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<PasswordEntry> datos = new ArrayList<>();

    public PasswordManager(File archivo, String clave) {
        this.archivo = archivo;
        this.clave = clave;
    }

    //Metodo para pedir al usuario los datos del servicio + la contraseña en texto plano
    //Encripta la contraseña y guarda el servicio + contraseña en un objeto de la clase PasswordEntry
    //Guarda el objeto en un array list de objetos(PasswordEntry)
    public void annadirEntrada() throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int opt = 0;
        String contrasenna = "";
        System.out.println("Nombre del servicio:");
        String nomServicio = sc.nextLine().toLowerCase();
        while (opt != 1 && opt != 2) {
            System.out.println("1. Introducir contraseña manualmente");
            System.out.println("2. Generar contraseña aleatoria");
            System.out.println("Que accion quieres realizar");
            try {
                opt = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR, Introduce un numero");
            }
            switch (opt) {
                case 1:
                    System.out.println("Introduce la contraseña que quieres registrar en " + nomServicio + ": ");
                    contrasenna = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Cuantos caracteres quieres que tenga la clave");
                    int numCaracteres = sc.nextInt();
                    contrasenna = PasswordGenerator.generarPass(numCaracteres);
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
        }
        String conEncryp = Encryption.encriptar(contrasenna, clave);
        datos.add(new PasswordEntry(nomServicio, conEncryp));
    }

    //Guarda el arraylist de datos en el fichero
    public void guardar() throws IOException {
        if (archivo.exists()) {
            for (int i = 0; i < datos.size(); i++) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                    writer.write("<" + datos.get(i).getServicio() + "> : " + datos.get(i).getContrasennaEncriptada() + "#saltoLinea#");
                    writer.newLine();
                } catch (Exception e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                }
            }
            datos.clear();
        } else {
            System.out.println("No es posible guardar la contraseña porque el archivo no existe");
        }
    }

    public void mostrarContrasenna() throws IOException {
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                System.out.println("¿De qué servicio quieres saber la contraseña?");
                String servicioBuscado = sc.nextLine().toLowerCase();

                String linea;
                boolean encontrado = false;

                while ((linea = reader.readLine()) != null) {
                    // Separar por el patrón "<servicio> : contraseña#saltoLinea#"
                    if (linea.contains("> : ")) {
                        int inicio = linea.indexOf('<') + 1;
                        int fin = linea.indexOf('>');
                        String servicio = linea.substring(inicio, fin).toLowerCase(); // nombre del servicio
                        String contrasennaEncriptada = linea.substring(linea.indexOf(":") + 2).replace("#saltoLinea#", "");

                        if (servicio.equals(servicioBuscado)) {
                            try {
                                String desencriptada = Encryption.desencriptar(contrasennaEncriptada, clave);
                                System.out.println("Contraseña de " + servicio + ": " + desencriptada);
                            } catch (Exception e) {
                                System.out.println("No se pudo desencriptar la contraseña: " + e.getMessage());
                            }
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    System.out.println("Servicio no encontrado.");
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No es posible mostrar la contraseña porque el archivo no existe");
        }
    }
}
