package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Nombre;

/**
 * Los eventos de dominio extienden de DomainEvent
 * en el constructor que implementa se le pasa el string con el
 * dominio en general luego el agregado y despues el tipo en especifico
 * Los eventos de dominio se escriben en pasado
 */
public class PersonaCreada extends DomainEvent {

    private final Nombre nombre;

    /**
     * Se le pasa el objeto de valor que va a transportar
     * @param nombre
     */
    public PersonaCreada(Nombre nombre) {
        super("sofka.persona.personacreada");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
