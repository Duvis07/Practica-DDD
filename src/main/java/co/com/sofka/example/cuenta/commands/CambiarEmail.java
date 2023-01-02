package co.com.sofka.example.cuenta.commands;

import co.com.sofka.domain.generic.Command;

public class CambiarEmail extends Command {

    private final String email;

    public CambiarEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



}
