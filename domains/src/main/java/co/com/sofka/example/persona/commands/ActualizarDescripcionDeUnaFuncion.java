package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;
import co.com.sofka.example.persona.values.PersonaId;

public class ActualizarDescripcionDeUnaFuncion extends Command {

    private final PersonaId personaId;
    private final FuncionId funcionId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeUnaFuncion(PersonaId personaId, FuncionId funcionId, Descripcion descripcion) {
        this.personaId = personaId;
        this.funcionId = funcionId;
        this.descripcion = descripcion;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
