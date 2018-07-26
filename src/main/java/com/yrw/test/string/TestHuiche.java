package com.yrw.test.string;

public class TestHuiche {

    public static void main(String[] args) {

        String str = "红盾网链接：\r\n" +
                "http://zj.gsxt.gov.cn/%7BA6E009D6C186F85B2DF2A3E492F544538C40F680C70B6CB1581F08D71B795887D61A7DA0490EB81B0F18BBAF1948FEB98A9F66B79756947ABB42BA549570DC2CDC8ADC8ADC2CDC8A0E540EFEA8FE2B7D8D6FC99FC5011CADCFC283F59223B0E1F680C92B40164030862531874BFA8CC535C593C593C5-1528447396036%7D&quot";


        System.out.println(str);
        System.out.println(str.replaceAll("\r\n",""));

    }



}
