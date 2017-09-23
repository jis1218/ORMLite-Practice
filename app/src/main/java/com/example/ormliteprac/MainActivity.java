package com.example.ormliteprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelCl> list = null;
    TextView textView, textView2;
    EditText editText, editText2;
    Button button, button2;
    DaoClass daoClass = null;
    ModelCl modelCl = null;
    int num = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setButtonListener();
        daoClass = new DaoClass(this);


    }

    public void initWidget(){
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        list = new ArrayList<>();
    }

    public void setButtonListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daoClass = new DaoClass(MainActivity.this);
                modelCl = new ModelCl();
                modelCl.setTitle(editText.getText().toString());
                modelCl.setContent(editText2.getText().toString());
                daoClass.insert(modelCl);
                list.add(modelCl);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daoClass = new DaoClass(MainActivity.this);
                list = daoClass.read();
                textView.setText(list.get(num%list.size()).getTitle());
                textView2.setText(list.get(num%list.size()).getContent());

                num++;
            }
        });
    }
}

