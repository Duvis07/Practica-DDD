package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Nombre;
import co.com.sofka.example.persona.values.PersonaId;

public class CambiarNombre extends Command {

    private final PersonaId personaId;
    private final Nombre nombre;

    public CambiarNombre(PersonaId personaId, Nombre nombre) {
        this.personaId = personaId;
        this.nombre = nombre;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
