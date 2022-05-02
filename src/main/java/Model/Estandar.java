package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Estandar")

public class Estandar extends Clientes{
    public Estandar() {}
    public Estandar(String nif, String nombre, String email, String domicilio) {

        super(nif, nombre, email, domicilio);
        super.setCuota(0);
        super.setDescuento(0);
    }

    @Override
    public String toString(){
        return  "Tipo de cliente: Estandar" + "\n" +
                "NIF: " + this.getNif() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Domicilio: " + this.getDomicilio() + "\n";

    }
}
