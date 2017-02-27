package com.example.android.order_project3u;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {

    int quantity=1;
    int priceForOne=5;
    TextView listTW,PriceTW;
    CheckBox CreamCB,ChocolateCB;
    EditText NameET;
    int PRICE=0,APRICE=0;
    String cream_list,chocolate_list,name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView Topping_title= (TextView) findViewById(R.id.Topping_title);
        //TextView Order_title= (TextView) findViewById(R.id.OrderSummary_title);
        //TextView Quantity_title= (TextView) findViewById(R.id.Quantity_title);
        listTW= (TextView) findViewById(R.id.Quantity_info);
        PriceTW= (TextView) findViewById(R.id.Price_info);
        CreamCB=(CheckBox) findViewById(R.id.Cream_checkbox);
        //CreamTW=(TextView) findViewById(R.id.Cream_yesOrNo_textBox) ;
        ChocolateCB=(CheckBox) findViewById(R.id.chocolate_checkbox);
        NameET=(EditText) findViewById(R.id.name_editText);
        PriceTW.setText(NumberFormat.getCurrencyInstance().format(1));
        cream_list=getString(R.string.without_cream);
        chocolate_list=getString(R.string.without_chocolate);
        //Log.v("MainActivity.java",""+name);


        CreamCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(CreamCB.isChecked()){
                    APRICE++;
                    Log.v("MaiAtivity.java",""+APRICE);
                    cream_list=getString(R.string.with_cream);
                    //CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                    updateQuantity(quantity);
                }else{
                    APRICE--;
                    Log.v("MaiAtivity.java",""+APRICE);
                    cream_list=getString(R.string.without_cream);
                    //CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                    updateQuantity(quantity);

                }
            }
        });

        ChocolateCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(ChocolateCB.isChecked()){
                        APRICE+=2;
                        Log.v("MaiAtivity.java",""+APRICE);
                        chocolate_list=getString(R.string.with_chocolate);
                        //CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                        updateQuantity(quantity);

                    }else{
                        APRICE-=2;
                        Log.v("MaiAtivity.java",""+APRICE);
                        chocolate_list=getString(R.string.without_chocolate);
                        //CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                        updateQuantity(quantity);
                    }
            }
        });




    }

    public void subtract(View v){
        if (quantity>1){
            quantity--;
            updateQuantity(quantity);
        }

    }
    public void addUp(View v){
        if(quantity<100){
            quantity++;
            updateQuantity(quantity);
        }

    }
    public void order(View v){
       // TextView PriceTW= (TextView) findViewById(R.id.Price_info);
       // Integer PRICE= quantity*priceForOne;
       // PriceTW.setText(NumberFormat.getCurrencyInstance().format(PRICE));
     /*   int i=1000;
        while(i>0){
            palla+="PALLAUOLO";
            CreamTW.setText(palla);
            i--;
        } */

        name=NameET.getText().toString();
        Log.v("MainActivity.java",""+name);
        if(name.matches("")){
            Toast.makeText(this,getString(R.string.message_fill_name),Toast.LENGTH_SHORT).show();
        }else{

            String to[]={getString(R.string.bar_mail)};
            //CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
            Intent intent= new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_TEXT,cream_list + "\n"+ chocolate_list+"\n"+name+"\n"+PriceTW.getText().toString()+"\n"+quantity);
            intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.subjectMail,name));
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }



    }
    public void updateQuantity(int quantity){

        PRICE= (quantity*priceForOne)+(quantity*APRICE);

        listTW.setText(""+quantity);

        PriceTW.setText(NumberFormat.getCurrencyInstance().format(PRICE));
    }

}
