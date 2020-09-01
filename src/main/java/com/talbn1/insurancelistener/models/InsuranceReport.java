package com.talbn1.insurancelistener.models;

import lombok.*;

import java.io.Serializable;

/**
 * @author talbn on 8/26/2020
 **/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceReport implements Serializable {

    private static final long serialVersionUID = 12358903454875L;

    private String customerName;
    private InsuranceType type;
    private InsuranceStatus status;
    private String freeText;


    @Override
    public String toString() {
        return "InsuranceReport{" +
                "customerName='" + customerName + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", freeText='" + freeText + '\'' +
                '}';
    }
}
