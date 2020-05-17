package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TermsConditions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_terms_conditions);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final Button b = (Button)findViewById(R.id.accept);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TermsConditions.this,Dashboard.class));
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    b.setEnabled(true);
                }
                else {
                    b.setEnabled(false);
                }
            }
        });

    }
}
