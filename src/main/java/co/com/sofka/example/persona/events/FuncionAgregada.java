package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;

public class FuncionAgregada extends DomainEvent {
    private final FuncionId entityId;
    private final Caracteristica caracteristica;
    private final Descripcion descripcion;

    public FuncionAgregada(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion) {
        super("sofka.persona.funcionagregada");
        this.entityId = entityId;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public FuncionId getEntityId() {
        return entityId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
