package Services;

import Model.Clientes;
import Model.Pedidos;
import Model.Productos;

import javax.persistence.*;
import java.util.List;

public class PedidoService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Langosta.Store");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public List<Pedidos> getPedidos() {
        List<Pedidos> list;
        try {
            transaction.begin();
            Query listarPedidos = entityManager.createQuery("SELECT c FROM Pedidos c");
            list = listarPedidos.getResultList();
            return list;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    public Clientes getClientebyId(String nif) {
        Clientes cliente;

        try {
            transaction.begin();
            Query buscarCliente = entityManager.createQuery("SELECT c FROM Clientes c WHERE c.nif = :nif");
            cliente = (Clientes) buscarCliente.getSingleResult();
            return cliente;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }


    }

    public boolean addPedido(Pedidos pedido) {

        /*ClienteService datoCliente = new ClienteService();
        ProductoService datoProducto = new ProductoService();
        Clientes cliente = datoCliente.getClienteById((String)parametros.get(0));
        Productos producto = datoProducto.getProductoById((String) parametros.get(0));

        pedido.setNifCliente(cliente);
        pedido.setProducto(producto);
        pedido.setCantidad((Integer) parametros.get(2));*/

        try {
            transaction.begin();
            entityManager.persist(pedido);
            //System.out.println(pedido);
            transaction.commit();
            return true;
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
