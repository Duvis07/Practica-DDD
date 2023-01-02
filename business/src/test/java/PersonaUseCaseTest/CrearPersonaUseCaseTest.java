package PersonaUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.commands.CrearPersona;
import co.com.sofka.example.persona.events.PersonaCreada;
import co.com.sofka.example.persona.values.Nombre;
import co.com.sofka.example.persona.values.PersonaId;
import org.example.personaUseCase.CrearPersonaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearPersonaUseCaseTest {

    private CrearPersonaUseCase crearPersonaUseCase;

    @BeforeEach
    public void setup() {
        crearPersonaUseCase = new CrearPersonaUseCase();
    }

    @Test
    public void crearPersona() {

        var command = new CrearPersona(

                PersonaId.of("1"),
                new Nombre("Messi"));


        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(crearPersonaUseCase, new RequestCommand<>(command))
                .orElseThrow();
        List<DomainEvent> events = response.getDomainEvents();
        PersonaCreada personaCreada = (PersonaCreada) events.get(0);
        Assertions.assertEquals("Messi", personaCreada.getNombre().value());


    }


}
