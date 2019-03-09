package com.example.foodorderapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: dheeraj.kotwani41@gmail.com"));
                intent.putExtra(Intent.EXTRA_EMAIL,"dheeraj.kotwani41@gmail.com");
                intent.putExtra(Intent.EXTRA_TEXT, "Suggestions:");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    int total = 0;
    boolean a,b;
    Button mButton;
    EditText mEdit;
    TextView mText;
    String f1="",f2="",f3="",f4="",f5="",a1="",a2="",strin="";

    //submit
    //Add other foods total
    public void submit(View view) {


        if(a && food8_qty>0)
        {
            food8_total=food8_total+(30*food8_qty);
            a1=("Extra cheese Added");
        }
        else
            a1="";

        if(b && food10_qty>0)
        {
            food10_total=food10_total+(50*food10_qty);
            a2=("Extra cheese Added");
        }
        else
            a2="";

        total = food1_total + food8_total+food10_total+food7_total+food4_total;
        display_total(total);
        mButton = (Button)findViewById(R.id.submit_but);
        mEdit   = (EditText)findViewById(R.id.edit_text);
        mText = (TextView)findViewById(R.id.display_text);
        if (food1_total>0)
            f1=("\nCoffee *"+food1_qty+"   ₹"+food1_total);
        else { f1="";
            food1_total = 0;
        }
        if (food4_total>0)
            f2=("\nSamosa *"+food4_qty+"   ₹"+food4_total);
        else {f2="";
        food4_total = 0;
        }
        if (food8_total>0)
            f3=("\nBurger *"+food8_qty+"   ₹"+food8_total+" "+a1);
        else {f3="";
            food8_total = 0;
        }
        if (food7_total>0)
            f4=("\nSpring Roll *"+food7_qty+"   ₹"+food7_total);
        else {f4="";
            food7_total = 0;
        }
        if (food10_total>0)
            f5=("\nPizza *"+food10_qty+"   ₹"+food10_total+" "+a2);
        else { f5="";
            food10_total = 0;
        }
        mText.setText("Welcome "+mEdit.getText().toString()+"!\n"+"Total Amount to pay is ₹ "+total+"\nOrdered Food:"+f1+f2+f3+f4+f5+"\nThank You for Ordering!");
        if(a && food8_price>=30)
    food8_total=food8_total-(30*food8_qty);
        if(b && food10_price>=50)
    food10_total=food10_total-(50*food10_qty);

        Intent intent1=new Intent(this,summaryAct.class);
        intent1.putExtra("abc","Welcome "+mEdit.getText().toString()+"!\n"+"Total Amount to pay is ₹ "+total+"\nOrdered Food:"+f1+f2+f3+f4+f5+"\nThank You for Ordering!");
        startActivity(intent1);
    }

    //start copy
    //deining variables
    int food1_qty, food1_price = 20, food1_total = 0;




    //different food items
    public void food1_inc(View view) {
        food1_qty = food1_qty + 1;
        TextView food1 = (TextView) findViewById(R.id.food1_qty);
        food1.setText("" + food1_qty);
        food1_total = food1_price * food1_qty;
    }

    public void food1_dec(View view) {
        if (food1_qty > 0) {
            food1_qty = food1_qty - 1;
        }
        TextView food1 = (TextView) findViewById(R.id.food1_qty);
        food1.setText("" + food1_qty);
        food1_total = food1_price * food1_qty;
    }
    //stop copy

    private void display_total(int total) {
        TextView tot = (TextView) findViewById(R.id.total_price);
        tot.setText(NumberFormat.getCurrencyInstance().format(total));
    }

    int food8_qty, food8_price = 40, food8_total = 0;


    //different food items
    public void food8_inc(View view) {
        food8_qty = food8_qty + 1;
        TextView food8 = (TextView) findViewById(R.id.food8_qty);
        food8.setText("" + food8_qty);
        food8_total = food8_price * food8_qty;
    }

    public void food8_dec(View view) {
        if (food8_qty > 0) {
            food8_qty = food8_qty - 1;
        }
        TextView food8 = (TextView) findViewById(R.id.food8_qty);
        food8.setText("" + food8_qty);
        food8_total = food8_price * food8_qty;
    }

    int food10_qty,food10_price=80,food10_total=0;
    //different food items
    public void food10_inc(View view){
        food10_qty=food10_qty+1;
        TextView food10=(TextView)findViewById(R.id.food10_qty);
        food10.setText(""+food10_qty);
        food10_total=food10_price*food10_qty;
    }
    public void food10_dec(View view){
        if(food10_qty>0){
            food10_qty=food10_qty-1;
        }
        TextView food10=(TextView)findViewById(R.id.food10_qty);
        food10.setText(""+food10_qty);
        food10_total=food10_price*food10_qty;
    }


    int food7_qty,food7_price=30,food7_total=0;



    //different food items
    public void food7_inc(View view){
        food7_qty=food7_qty+1;
        TextView food7=(TextView)findViewById(R.id.food7_qty);
        food7.setText(""+food7_qty);
        food7_total=food7_price*food7_qty;
    }
    public void food7_dec(View view){
        if(food7_qty>0){
            food7_qty=food7_qty-1;
        }
        TextView food7=(TextView)findViewById(R.id.food7_qty);
        food7.setText(""+food7_qty);
        food7_total=food7_price*food7_qty;
    }

    int food4_qty,food4_price=10,food4_total=0;



    //different food items
    public void food4_inc(View view){
        food4_qty=food4_qty+1;
        TextView food4=(TextView)findViewById(R.id.food4_qty);
        food4.setText(""+food4_qty);
        food4_total=food4_price*food4_qty;
    }
    public void food4_dec(View view){
        if(food4_qty>0){
            food4_qty=food4_qty-1;
        }
        TextView food4=(TextView)findViewById(R.id.food4_qty);
        food4.setText(""+food4_qty);
        food4_total=food4_price*food4_qty;
    }


    public void check1(View view){
        a=((CheckBox)view).isChecked();

    }
    public void check2(View view){
        b=((CheckBox)view).isChecked();


    }






}