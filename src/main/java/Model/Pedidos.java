package Model;

import javax.persistence.*;
import static java.lang.Math.floor;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Pedidos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo")
    private int codigo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nif_cliente", referencedColumnName = "nif")
    private Clientes nifCliente;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "codigo_articulo", referencedColumnName = "codigo")
    private Productos codigoArticulo;

    @Basic
    @Column(name = "cantidad")
    private int cantidad;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "procesado")
    private Byte procesado;

    public Pedidos() {};
    public Pedidos(int cantidad) {
        //this.codigo = null;
        //nifCliente = cliente;
        //codigoArticulo = producto;
        this.cantidad = cantidad;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Clientes getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
    }

    public Productos getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(Productos codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Byte getProcesado() {
        return procesado;
    }

    public void setProcesado(Byte procesado) {
        this.procesado = procesado;
    }

    public Clientes getCliente() {
        return nifCliente;
    }

    public void setCliente(Clientes cliente) {
        this.nifCliente = cliente;
    }

    public Productos getProducto() {
        return codigoArticulo;
    }

    public void setProducto(Productos producto) {
    }


    public double gastosEnvio() {
        double total;
        total = codigoArticulo.getGastosEnvio() * this.cantidad;
        if(nifCliente instanceof Premium) {
            total = 0;
        }
        return  total;
    }

    public double precioTotal() {
        double total;
        total = codigoArticulo.getPvp() * cantidad + gastosEnvio();
        if(nifCliente instanceof Premium) {
            total -= total *0.2;
        }
        floor(total);
        return total;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return codigo == pedidos.codigo && cantidad == pedidos.cantidad && Objects.equals(nifCliente, pedidos.nifCliente) && Objects.equals(codigoArticulo, pedidos.codigoArticulo) && Objects.equals(fecha, pedidos.fecha) && Objects.equals(procesado, pedidos.procesado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nifCliente, codigoArticulo, cantidad, fecha, procesado);
    }

    @Override
    public String toString() {
        return "Nº PEDIDO: " + this.codigo + "\n" +
                "CLIENTE " + nifCliente.getNombre() + "      NIF: " + nifCliente.getNif() + "\n" +
                "_______________________________________________________________________________________________"  + "\n" +
                "REF.: " + codigoArticulo.getCodigo() +
                "   |   DESCRIPCION: " + codigoArticulo.getNombre()  +"   |   CANTIDAD: " + this.cantidad +
                "   |   COSTE: " + codigoArticulo.getPvp() +"€" + "\n" +
                "_______________________________________________________________________________________________"  + "\n" +
                "COSTE ENVIO: " + gastosEnvio() +"€" + "\n" +
                "PRECIO TOTAL: " + precioTotal();
    }
}
