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
}
