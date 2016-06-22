package org.jasonxiao.demo.model;

import org.jasonxiao.demo.common.Status;

public class ProcessingStatus {
    private int statusCode;
    private Status statusMessage;

    public ProcessingStatus(int statusCode, Status statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Status getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(Status statusMessage) {
        this.statusMessage = statusMessage;
    }
}
