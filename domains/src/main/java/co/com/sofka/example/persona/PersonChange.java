package co.com.sofka.example.persona;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.example.persona.events.*;

import java.util.HashSet;

/**
 * event change -> Cambio de evento o estados
 * clase que hace es escucha para los eventos que accionan
 * se aplica cada evento de dominio del agregado
 * En esta parte se colocan las condiciones o reglas del dominio
 */
public class PersonChange extends EventChange {
    public PersonChange(Persona persona) {

        /* se aplica cada evento de dominio del agregado
        *  cuando la persona es creada que estado cambia
        */
        apply((PersonaCreada event) -> {
            persona.nombre = event.getNombre();
            persona.funciones = new HashSet<>();
        });

        apply((CuentaAsociada event) -> {
            persona.cuentaId = event.getCuentaId();
        });

        /*
        * Al cambiar el estado de una funcion como es un Set<funcion> funciones
        * se tiene que buscar la funcion a actualizar mediante el id
        */
        apply((DescripcionDeFuncionActualizada event ) -> {
            var funcion = persona.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("No se encuentra la funcion de la persona")
                    );
            funcion.actualizarDescripcion(event.getDescripcion());
        });

        apply((CaracteristicaDeFuncionActualizada event) -> {
            var funcion = persona.getFuncionPorId(event.getFuncionId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("No se encuentra la funcion de la persona")
                    );
            funcion.actualizarCaracteristica(event.getCaracteristica());
        });


        // Numero de funciones no puede ser mayor a  6 funciones a crear
        apply((FuncionAgregada event) -> {
            var numFunciones = persona.funciones().size();
            if ( numFunciones == 6){
                throw new IllegalArgumentException(
                        "No puedes agregar más funciones solo puedes tener hasta seis funciones"
                );
            }
            persona.funciones.add(new Funcion(
                    event.getEntityId(),
                    event.getCaracteristica(),
                    event.getDescripcion()
            ));
        });

        apply((NombreCambiado event) -> {
            persona.nombre = event.getNombre();
        });

    }
}
