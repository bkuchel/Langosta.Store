package View;
import java.util.Scanner;

/* Vista del menu principal de nuestra aplicacion
*  menuPrincipal() es una funcion que imprime las opciones en pantalla, escanea un numero y lo retorna
* Iniciando producto 3
* */

public class AppView {

    public int menuPrincipal() {
        int opcion = 0;
        System.out.println("BIENVENIDO A LANGOSTA.STORE");
        System.out.println(" ");
            System.out.println("MENU PRINCIPAL");
            System.out.println("___________________________");
            System.out.println("1 Gestionar clientes");
            System.out.println("2 Gestionar productos");
            System.out.println("3 Gestionar pedidos");
            System.out.println("4 Salir");

            opcion = new Scanner(System.in).nextInt();
            //Scanner.(System.in).nextLine();

            return opcion;


    }
}
