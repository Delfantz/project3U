package com.example.android.order_project3u;

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

import java.text.NumberFormat;
import java.util.Currency;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {

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
        CreamTW=(TextView) findViewById(R.id.Cream_yesOrNo_textBox) ;
        ChocolateCB=(CheckBox) findViewById(R.id.chocolate_checkbox);
        NameET=(EditText) findViewById(R.id.name_editText);


        CreamCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(CreamCB.isChecked()){
                    APRICE++;
                    Log.v("MaiAtivity.java",""+APRICE);
                    cream_list="with whipped cream";
                    CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                    updateQuantity(quantity);
                }else{
                    APRICE--;
                    Log.v("MaiAtivity.java",""+APRICE);
                    cream_list="without whipped cream";
                    CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
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
                        chocolate_list="with chocolate";
                        CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                        updateQuantity(quantity);

                    }else{
                        APRICE-=2;
                        Log.v("MaiAtivity.java",""+APRICE);
                        chocolate_list="without chocolate";
                        CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
                        updateQuantity(quantity);
                    }
            }
        });




    }
    int quantity=0;
    int priceForOne=5;
    TextView listTW,PriceTW,CreamTW;
    CheckBox CreamCB,ChocolateCB;
    EditText NameET;
    int PRICE=0,APRICE=0;
    String cream_list="without whipped cream",chocolate_list="without chocolate",name="";
    public void subtract(View v){
        if (quantity>0){
            quantity--;
            updateQuantity(quantity);
        }

    }
    public void addUp(View v){
        quantity++;
        updateQuantity(quantity);
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
        CreamTW.setText(cream_list + "\n"+ chocolate_list+"\n"+name);
    }
    public void updateQuantity(int quantity){

        PRICE= (quantity*priceForOne)+(quantity*APRICE);

        listTW.setText(""+quantity);

        PriceTW.setText(NumberFormat.getCurrencyInstance().format(PRICE));
    }
}
