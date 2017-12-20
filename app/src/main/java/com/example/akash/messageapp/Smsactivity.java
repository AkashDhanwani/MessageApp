package com.example.akash.messageapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Smsactivity extends AppCompatActivity {
    TextView tvmsg;
    EditText etsmsnumber;
    Button btnsendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        tvmsg = (TextView) findViewById(R.id.tvmsg);
        etsmsnumber = (EditText) findViewById(R.id.etsmsnumber);
        btnsendsms = (Button) findViewById(R.id.btnsendsms);

        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tvmsg.setText(msg);

        btnsendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = etsmsnumber.getText().toString();

                if(etsmsnumber.length() == 0)
                {
                    etsmsnumber.setError("Number Empty");
                    etsmsnumber.requestFocus();
                    return;
                }// end of if
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:" +num));
                i.putExtra("sms_body", msg);
                startActivity(i);

            }
        });
    }
}
