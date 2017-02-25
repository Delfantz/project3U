package com.example.android.order_project3u;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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





    }
    Integer quantity=0;
    Integer priceForOne=5;
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
    }
    public void updateQuantity(Integer quantity){
        TextView QuantityTW= (TextView) findViewById(R.id.Quantity_info);
        QuantityTW.setText(quantity.toString());
        TextView PriceTW= (TextView) findViewById(R.id.Price_info);
        Integer PRICE= quantity*priceForOne;
        PriceTW.setText(NumberFormat.getCurrencyInstance().format(PRICE));
    }
}
