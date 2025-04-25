    import java.io.*;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) throws IOException {

            try {

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
                String clave = "";
                System.out.println("Tienes una clave registrada?");
                System.out.println("1. Si");
                System.out.println("2. No");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("Si")) {
                    clave = pedirClaveMaestra(sc,true);
                }else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("No")) {
                    clave = pedirClaveMaestra(sc,false);
                }



                // 3. Instanciar el gestor con la clave
                PasswordManager gestor = new PasswordManager(passwordFile, clave);

                //4. Salir
                boolean salir = false;
                while (!salir) {
                    mostrarMenu();

                    int opt = Integer.parseInt(sc.nextLine());
                    switch (opt) {
                        case 1:
                            gestor.annadirEntrada();
                            gestor.guardar();
                            break;
                        case 2:
                            gestor.mostrarContrasenna();
                            break;
                        case 3:
                            salir = true;
                            break;
                        default:
                            System.out.println("Introduce una opci\u00FAn válida (1-3)");
                        }


                }

                sc.close();
            }catch (Exception e) {
                System.err.println("Ha ocurrido un error: " + e.getMessage());
            }

        }

        private static String pedirClaveMaestra(Scanner sc, boolean tieneClave) {
            String clave = "";
            boolean confirmada = false;

            while (!confirmada) {
                System.out.print("Introduce una clave de 16 caracteres para encriptar tus contrase\u00F1as: ");
                clave = sc.nextLine();

                while (clave.length() != 16) {
                    System.out.println("La clave debe tener exactamente 16 caracteres.");
                    System.out.print("Vuelve a introducir la clave: ");
                    clave = sc.nextLine();
                }

                System.out.println("Has introducido la clave: " + clave);
                System.out.println("Recuerda: debes usar siempre la misma clave para desencriptar.");

                String respuesta = "";
                System.out.print("\u00BFEst\u00E1s seguro de usar esta clave? (S/N): ");
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
        private static void mostrarMenu() {
            System.out.println("\n--- MENU DE OPCIONES ---");
            System.out.println("1. A\u00F1adir contrase\u00F1a");
            System.out.println("2. Mostrar contrase\u00F1a");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
        }
    }
