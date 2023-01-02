package org.example.personaUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.example.persona.Persona;
import co.com.sofka.example.persona.commands.CrearPersona;

public class CrearPersonaUseCase extends UseCase<RequestCommand<CrearPersona>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPersona> crearPersonaRequestCommand) {
        var command = crearPersonaRequestCommand.getCommand();
        var persona = new Persona(command.getEntityId(), command.getNombre());
        emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));
    }
}

