package org.example.cuentaUseCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.example.cuenta.Cuenta;
import co.com.sofka.example.cuenta.events.CuentaCreada;

public class CrearCuentaUseCase extends UseCase<TriggeredEvent<CuentaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CuentaCreada> cuentaCreadaTriggeredEvent) {
        var event = cuentaCreadaTriggeredEvent.getDomainEvent();

        var cuenta = new Cuenta(
                event.getIdCuenta(),
                event.getNombre(),
                event.getEmail()
        );

        cuenta.crearCuenta(event.getIdCuenta(),event.getNombre(),event.getEmail());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
