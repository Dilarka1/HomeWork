package com.cbt.utilities;

public class VerifyStringEquality {
    public static void verifyStrings(String expectedResult, String actualResult) {
        if (expectedResult.equals(actualResult)) {
            System.out.println("Expected Result: \n" + "\"" + expectedResult + "\"" + "\n\nActual Result: \n" + "\"" + actualResult +
                    "\"" + "\n\n " + "EXPECTED RESULT AND ACTUAL RESULT ARE SAME SO TEST PASSED");
        } else {
            System.out.println("Expected Result: \n" + "\"" + expectedResult + "\n\nActual Result: \n" + "\"" + actualResult + "\"" +
                    "\n\n " + "EXPECTED RESULT AND ACTUAL RESULT ARE NOT SAME SO TEST FAILED");
        }
    }

    public static void verifyStrings(String expectedResult, String actualResult, boolean visible){
        if (expectedResult.equals(actualResult) && visible){
            System.out.println("Expected Result: \n" + "\"" + expectedResult + "\"" + "\nand Element must be visible..." +
                    "\n\nActual Result: \n" + "\"" + actualResult + "\"" + "\nand Element is visible...\n\n " +
                    "EXPECTED RESULT AND ACTUAL RESULT ARE SAME SO TEST PASSED");
        }else{
            System.out.println("Expected Result: \n" + "\"" + expectedResult + "\""+ "\nand Element must be visible..." +
                    "\n\nActual Result: \n" + "\"" + actualResult + "\"" + "\nand Element is not visible...\n\n " +
                    "EXPECTED RESULT AND ACTUAL RESULT ARE NOT SAME SO TEST FAILED");
        }
    }

}
