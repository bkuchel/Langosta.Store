package Controller;


import Model.Productos;
import Services.ProductoService;
import View.ProductosView;
import java.util.List;

public class ProductosController {
    ProductoService bbdd = new ProductoService();
    ProductosView menuProducto = new ProductosView();

    public void subMenu() {

        int opcion = menuProducto.mostrarMenu();

        switch (opcion) {
            case 1:
                nuevoProducto();
                subMenu();
                break;
            case 2:
                verProductos();
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

        public void nuevoProducto() {
        Productos producto = new Productos();

            List parametros = menuProducto.lecturaProducto();
            producto.setNombre(parametros.get(0).toString());
            producto.setPvp(Float.parseFloat(parametros.get(1).toString()));
            producto.setGastosEnvio(Float.parseFloat(parametros.get(2).toString()));
            producto.setTiempoPreparacion(Integer.parseInt(parametros.get(3).toString()));
            bbdd.addProducto(producto);
        }


        public void verProductos() {
            List<Productos> datos = bbdd.getProductos();
            menuProducto.mostrarProductos(datos);
        }


}
