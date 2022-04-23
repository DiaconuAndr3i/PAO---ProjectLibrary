package com.springboot.system.Library.error;

import java.util.Date;

public class Error {

    private Date timestamp;
    private String details;

    public Error(Date timestamp, String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Error{" +
                "timestamp='" + timestamp + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
