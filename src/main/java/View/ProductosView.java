package View;

import Model.Productos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductosView {

    public int mostrarMenu() {
        System.out.println("MENU PRODUCTOS");
        System.out.println("___________________________");
        System.out.println("1 Agregar productos");
        System.out.println("2 Ver productos");
        System.out.println("3 Volver");

        int opcion = new Scanner(System.in).nextInt();

        return opcion;
    }

    public static List lecturaProducto() {

        List parametros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre producto:");
        String nombre = sc.nextLine();
        parametros.add(nombre);

        System.out.println("Precio de venta:");
        String precioVenta = sc.nextLine();
        parametros.add(precioVenta);

        System.out.println("Gastos de envio:");
        String gastosEnvio = sc.nextLine();
        parametros.add(gastosEnvio);

        System.out.println("Tiempo preparo:");
        String tiempoPrep = sc.nextLine();
        parametros.add(tiempoPrep);

        return (parametros);

    }

    public void mostrarProductos(List<Productos> productoLista) {
        System.out.println("PRODUCTOS");
        for (Productos producto : productoLista) {
                System.out.println(producto.toString());
                System.out.println("___________________________");
            }
        }
    }

