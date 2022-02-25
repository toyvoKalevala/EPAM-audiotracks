package com.epam.audiotracks.exeption;

import java.sql.SQLException;

public class ConnectionRuntimeException extends RuntimeException {
    public ConnectionRuntimeException(Throwable cause) {
        super(cause);
    }
}
