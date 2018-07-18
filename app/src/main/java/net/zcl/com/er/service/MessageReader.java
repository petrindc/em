package net.zcl.com.er.service;

import android.app.Activity;

import net.zcl.com.er.exception.BusinessException;
import net.zcl.com.er.pojo.BankMessage;
import net.zcl.com.er.pojo.Month;
import net.zcl.com.er.pojo.Sms;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by petrindc on 16.07.2018.
 */

public interface MessageReader {

    public List<BankMessage> readMessages(Activity activity, LocalDate from, LocalDate to) throws BusinessException;

    public BankMessage fromSms(Sms aSms);

}
