package co.com.sofka.example.cuenta.commands;

import co.com.sofka.domain.generic.Command;

public class CambiarNombre extends Command {

    private final String nombre;

    public CambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
