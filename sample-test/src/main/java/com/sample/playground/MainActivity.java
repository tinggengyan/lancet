package com.sample.playground;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Hello, Lancet Android Demo!");
        setContentView(tv);

        Heater heater = new SuperHeater();
        Pump punm = new Thermosiphon(heater);
        CoffeeBox box = new CoffeeBox();
        CoffeeMaker maker = new CoffeeMaker(heater,punm,box);
        Cup cup = maker.brew(new Cup());
        System.out.println("a " + (cup.isEmpty() ? "empty" : "full") + " cup of " + cup.getCoffee());
    }
} 