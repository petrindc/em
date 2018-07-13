package net.zcl.com.er.pojo;

import java.time.chrono.ChronoLocalDate;

/**
 * Created by petrindc on 25.06.2018.
 */
public class Withdraw {

    /** date of the withdraw. */
    private ChronoLocalDate date;

    /** the amount withdrawn. */
    private Double amount;

    /** Witdraw unit. */
    private String from;

    /** the message with the withdraw ex. ATM or shop. */
    private String messageId;




}
