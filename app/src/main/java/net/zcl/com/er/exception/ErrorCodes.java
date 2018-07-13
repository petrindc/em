package net.zcl.com.er.exception;

/**
 * Created by petrindc on 25.06.2018.
 */

public enum ErrorCodes {


    FILE_WRITER_ERROR_CODE(100),
    FILE_READER_ERROR_CODE(101);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
