package com.creditapplicationsystem.creditapplicationsystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private long identificationNumber;

    private String name;
    private String surname;
    private String password;
    private int monthlyIncome;
    private long phoneNumber;

    public String Calculator() {

        int score = (int)(Math.random()*1250);
        String result = null;

        if(score < 500) {
            result = "Credit score is insufficient for the loan transaction.";
        }else if((score >= 500)&&(score <1000)) {
            if(monthlyIncome >= 5000) {
                result = "Congratulations! Your 10000 limit loan has been approved.";
            }else if(monthlyIncome < 5000) {
                result = "Congratulations! Your 20000 limit loan has been approved.";
            }
        }else if(score >= 1000) {
            int limit = (monthlyIncome*4);
            result = "Congratulations! Your " + limit + " limit loan has been approved.";
        }
        return result;
    }




}
