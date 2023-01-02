package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Nombre;
import co.com.sofka.example.persona.values.PersonaId;

public class CrearPersona extends Command {

    private final PersonaId entityId;
    private final Nombre nombre;

    public CrearPersona(PersonaId entityId, Nombre nombre) {
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public PersonaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
