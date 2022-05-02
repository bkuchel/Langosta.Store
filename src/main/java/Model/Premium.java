package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Premium")
public class Premium extends Clientes{

    public Premium() {}
    public Premium (String nif, String nombre, String email, String domicilio) {
        super(nif, nombre, email, domicilio);
        super.setCuota(30);
        super.setDescuento(20);
    }



    public double descuentoEnvio(double totalPedido) {
        return totalPedido - (totalPedido * 0.2);
    }

    @Override
    public String toString(){
        return  "Tipo de cliente: Premium" + "\n" +
                "NIF: " + this.getNif() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Domicilio: " + this.getDomicilio() + "\n"+
                "Cuota: " + this.getCuota() + "\n" +
                "Descuento en el envio: " + this.getDescuento();

    }
}