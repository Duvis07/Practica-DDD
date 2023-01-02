package co.com.sofka.example.persona;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.persona.events.*;
import co.com.sofka.example.persona.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * como es una entidad y es el agregado root extiende de AggregateEvent
 * pasandole su identificacion unica
 * los agregados no retornan nada desde los comportamientos que maneje
 */
public class Persona extends AggregateEvent<PersonaId> {

    protected Nombre nombre;
    protected Set<Funcion> funciones;
    protected CuentaId cuentaId;

    /**
     * Constructor con los parametros que se necesitan al crear el agregado persona
     * lo primero que se implementa
     */
    public Persona(PersonaId entityId, Nombre nombre) {
        super(entityId);
        /* Cuando un caso de uso utilice es agregado al crearlo la consecuencia
           seria lanzar este evento
           Se le dice al agregado que lance un evento de personacreada y que
           se aplica en este contexto
        */
        appendChange(new PersonaCreada(nombre)).apply();
    }

    /**
     * Para afectar los estados se debe implementar un constructor privado
     * solamente con el identificado pasado por parametro
     * se implementa de ultimo
     */
    private Persona(PersonaId entityId) {
        super(entityId);
         /* Aca se suscribe a los eventos, para estar pendiente a cada evento
            y poder cambiar el estado
         */
        subscribe(new PersonChange(this)); // this es la clase
    }

    /**
     * Que pasa si ya se tiene el agregado creado
     * este metodo constructor ayuda a construir la persona como tal
     * se le pasa como parametro la personaId y una lista de domaintEvent
     * que es una factoria que permite construir la persona
     * List<DomainEvent> events -> lo que hace es recrear todos los agregados
     * apartir de unos eventos que ya se tienen guardados
     * <p>
     * ESTA ES LA FORMA DE OBTENER UN AGREGADO QUE YA FUE GUARDADO (PERSISTIDO)
     * es la factoria que me ayuda a reconstruir el agregado sin tener que pasarle todos los
     * argumentos, von esto se puede recrear el agregado en una historia en particular dependiendo
     * de la lista de eventos de dominiio que hayan sido persistidos
     */
    public static Persona from(PersonaId personaId, List<DomainEvent> events) {
        // Se construye a traves del constructor privado
        var persona = new Persona(personaId);

        // Se recorre los eventos y se les aplica a las persona instanciada
        events.forEach(persona::applyEvent);
        return persona;
    }

    /**
     * COMPORTAMIENTOS
     * todos los comportamientos accionan un evento de dominio
     * lo segundo que se implementa
     */

    /**
     * Metodo del agregado la cual agrega una funcion que es una entidad
     * Recibe todos los parametros que tiene la clase funcion como parametros
     * se le pasan los parametros que recibe la entidad funcion en el constructor
     */
    public void agregarFuncion(FuncionId entityId, Caracteristica caracteristica, Descripcion descripcion) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(caracteristica);
        Objects.requireNonNull(descripcion);

        /*
         * Al agregar una funcion este metodo acciona un evento de dominio
         */
        appendChange(new FuncionAgregada(entityId, caracteristica, descripcion)).apply();
    }

    /**
     * asociarCuenta es para otro agregado asi que como los agregados se pasa por referencia
     * a traves de su id, solo se pasa por parametro dicho id
     */
    public void asociarCuenta(CuentaId cuentaId) {
        Objects.requireNonNull(cuentaId);
        appendChange(new CuentaAsociada(cuentaId)).apply();

    }

    public void cambiarNombre(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void actualizarCaracteristicaDeUnaFuncion(FuncionId funcionId, Caracteristica caracteristica) {
        Objects.requireNonNull(funcionId);
        Objects.requireNonNull(caracteristica);
        appendChange(new CaracteristicaDeFuncionActualizada(funcionId, caracteristica)).apply();
    }

    public void actualizarDescripcionDeUnaFuncion(FuncionId funcionId, Descripcion descripcion) {
        Objects.requireNonNull(funcionId);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionDeFuncionActualizada(funcionId, descripcion)).apply();
    }

    /**
     * Getters
     * lo tercero que se implementa
     */

    /**
     * Encontrar una funcion por su id
     */
    protected Optional<Funcion> getFuncionPorId(FuncionId funcionId) {
        return funciones()
                .stream()
                .filter(funcion -> funcion.identity().equals(entityId))
                .findFirst(); // Que obtenga el primero que encuentre que cumpla con la condicion
    }

    public Nombre nombre() {
        return nombre;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public Set<Funcion> funciones() {
        return funciones;
    }
}
