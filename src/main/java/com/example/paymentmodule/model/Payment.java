package com.example.paymentmodule;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Document (collection="Card_Details")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @NotBlank
    @Size(min = 5,message = "Atleast 5 characters")
    private String owner;
    @NotBlank
    @Digits(integer=3,message="Invalid no", fraction = 0)
    private String cvv;
    @NotBlank
    @CreditCardNumber(message="Not a valid credit card number")
    private String cardno;

}
