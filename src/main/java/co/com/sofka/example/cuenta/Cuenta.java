package co.com.sofka.example.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.events.EmailCambiado;
import co.com.sofka.example.cuenta.events.CuentaCreada;
import co.com.sofka.example.cuenta.events.NombreCambiado;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.cuenta.values.Email;
import co.com.sofka.example.cuenta.values.Nombre;

import java.util.List;

public class Cuenta extends AggregateEvent<CuentaId> {
    protected Nombre nombre;
    protected Email email;

    public Cuenta(CuentaId entityId, Nombre nombre, Email email) {
        super(entityId);
        this.nombre = nombre;
        appendChange(new CuentaCreada(nombre, email)).apply();
    }

    private Cuenta(CuentaId entityId) {
        super(entityId);
        subscribe(new CuentaChange(this));
    }

    public static Cuenta from(CuentaId entityId, List<DomainEvent> events) {
        var cuenta = new Cuenta(entityId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    /**
     * Comportamientos
     */

    public void cambiarCorreo(Email email) {
        appendChange(new EmailCambiado(email)).apply();
        ;
    }

    public void cambiarNombre(Nombre nombre) {
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }
}
