package Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo")
    private int codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "pvp")
    private float pvp;
    @Basic
    @Column(name = "gastos_envio")
    private float gastosEnvio;
    @Basic
    @Column(name = "tiempo_preparacion")
    private int tiempoPreparacion;

    public Productos() { }

    public Productos(int codigo, String nombre, float pvp, float gastosEnvio, int tiempoPreparacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pvp = pvp;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public float getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return codigo == productos.codigo && tiempoPreparacion == productos.tiempoPreparacion && Objects.equals(nombre, productos.nombre) && Objects.equals(pvp, productos.pvp) && Objects.equals(gastosEnvio, productos.gastosEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, pvp, gastosEnvio, tiempoPreparacion);
    }

    @Override
    public String toString(){
        return  "Codigo producto: " + this.getCodigo() + "\n" +
                "Nombre producto: " + this.getNombre() + "\n" +
                "Precio venta: " + this.getPvp() + "\n" +
                "Gastos envio:  " + this.getGastosEnvio() + "\n" +
                "Tiempo preparo:  " + this.getTiempoPreparacion() + "\n";

    }
}
