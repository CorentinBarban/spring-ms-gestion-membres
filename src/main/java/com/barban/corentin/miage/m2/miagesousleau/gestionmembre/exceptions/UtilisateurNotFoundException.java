package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions;

public class UtilisateurNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>UtilisateurNotFoundException</code> without
     * detail message.
     */
    public UtilisateurNotFoundException() {
    }

    /**
     * Constructs an instance of <code>UtilisateurNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtilisateurNotFoundException(String msg) {
        super(msg);
    }

}
