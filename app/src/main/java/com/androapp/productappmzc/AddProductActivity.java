package com.androapp.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;
    String getPc,getPn,getPr;
    DatabaseHelper dbhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        dbhelp=new DatabaseHelper(this);
        dbhelp.getReadableDatabase();
        ed1=(EditText) findViewById(R.id.pc);
        ed2=(EditText) findViewById(R.id.pn);
        ed3=(EditText) findViewById(R.id.pr);
        b1=(AppCompatButton) findViewById(R.id.sub);
        b2=(AppCompatButton) findViewById(R.id.menu);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPc=ed1.getText().toString();
                getPn=ed2.getText().toString();
                getPr=ed3.getText().toString();

                boolean result=dbhelp.insertData(getPc,getPn,getPr);
                if(result==true)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}