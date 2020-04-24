package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions;

public class MembreNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>MembreNotFoundException</code> without
     * detail message.
     */
    public MembreNotFoundException() {
    }

    /**
     * Constructs an instance of <code>MembreNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MembreNotFoundException(String msg) {
        super(msg);
    }

}
