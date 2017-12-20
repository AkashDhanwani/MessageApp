package com.example.akash.messageapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etText;
    Button btnWasp, btnEmail, btnSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.etText);
        btnWasp = findViewById(R.id.btnWasp);
        btnEmail = findViewById(R.id.btnEmail);
        btnSms = findViewById(R.id.btnSms);

        btnWasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etText.getText().toString().length() == 0)
                {
                    etText.setError("Please enter a String");
                    etText.requestFocus();
                    return;
                }
                String text = etText.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT,text);
                try {
                    startActivity(i);
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Whatsapp not installed",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etText.getText().toString().length() == 0)
                {
                    etText.setError("Please enter a String");
                    etText.requestFocus();
                    return;
                }

                String text = etText.getText().toString();

                Intent i = new Intent(getApplicationContext(), email.class);
                i.putExtra("msg", text);
                startActivity(i);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etText.getText().toString().length() == 0)
                {
                    etText.setError("Please enter a String");
                    etText.requestFocus();
                    return;
                }

                String text = etText.getText().toString();

                Intent i = new Intent(getApplicationContext(), Smsactivity.class);
                i.putExtra("msg",text);
                startActivity(i);
            }
        });
    }
}
