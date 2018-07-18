package net.zcl.com.er.service;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;

import net.zcl.com.er.pojo.Sms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by petrindc on 16.07.2018.
 */

public class SmsReader {

    private static SmsReader INSTANCE = null;

    private SmsReader() {};

    public static SmsReader instance(){
        if(INSTANCE == null) {
            INSTANCE = new SmsReader();
        }
        return INSTANCE;
    }

    public List<Sms> getAllSms(Activity mActivity) {

        List<Sms> lstSms = new ArrayList<Sms>();
        ContentResolver cr = mActivity.getContentResolver();

        Cursor c = cr.query(Telephony.Sms.Inbox.CONTENT_URI, // Official CONTENT_URI from docs
                new String[] { Telephony.Sms.Inbox.BODY }, // Select body text
                null,
                null,
                Telephony.Sms.Inbox.DEFAULT_SORT_ORDER); // Default sort order

        int totalSMS = c.getCount();

        if (c.moveToFirst()) {
            for (int i = 0; i < totalSMS; i++) {
                Sms objSms = new Sms();
                objSms.setId(c.getString(c.getColumnIndexOrThrow("_id")));
                objSms.setAddress(c.getString(c
                        .getColumnIndexOrThrow("address")));
                objSms.setMsg(c.getString(c.getColumnIndexOrThrow("body")));
                objSms.setReadState(c.getString(c.getColumnIndex("read")));
                objSms.setTime(c.getString(c.getColumnIndexOrThrow("date")));
                objSms.setFolderName("inbox");
                lstSms.add(objSms);
                c.moveToNext();
            }
        } else {
            throw new RuntimeException("You have no SMS in Inbox");
        }
        c.close();

        return lstSms;
    }
}
