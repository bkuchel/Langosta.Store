package Controller;

import Model.Clientes;
import Model.Pedidos;
import Model.Productos;
import Services.PedidoService;
import View.PedidosView;

import java.util.List;

public class PedidosController {
    PedidoService bbdd = new PedidoService();
    PedidosView menuPedido = new PedidosView();

    public void subMenu() {
        PedidosView menuPedidos = new PedidosView();
        int opcion = menuPedidos.mostrarMenu();

        switch (opcion) {
            case 1:
                nuevoPedido();
                subMenu();
                break;
            case 2:
                verPedidos();
                subMenu();
                break;
            case 3:
                Main volver = new Main();
                volver.inicio();
            default:
                System.out.println("*** OPCION NO DISPONIBLE ***\n");
                subMenu();

        }
    }

    public void nuevoPedido() {
        Pedidos pedido = new Pedidos();
        Clientes cliente = new Clientes();
        Productos producto = new Productos();



        List parametros = menuPedido.lecturaPedido();
        cliente.setNif(parametros.get(0).toString());
        producto.setCodigo((Integer) parametros.get(1));


        pedido.setCliente(cliente);
        pedido.setCodigoArticulo(producto);
        pedido.setCantidad(Integer.parseInt((String) parametros.get(2)));
        //pedido.setNifCliente();
        bbdd.addPedido(pedido);
        }

    public void verPedidos() {
        List<Pedidos> datos = bbdd.getPedidos();
        menuPedido.mostrarPedidos(datos);
    }

    }

