package com.example.ormliteprac;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 정인섭 on 2017-09-23.
 */

@DatabaseTable(tableName = "modelcl")
public class ModelCl {
    @DatabaseField
    private String title;
    @DatabaseField
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
