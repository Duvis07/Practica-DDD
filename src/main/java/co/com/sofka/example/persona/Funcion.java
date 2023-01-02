package co.com.sofka.example.persona;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;

import java.util.Objects;

/**
 * Las entidades no manejan eventos
 */
public class Funcion extends Entity<FuncionId> {
    private Caracteristica caracteristica;
    private Descripcion descripcion;

    public Funcion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion) {
        super(entityId);
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    /**
     * Comportamientos de la entidad Funcion
     */

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void actualizarCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = Objects.requireNonNull(caracteristica);
    }

    /**
     * Getters de los atributos de la entidad Funcion
     */
    public Caracteristica caracteristica() {
        return caracteristica;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
