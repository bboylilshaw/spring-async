package org.jasonxiao.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Jason on 7/28/16.
 */
public class ErrorInfo {

    private final HttpStatus status;
    private final int code;
    private final String message;
    private final String exception;
    private final String path;
    private final LocalDateTime timestamp;

    public ErrorInfo(HttpStatus status, int code, String message, String exception, String path) {
        Assert.notNull(status, "HttpStatus cannot be null");

        this.status = status;
        this.code = code;
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public int getStatus() {
        return status.value();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getException() {
        return exception;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static class Builder {

        private HttpStatus status;
        private int code;
        private String message;
        private String exception;
        private String path;

        public Builder() {
            //This is intended to be an empty constructor
        }

        public Builder setStatus(int statusCode) {
            this.status = HttpStatus.valueOf(statusCode);
            return this;
        }

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setException(String exception) {
            this.exception = exception;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public ErrorInfo build() {
            if (this.status == null) {
                this.status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return new ErrorInfo(this.status, this.code, this.message, this.exception, this.path);
        }
    }
}
