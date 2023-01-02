package co.com.sofka.example.cuenta.commands;

public class CrearCuenta {
    private final String nombre;
    private final String email;

    public CrearCuenta(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
