package co.com.sofka.example.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if (!this.value.contains("@")) {
            throw new IllegalArgumentException("El email debe tener un @");
        }

        if (!this.value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El email debe tener un formato valido");
        }
    }

    @Override
    public String value() {
        return value;
    }

    // Sobreescribir el metodo equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    // Sobreescribir el metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
