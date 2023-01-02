package co.com.sofka.example.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.persona.values.Caracteristica;
import co.com.sofka.example.persona.values.Descripcion;
import co.com.sofka.example.persona.values.FuncionId;
import co.com.sofka.example.persona.values.PersonaId;

/**
 * comando para el comportamiento agregarFuncion del agregado persona
 * Cada uno de los comportamientos de un agregado que acciona un evento por cambio
 * se vuele un comando
 */
public class AgregarFuncion extends Command {

    /**
     * Se crean los atributos que se le pasan por parametro al comportamirnto
     * principalmente se tiene que pasar el identificador del agregado
     */
    private final PersonaId personaId;
    private final FuncionId entityId;
    private final Caracteristica caracteristica;
    private final Descripcion descripcion;

    public AgregarFuncion(PersonaId personaId, FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion) {
        this.personaId = personaId;
        this.entityId = entityId;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public PersonaId getPersonaId() {
        return personaId;
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
