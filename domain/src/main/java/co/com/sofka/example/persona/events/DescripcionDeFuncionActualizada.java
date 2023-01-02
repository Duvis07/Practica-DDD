package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;

public class DescripcionDeFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Descripcion descripcion;

    public DescripcionDeFuncionActualizada(FuncionId funcionId, Descripcion descripcion) {
        super("sofka.persona.descripciondefuncionactualizada");
        this.funcionId = funcionId;
        this.descripcion = descripcion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
