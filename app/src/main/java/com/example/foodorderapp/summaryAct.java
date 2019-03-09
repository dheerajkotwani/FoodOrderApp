package com.example.foodorderapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class summaryAct extends AppCompatActivity {
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        mText = (TextView)findViewById(R.id.sum2);
        String data = getIntent().getExtras().getString("abc");
        mText.setText(data);
    }


    public void submit(View view) {

        mText = (TextView)findViewById(R.id.sum2);
        String data = getIntent().getExtras().getString("abc");
        mText.setText(data);

    }

    public void send(View view) {
        mText = (TextView)findViewById(R.id.sum2);
        String data = getIntent().getExtras().getString("abc");
        mText.setText(data);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: dheeraj.kotwani41@gmail.com"));
        intent.putExtra(Intent.EXTRA_EMAIL,"dheeraj.kotwani41@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT, data);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}