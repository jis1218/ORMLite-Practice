package com.example.ormliteprac;

import android.content.Context;
import android.database.sqlite.SQLiteException;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-09-23.
 */

public class DaoClass {

    private DBHelper helper = null;
    private Dao<ModelCl, String> dao = null;

    public DaoClass(Context context) {
        helper = new DBHelper(context);
        try {
            dao = helper.getDao(ModelCl.class);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(ModelCl model){
        try {
            dao.create(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ModelCl> read(){
        ArrayList<ModelCl> list = null;
        try {
            list = (ArrayList) dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(){

    }

    public void delete(){

    }
}
