package co.com.sofka.example.cuenta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.values.Email;

public class CorreoCambiado extends DomainEvent {
    private final Email email;

    public CorreoCambiado(Email email) {
        super("sofka.cuenta.correocambiado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
