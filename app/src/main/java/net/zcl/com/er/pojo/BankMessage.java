package net.zcl.com.er.pojo;

import java.time.chrono.ChronoLocalDate;

/**
 * Created by petrindc on 06.07.2018.
 */

public class BankMessage {

    // ATM, INTERNET, POS
    private String transactionForm;

    // amount transactioned.
    private Double amount;

    // currency transactioned
    private String currency;

    // bank card details.
    private String cardDetails;

    //transaction date msg: dd.MM.YY hh:mm
    private ChronoLocalDate transactionDate;

    // available Amount after withdraw
    private Double availableAmount;

    // Location/ shop/ website
    private String shop;

    // getters and setters
    public String getTransactionForm() {
        return transactionForm;
    }

    public void setTransactionForm(String transactionForm) {
        this.transactionForm = transactionForm;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ChronoLocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(ChronoLocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
