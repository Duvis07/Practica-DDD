package CuentaUseCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.events.CuentaCreada;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.cuenta.values.Email;
import co.com.sofka.example.cuenta.values.Nombre;
import org.example.cuentaUseCase.CrearCuentaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearCuentaUseCaseTest {
    private CrearCuentaUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearCuentaUseCase();
    }

    @Test
    public void crearPersona() {

        var event = new CuentaCreada(
                new CuentaId("13"),
                new Nombre("Duvan"),
                new Email("Duvan@gmail.com"));


        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("13")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();
        List<DomainEvent> events = response.getDomainEvents();
        CuentaCreada cuentaCreada = (CuentaCreada) events.get(0);
        Assertions.assertEquals("Duvan", cuentaCreada.getNombre().value());


    }


}



