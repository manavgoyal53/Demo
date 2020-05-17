package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDetail extends AppCompatActivity {
    Spinner location,language;
    Button submit;
    EditText username;
    FirebaseAuth auth;
    private DatabaseReference namedb;
    private DatabaseReference locationdb;
    private DatabaseReference languagedb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        findViews();
        auth = FirebaseAuth.getInstance();
        final String uid = auth.getCurrentUser().getUid();
        namedb = FirebaseDatabase.getInstance().getReference("UserData/"+ uid+"/name");
        locationdb = FirebaseDatabase.getInstance().getReference("UserData/"+ uid+"/location");
        languagedb = FirebaseDatabase.getInstance().getReference("UserData/"+ uid+"/language");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.toString();
                String city = String.valueOf(location.getSelectedItem());
                String langPreference = String.valueOf(language.getSelectedItem());

                if(!TextUtils.isEmpty(name))
                {
                    System.out.println("aefSfSS");
                    namedb.setValue(name);
                    locationdb.setValue(city);
                    languagedb.setValue(langPreference);
                    startActivity(new Intent(UserDetail.this,TermsConditions.class));
                }
                else{
                    username.setError( "First name is required!" );
                }
            }
        });


    }

    private void findViews(){
        location=findViewById(R.id.location);
        language=findViewById(R.id.language);
        username = findViewById(R.id.username);
        submit = findViewById(R.id.submit);
    }
}
