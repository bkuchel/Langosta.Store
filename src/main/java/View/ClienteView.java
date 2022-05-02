package View;

import Model.Clientes;
import Model.Estandar;
import Model.Premium;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteView {

    public int mostrarMenu() {
        int opcion;
        System.out.println("MENU CLIENTES");
        System.out.println("___________________________");
        System.out.println("1 Agregar cliente estandar");
        System.out.println("2 Agregar cliente premium");
        System.out.println("3 Ver clientes");
        System.out.println("4 Volver");

        opcion = new Scanner(System.in).nextInt();

        return opcion;

    }

    public static List lecturaCliente() {

        List parametros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("NIF:");
        String nif = sc.nextLine();
        parametros.add(nif);

        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        parametros.add(nombre);

        System.out.println("e-mail:");
        String email = sc.nextLine();
        parametros.add(email);

        System.out.println("Domicilio:");
        String domicilio = sc.nextLine();
        parametros.add(domicilio);

        return (parametros);

    }

    public void mostrarClientes(List<Clientes> clienteLista) {
        System.out.println("CLIENTES");
        for (Clientes clientes : clienteLista) {
            if (clientes instanceof Estandar) {
                System.out.println(clientes.toString());
                System.out.println("___________________________");
            } else if(clientes instanceof Premium) {
                System.out.println(clientes.toString());
                System.out.println("___________________________");
            }
        }
    }
}
