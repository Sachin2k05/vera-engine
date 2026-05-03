package com.example.demo.model;

public class Response {
    public String message;
    public String cta;
    public String sendAs;
    public String suppressionKey;
    public String rationale;

    public Response(String message, String cta, String sendAs, String suppressionKey, String rationale) {
        this.message = message;
        this.cta = cta;
        this.sendAs = sendAs;
        this.suppressionKey = suppressionKey;
        this.rationale = rationale;
    }
}