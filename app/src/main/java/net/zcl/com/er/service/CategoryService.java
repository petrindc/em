package net.zcl.com.er.service;

import android.content.Context;

import net.zcl.com.er.exception.BusinessException;
import net.zcl.com.er.exception.ErrorCodes;
import net.zcl.com.er.pojo.Category;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by petrindc on 25.06.2018.
 */

public class CategoryService {

    private static final String CATEGORY_FILE_NAME = "categories.txt";

    private Context context;

    public CategoryService(Context context) {
        this.context = context;
    }

    /**
     * Create Category method.
     *
     * @param categoryName a String
     * @return the List of categories
     * @throws BusinessException on reading or writing categories
     */
    public List<Category> createCategory(final String categoryName) throws BusinessException {
        List<Category> allCategories = readCategories();
        int maxId = allCategories.stream().sorted((x,y) -> x.getCategoryId() - y.getCategoryId()).flatMap(c -> Stream.of(c.getCategoryId())).findFirst().get();
        allCategories.add(new Category(categoryName, maxId +1));
        writeCategores(allCategories);
        return allCategories;
    }

    /**
     * Method used for retrieving al categories.
     *
     * @return the found categories.
     */
    public List<Category> readCategories() throws BusinessException {
        return FileUtils.INSTANCE.readFileLines(CATEGORY_FILE_NAME, this.context).stream()
                .map(x -> x.split(","))
                .map(y -> new Category(y[0], Integer.valueOf(y[1])))
                .collect(Collectors.toList());

    }

    /**
     * Method used for writing the categories, no append, just rewrite everything.
     */
    public void writeCategores(List<Category> categories) throws BusinessException {
        String toBeWritten = categories.stream().map(Category::toString).collect(Collectors.joining(System.getProperty("line.separator")));
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(CATEGORY_FILE_NAME, Context.MODE_PRIVATE))) {
            outputStreamWriter.write(toBeWritten);
        }
        catch (IOException e) {
            throw new BusinessException(e.getMessage(), e.getCause(), ErrorCodes.FILE_WRITER_ERROR_CODE.getCode());
        }
    }

}
