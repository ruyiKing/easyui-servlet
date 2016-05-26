package com.yrw.test;

class SwichCaseTest
    {
        public static void main(String[] args)
        {
            CaseTest(1);
            CaseTest(2);
            CaseTest(5);
            CaseTest(8);
        }
        public static void CaseTest(int i)
        {
            switch (i)
            {
                case 1:case 2:case 3:case 4:
                    System.out.println("ok!**********");
                    break;
                case 5:
                	System.out.println("wrong!*******");
                    break;
                default:
                	System.out.println("default case!*********");
                    break;
            }
        }
    }