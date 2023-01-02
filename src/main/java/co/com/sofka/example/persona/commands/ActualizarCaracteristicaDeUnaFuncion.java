package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.FuncionId;
import co.com.sofka.example.persona.values.PersonaId;

public class ActualizarCaracteristicaDeUnaFuncion extends Command {

    /**
     * Se crean los atributos que se le pasan por parametro al comportamirnto
     * principalmente se tiene que pasar el identificador del agregado
     */
    private final PersonaId personaIdM;
    private final FuncionId funcionId;
    private final Caracteristica caracteristica;

    /**
     * Se crea el constructor
     */
    public ActualizarCaracteristicaDeUnaFuncion(PersonaId personaIdM, FuncionId funcionId, Caracteristica caracteristica) {
        this.personaIdM = personaIdM;
        this.funcionId = funcionId;
        this.caracteristica = caracteristica;
    }

    /**
     * Getter
     */

    public PersonaId getPersonaIdM() {
        return personaIdM;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
