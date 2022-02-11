package it.unikey.testhub_server.BLL.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {

    private HttpStatus httpStatus;

    public GlobalException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
