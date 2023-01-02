package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.persona.values.PersonaId;

public class AsociarCuenta extends Command {

    private final PersonaId personaId;
    private final CuentaId cuentaId;

    public AsociarCuenta(PersonaId personaId, CuentaId cuentaId) {
        this.personaId = personaId;
        this.cuentaId = cuentaId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
