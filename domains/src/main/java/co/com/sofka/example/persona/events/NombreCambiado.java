package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Nombre;

public class NombreCambiado extends DomainEvent {
    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("sofka.perosna.nombrecambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
