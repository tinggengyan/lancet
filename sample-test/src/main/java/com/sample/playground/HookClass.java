package com.sample.playground;

import android.os.Bundle;
import android.util.Log;

import me.ele.lancet.api.Origin;
import me.ele.lancet.api.This;
import me.ele.lancet.api.annotations.Insert;
import me.ele.lancet.api.annotations.Proxy;
import me.ele.lancet.api.annotations.TargetClass;

public class HookClass {
    @TargetClass("com.sample.playground.CoffeeMaker")
    @Insert("brew")
    public Cup brew(Cup cup) {
        System.out.println("SetFieldTest");
        CoffeeBox coffeeBox = (CoffeeBox) This.getField("coffeeBox");
        System.out.println("get " + coffeeBox.getLatte());
        return (Cup) Origin.call();
    }

    @TargetClass("android.app.Activity")
    @Proxy("onCreate")
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("boluo", "before Activity onCreate");
        Origin.callVoid();
    }


    private static void test() {
        System.out.println("ha");
    }

    static synchronized void test2() {
        return;
    }
}