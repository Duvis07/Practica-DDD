package co.com.sofka.example.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.values.Nombre;

public class NombreCambiado extends DomainEvent {
    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("sofka.cuenta.nombrecambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
