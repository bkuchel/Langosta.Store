package Controller;

import Model.Clientes;
import Services.ClienteService;
import Model.Estandar;
import Model.Premium;
import View.ClienteView;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    ClienteService bbdd = new ClienteService();
    ClienteView menuCliente = new ClienteView();

    Main volver = new Main();

    public void subMenu() {

        int opcion = menuCliente.mostrarMenu();

        switch (opcion) {
            case 1:
                nuevoEstandar();
                subMenu();
                break;
            case 2:
                nuevoPremium();
                subMenu();
                break;
            case 3:
                verClientes();
                subMenu();
            case 4:
                volver.inicio();
            default:
                System.out.println("*** OPCION NO DISPONIBLE ***\n");
                subMenu();

        }
    }

    public void nuevoEstandar() {
        Estandar estandar = new Estandar();

        List parametros = menuCliente.lecturaCliente();
        estandar.setNif(parametros.get(0).toString());
        estandar.setNombre(parametros.get(1).toString());
        estandar.setEmail(parametros.get(2).toString());
        estandar.setDomicilio(parametros.get(3).toString());
        bbdd.addCliente(estandar);
    }

    public void nuevoPremium() {
        Premium premium = new Premium();

        List parametros = menuCliente.lecturaCliente();
        premium.setNif(parametros.get(0).toString());
        premium.setNombre(parametros.get(1).toString());
        premium.setEmail(parametros.get(2).toString());
        premium.setDomicilio(parametros.get(3).toString());
        bbdd.addCliente(premium);
    }


    public void verClientes() {
        List<Clientes> datos = new ArrayList<Clientes>();
        datos = bbdd.getClientes();
        menuCliente.mostrarClientes(datos);
    }


}