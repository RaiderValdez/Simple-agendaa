import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void agregarContacto(String[] contactos) {
        String contacto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un contacto a agregar ");
        contacto = sc.nextLine();

        boolean existe = false;
        for (String c : contactos) {
            if (c != null && c.equals(contacto)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("Ya se ha agregado anteriormente");
        } else {
            contactos[contactos.length - 1] = contacto;
            System.out.println("Agregado satisfactoriamente");
        }
    }

    public static void removerContacto(String[] contactos) {
        String contacto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el contacto a eliminar ");
        contacto = sc.nextLine();

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(contacto)) {
                contactos[i] = null;
                System.out.println("El contacto " + contacto + " fue removido exitosamente!");
                return;
            }
        }

        System.out.println("No existe tal contacto");
    }

    public static void mostrarContacto(String[] contactos) {
        String contacto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el contacto a mostrar ");
        contacto = sc.nextLine();

        boolean existe = false;
        for (String c : contactos) {
            if (c != null && c.equals(contacto)) {
                System.out.println("El contacto " + contacto);
                existe = true;
                break;
            }
        }

        if (!existe) {
            System.out.println("No existen registros de este contacto");
        }
    }

    public static void mostrarContactos(String[] contactos) {
        System.out.println("Mostrando contactos…");

        for (String contacto : contactos) {
            if (contacto != null) {
                System.out.println(contacto);
            }
        }
    }

    public static void main(String[] args) {
        String[] contactos = new String[10];
        generarArchivo(contactos);
        mostrarContacto("Adan");
        mostrarContactos();
    }

    public static void generarArchivo(String[] contactos) {
        try {
            File archivo1 = new File("contactos.txt");
            archivo1.createNewFile();
            FileWriter escritor = new FileWriter(archivo1);
            escritor.write("contacto,telefono\n" +
                    "Adan,8098551212\n" +
                    "Enmanuel,8294118787\n" +
                    "Raider,8097410032\n" +
                    "Roger,8095554141\n");
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarContacto(String nombre) {
        try {
            File archivo = new File("contactos.txt");
            Scanner lector = new Scanner(archivo);
            lector.nextLine();
            boolean encontrado = false;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    System.out.println("El contacto " + nombre + " existe.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No existen registros de este contacto.");
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos...");
        try {
            File archivo = new File("contactos.txt");
            Scanner lector = new Scanner(archivo);
            lector.nextLine();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0] + ", Teléfono: " + partes[1]);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
