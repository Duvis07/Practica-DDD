package co.com.sofka.example.cuenta.commands;

import co.com.sofka.example.cuenta.values.CuentaId;
import co.com.sofka.example.cuenta.values.Email;
import co.com.sofka.example.persona.values.Nombre;

public class CrearCuenta {

    private final CuentaId cuentaId;
    private final String nombre;
    private final String email;


    public CrearCuenta(CuentaId cuentaId, String nombre, String email) {
        this.cuentaId = cuentaId;
        this.nombre = nombre;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
