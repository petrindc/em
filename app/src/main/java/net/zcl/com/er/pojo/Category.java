package net.zcl.com.er.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by petrindc on 25.06.2018.
 */
public class Category {

    private String name;

    private int categoryId;

    public Category(String name, int categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return name + ',' + categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
