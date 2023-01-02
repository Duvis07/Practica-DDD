package co.com.sofka.example.cuenta;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.example.cuenta.events.CuentaCreada;

/**
 * Quede en el minuto 34 del video
 */
public class CuentaChange extends EventChange {
    public CuentaChange(Cuenta cuenta) {

        apply((CuentaCreada event) -> {
            cuenta.nombre = event.getNombre();
            cuenta.email = event.getEmail();
        });

    }
}
