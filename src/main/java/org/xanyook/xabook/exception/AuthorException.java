package org.xanyook.xabook.exception;

public class AuthorException extends Exception {

    private static final long serialVersionUID = -3241367607909376040L;

    public AuthorException() {
        super();
    }

    public AuthorException(String message) {
        super( message );
    }

    public AuthorException(String message, Throwable cause) {
        super( message, cause );
    }

    public AuthorException(Throwable cause) {
        super( cause );
    }

}
