package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.values.CuentaId;

public class CuentaAsociada extends DomainEvent {
    private final CuentaId cuentaId;

    public CuentaAsociada(CuentaId cuentaId) {
        super("sofka.persona.cuentaasociada");
        this.cuentaId = cuentaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
