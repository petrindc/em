package net.zcl.com.er.service;

import android.content.Context;

import net.zcl.com.er.exception.BusinessException;
import net.zcl.com.er.exception.ErrorCodes;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by petrindc on 13.07.2018.
 */

enum FileUtils {

    INSTANCE;

    public List<String> readFileLines(String fileName, Context context) throws BusinessException {
        List<String> allLines = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(fileName)))) {
            String line = null;
            while ((line = buff.readLine()) != null) {
                allLines.add(line);
            }
        } catch (Exception e) {
            throw new BusinessException(e.getMessage(), e.getCause(), ErrorCodes.FILE_READER_ERROR_CODE.getCode());
        }
        return allLines;
    }

}
