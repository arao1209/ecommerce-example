package com.example.util;
import java.util.Arrays;
import java.util.List;

public class Constant {

    public static final String READY_STATUS = "Ready";
    public static final String DISPATCH_STATUS = "Dispatch";
    public static final String DELIVERED_STATUS = "Delivered";

    public static List<String> validOrderStatus(){

//        oderStatusList.add(READY_STATUS);
//        oderStatusList.add(DISPATCH_STATUS);
//        oderStatusList.add(DELIVERED_STATUS);

        return Arrays.asList(READY_STATUS, DISPATCH_STATUS, DELIVERED_STATUS);
    }

}
