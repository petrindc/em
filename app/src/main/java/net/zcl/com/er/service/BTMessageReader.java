package net.zcl.com.er.service;

import android.app.Activity;

import net.zcl.com.er.exception.BusinessException;
import net.zcl.com.er.pojo.BankMessage;
import net.zcl.com.er.pojo.BankSender;
import net.zcl.com.er.pojo.Sms;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by petrindc on 16.07.2018.
 */

public class BTMessageReader implements MessageReader {

    @Override
    public List<BankMessage> readMessages(Activity activity, LocalDate from, LocalDate to) throws BusinessException {
        List<Sms> smsList = SmsReader.instance().getAllSms(activity);
        return smsList.stream()
                .filter(x -> x.getAddress().equals(BankSender.BT.getSmsBankName()))
                .map(x -> this.fromSms(x))
                .collect(Collectors.toList());
    }

    @Override
    public BankMessage fromSms(Sms aSms) {
        BankMessage result = new BankMessage();
        String[] tokens = aSms.getMsg().split(".");
        result.setTransactionForm(tokens[0]);
        return result;
    }
}
