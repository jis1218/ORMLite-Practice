package com.example.ormliteprac;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by 정인섭 on 2017-09-23.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "ORM_Prac";
    private static final int DB_VERSION = 1;
    Context context = null;

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    public DBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ModelCl.class);
            Toast.makeText(context, "Table이 만들어졌습니다", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
