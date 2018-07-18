package net.zcl.com.er.pojo;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petrindc on 16.07.2018.
 */

public enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    int monthNumber;
    private static SparseArray<Month> monthByNumber = new SparseArray<Month>();

    static {
        for (Month month : Month.values()) {
            monthByNumber.put(month.getMonthNumber(), month);
        }
    }

    Month(int monthNo) {
        this.setMonthNumber(monthNo);
    }

    private void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public Month fromInt(int monthNo) {
        return monthByNumber.get(monthNo);
    }
}
