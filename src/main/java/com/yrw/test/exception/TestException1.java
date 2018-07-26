package com.yrw.test.exception;

import net.sf.json.util.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class TestException1 {
    public static void main(String[] args) {

        List<String> errorList =new ArrayList<>();

        Exceps.excepUtils(errorList);

        System.out.println(JSONUtils.valueToString(errorList));

    }

}

class Exceps {

    public static Object excepUtils(List errorList){

        errorList.add("可以呀");

        try{
            int a = 5;
            int b = 0;
            int c = 5/0;
        }catch (Exception e){
            errorList.add("我想异常输出结果");
            return errorList;
        }

        System.out.println("ho h do u de su ga");
        return errorList;
    }
}


