package com.example.akash.messageapp;

import android.content.Intent;
import android.net.Uri;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class email extends AppCompatActivity {

    EditText etAddress, etSubject;
    Button btnSend;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etAddress = findViewById(R.id.etAddress);
        etSubject = findViewById(R.id.etSubject);
        btnSend = findViewById(R.id.btnSend);
        tv = findViewById(R.id.tv);

        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tv.setText(msg);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Patterns.EMAIL_ADDRESS.matcher(etAddress.getText().toString()).matches())
                {
                    etAddress.setError("Invalid email");
                    etAddress.requestFocus();
                    return;
                }
                if(etSubject.getText().toString().length() == 0)
                {
                    etSubject.setError("Please enter a subject");
                    etSubject.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+etAddress.getText().toString()));
                i.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(i);
            }
        });
    }
}
