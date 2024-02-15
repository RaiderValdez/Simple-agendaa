import java.util.Scanner;

public class Main {
    public static void agregarcontacto(){
        String contacto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un contacto a agregar ");
        contacto = sc.nextLine();

        if ( contacto.length() > 3 && contacto.length() < 9 ){

            System.out.println("Contacto agregado con exito");

        } else if (contacto.length() > 7 && contacto.length() < 31) {

            System.out.println("Agregado, contiene entre 8-30 caracteres");

        } else {

            System.out.println("Nombre muy largo");

        }


    }
    public static void removerContacto(int id){


        if (id >1000 && id <9999){

            System.out.println("Verificando contacto a eliminar...");

        } else{

           System.out.println("ID inválido");
        }

    }
    public static String actualizarcontacto(int A){
        return "N/A";}

    public static void mostrarContacto(){

        System.out.println("Mostrando contacto");

    }

    public static void main(String[] args) {

        agregarcontacto();
       // removerContacto();
        //mostrarContacto();


    }
}
