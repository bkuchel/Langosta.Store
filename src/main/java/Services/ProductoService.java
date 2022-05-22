package Services;

import Model.Clientes;
import Model.Productos;
import javax.persistence.*;
import java.util.List;

public class ProductoService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Langosta.Store");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public List<Productos> getProductos() {
        List<Productos> list;
        try {
            transaction.begin();
            Query listarProductos = entityManager.createQuery("SELECT c FROM Productos c");
            list = listarProductos.getResultList();
            return list;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    public boolean addProducto(Productos producto) {
        try {
            transaction.begin();
            entityManager.persist(producto);
            transaction.commit();
            return true;
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
