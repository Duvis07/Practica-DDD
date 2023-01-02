package co.com.sofka.example.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.FuncionId;

public class CaracteristicaDeFuncionActualizada extends DomainEvent {
    private final FuncionId funcionId;
    private final Caracteristica caracteristica;

    public CaracteristicaDeFuncionActualizada(FuncionId funcionId, Caracteristica caracteristica) {
        super("sofka.persona.caracteristicadefuncionactualizada");
        this.funcionId = funcionId;
        this.caracteristica = caracteristica;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
