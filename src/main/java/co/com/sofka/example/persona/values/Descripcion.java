package co.com.sofka.example.persona.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
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
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    // Sobreescribir el metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
