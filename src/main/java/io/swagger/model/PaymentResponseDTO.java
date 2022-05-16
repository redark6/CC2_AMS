package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentResponseDTO {
    @JsonProperty("paymentId")
    private String paymentId = null;
    @JsonProperty("status")
    private PaymentResponse.StatusEnum status = null;
    @JsonProperty("date")
    private String date = null;
    @JsonProperty("resultat")
    private String resultat = null;

    public PaymentResponseDTO(String paymentId, PaymentResponse.StatusEnum status, String date, String resultat) {
        this.paymentId = paymentId;
        this.status = status;
        this.date = date;
        this.resultat = resultat;
    }

    public PaymentResponseDTO(PaymentResponse paymentResponse) {
        this.paymentId = paymentResponse.getPaymentId();
        this.status = paymentResponse.getStatus();
        this.date = paymentResponse.getDate();
        this.resultat = paymentResponse.getResultat();
    }
}
