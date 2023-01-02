package co.com.sofka.example.persona.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Implementamos de value object ya que es un objeto de valor
 */
public class Nombre implements ValueObject<String> {

    public final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (this.value.length() <= 2) {
            throw new IllegalArgumentException("El nombre debe tener mas de 2 caracteres");
        }

        if (this.value.length() >= 100) {
            throw new IllegalArgumentException("El nombre debe tener menos de 100 caracteres");
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
        Nombre nombre = (Nombre) o;
        return Objects.equals(value, nombre.value);
    }

    // Sobreescribir el metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
