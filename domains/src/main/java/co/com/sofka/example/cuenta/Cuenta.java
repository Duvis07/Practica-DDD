package co.com.sofka.example.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.events.CuentaCreada;
import co.com.sofka.example.cuenta.events.EmailCambiado;
import co.com.sofka.example.cuenta.events.NombreCambiado;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.cuenta.values.Email;
import co.com.sofka.example.cuenta.values.Nombre;

import java.util.List;
import java.util.Objects;

public class Cuenta extends AggregateEvent<CuentaId> {


    protected CuentaId cuentaId;

    protected Nombre nombre;
    protected Email email;

    public Cuenta(CuentaId entityId, Nombre nombre, Email email) {
        super(entityId);
        this.cuentaId = entityId;
        this.nombre = nombre;
        this.email = email;

        appendChange(new CuentaCreada(cuentaId,nombre,email)).apply();
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

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public void crearCuenta(CuentaId cuentaId, Nombre nombre, Email email) {
        Objects.requireNonNull(cuentaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        appendChange(new CuentaCreada(cuentaId, nombre, email)).apply();
    }
}
