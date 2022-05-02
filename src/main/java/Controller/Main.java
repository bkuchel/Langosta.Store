package Controller;
import View.AppView;

/*
 *   OnlineStore es la clase principal de nuestra aplicacion y contiene el main()
 *   Instanciamos la clase OnlineStore asignandola a la variable app
 *   Llamamos la funcion inicio()
 */

public class Main {
    public static void main(String[] args)  {

        Main app = new Main();
        app.inicio();

    }

    /*
     *   La funcion inicio() instancia la vista del menu principal que retorna un numero de opcion
     *   Segun la opcion seleccionada, instancia el controlador correspondiente y llama la funcion menu() que se encarga de exibir el submenu
     */

    public void inicio() {

        AppView interfaz = new AppView();

        int opcion = interfaz.menuPrincipal();
        switch (opcion) {
            case 1:
                ClienteController cliente = new ClienteController();
                cliente.subMenu();
                break;
            case 2:
                ProductosController productos = new ProductosController();
                productos.subMenu();
            case 3:
                PedidosController pedidos = new PedidosController();
                pedidos.subMenu();
                break;
            case 4:
                System.out.println("*** ¡HASTA LA PROXIMA!***\n");
                System.exit(0);
            default:
                System.out.println("*** OPCION NO DISPONIBLE ***\n");
                inicio();
        }

    }

}
