package Services;

import Model.Clientes;
import Model.Premium;

import javax.persistence.*;
import java.util.List;

public class ClienteService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Langosta.Store");
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public List<Clientes> getClientes() {
        List<Clientes> list;
        try {
            transaction.begin();
            Query listarClientes = entityManager.createQuery("SELECT c FROM Clientes c");
            list = listarClientes.getResultList();
            return list;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }

    }

    public Clientes getClienteById(String nif) {
        transaction.begin();
        Clientes cliente = entityManager.createQuery("SELECT c FROM Clientes c WHERE c.nif = :nif", Clientes.class).setParameter("nif", nif).getSingleResult();
        transaction.commit();
        return cliente;
    }

    public boolean addCliente(Clientes cliente) {
        try {
            transaction.begin();
            if(cliente instanceof Premium) {
                cliente.setCuota(30);
                cliente.setDescuento(20);
            } else {
                cliente.setCuota(0);
                cliente.setDescuento(0);
            }
            entityManager.persist(cliente);
            transaction.commit();
            return true;
        }finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }


}
