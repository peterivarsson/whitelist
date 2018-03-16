/*
 * Security Whitelist validate input fields on server side.
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.security.whitelist.exception;


/**
 * A general exception thrown from the Security layer.
 *
 * @author Peter Ivarsson     Peter.Ivarsson@cybercom.com
 */
public class SecurityException extends Exception {

    /**
     * Default constructor.
     */
    public SecurityException() {

        super();
    }

    /**
     * @param message Description of exception.
     */
    public SecurityException(final String message) {

        super(message);
    }

    public SecurityException(final String message, final SecurityException cause) {

        super(message, cause);
    }
}
