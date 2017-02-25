package com.example.android.order_project3u;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
        QuantityTW= (TextView) findViewById(R.id.Quantity_info);
        PriceTW= (TextView) findViewById(R.id.Price_info);
        CreamCB=(CheckBox) findViewById(R.id.Cream_checkbox);
        CreamTW=(TextView) findViewById(R.id.Cream_yesOrNo_textBox) ;

        CreamCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(CreamCB.isChecked()==true){
                    CreamTW.setText("with whipped cream");
                }else{
                    CreamTW.setText("without whipped cream");
                }
            }
        });



    }
    int quantity=0;
    int priceForOne=5;
    TextView QuantityTW,PriceTW,CreamTW;
    CheckBox CreamCB;
    //String palla;
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
    }
    public void updateQuantity(int quantity){
        QuantityTW.setText(""+quantity);
        int PRICE= quantity*priceForOne;
        PriceTW.setText(NumberFormat.getCurrencyInstance().format(PRICE));
    }
}
