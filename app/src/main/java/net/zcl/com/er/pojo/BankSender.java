package net.zcl.com.er.pojo;

/**
 * Created by petrindc on 17.07.2018.
 */

public enum BankSender {

    BT("BT Carduri", "");

    private String smsBankName;

    private String phoneNo;

    BankSender(String smsBankName, String phoneNo) {
        this.smsBankName = smsBankName;
        this.phoneNo = phoneNo;
    }

    public String getSmsBankName() {
        return smsBankName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
