package Model;

import javax.persistence.*;
import java.util.Objects;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Clientes {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nif")
    private String nif;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "domicilio")
    private String domicilio;
    @Basic
    @Column(name = "cuota")
    private Integer cuota;
    @Basic
    @Column(name = "descuento")
    private Integer descuento;

    public Clientes() { }

    public Clientes(String nif, String nombre, String email, String domicilio) {
        this.nif = nif;
        this.nombre = nombre;
        this.email = email;
        this.domicilio = domicilio;
    }


    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(nif, clientes.nif) && Objects.equals(nombre, clientes.nombre) && Objects.equals(email, clientes.email) && Objects.equals(domicilio, clientes.domicilio) && Objects.equals(cuota, clientes.cuota) && Objects.equals(descuento, clientes.descuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nombre, email, domicilio, cuota, descuento);
    }

}


