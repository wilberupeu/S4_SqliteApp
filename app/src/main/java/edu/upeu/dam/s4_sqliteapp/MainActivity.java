package edu.upeu.dam.s4_sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB=new DBHelper(this);

        Boolean checkupInsertData=DB.insertUserData("Pedro 1","968752145","14/04/2000");
        if(checkupInsertData)
            Toast.makeText(MainActivity.this,"Datos Insertados",Toast.LENGTH_SHORT);
        else
            Toast.makeText(MainActivity.this,"Datos NO Insertados",Toast.LENGTH_SHORT);


        Cursor res=DB.getUserData();

        StringBuffer buffer=new StringBuffer();

        while (res.moveToNext()){
            buffer.append(" Name : "+res.getString(0)+" \n");
            buffer.append(" Contact : "+res.getString(1)+" \n");
            buffer.append(" Date of Birth : "+res.getString(2)+" \n");

        }


        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(" Usuario Ingresados");
        builder.setMessage(buffer);
        builder.show();

    }


}