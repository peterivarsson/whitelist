/*
 * Security Whitelist validate input fields on server side.
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.security;

import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class WhitelistTest {

    /*
     * Accept only Ascii Characters
     */
    
    @Test
    public void onlyAsciiCharactersNull() {

        System.out.println("onlyAsciiCharactersNull");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersEmpty() {

        System.out.println("onlyAsciiCharactersEmpty");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersOK() {

        System.out.println("onlyAsciiCharactersOK");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("abcABCabc");
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void onlyAsciiCharactersDigitsFail() {

        System.out.println("onlyAsciiCharactersDigitsFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("abcABCa7bc");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersSwedishFail() {

        System.out.println("onlyAsciiCharactersSwedishFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("abcABCabÅc");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersJavaScriptFail() {

        System.out.println("onlyAsciiCharactersJavaScriptFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersSQLFail() {

        System.out.println("onlyAsciiCharactersSQLFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersToLong() {

        System.out.println("onlyAsciiCharactersToLong");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("abcABCabc", 8);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersLengthOK() {

        System.out.println("onlyAsciiCharactersLengthOK");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharacters("abcABCabc", 9);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept only Ascii Characters or Digits
     */
    
    @Test
    public void onlyAsciiCharactersAndDigitsNull() {

        System.out.println("onlyAsciiCharactersAndDigitsNull");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsEmpty() {

        System.out.println("onlyAsciiCharactersAndDigitsEmpty");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsOK() {

        System.out.println("onlyAsciiCharactersAndDigitsOK");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("abcAB8Cab2c");
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsFail() {

        System.out.println("onlyAsciiCharactersAndDigitsFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("abcABCaÅbc");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsSwedishFail() {

        System.out.println("onlyAsciiCharactersAndDigitsSwedishFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("abcABCabÅc");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsJavaScriptFail() {

        System.out.println("onlyAsciiCharactersAndDigitsJavaScriptFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsSQLFail() {

        System.out.println("onlyAsciiCharactersAndDigitsSQLFail");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsToLong() {

        System.out.println("onlyAsciiCharactersAndDigitsToLong");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("abcA7BCab6c", 10);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyAsciiCharactersAndDigitsLengthOK() {

        System.out.println("onlyAsciiCharactersAndDigitsLengthOK");
        
        try {
        
            SecurityWhiteList.onlyAsciiCharactersAndDigits("abcA7BCab6c", 11);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept only Digits
     */
    
    @Test
    public void onlyDigitsNull() {

        System.out.println("onlyDigitsNull");
        
        try {
        
            SecurityWhiteList.onlyDigits(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void onlyDigitsEmpty() {

        System.out.println("onlyDigitsEmpty");
        
        try {
        
            SecurityWhiteList.onlyDigits("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsOK() {

        System.out.println("onlyDigitsOK");
        
        try {
        
            SecurityWhiteList.onlyDigits("1234567890");
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void onlyDigitsFail() {

        System.out.println("onlyDigitsFail");
        
        try {
        
            SecurityWhiteList.onlyDigits("1234567890A");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsSwedishFail() {

        System.out.println("onlyDigitsSwedishFail");
        
        try {
        
            SecurityWhiteList.onlyDigits("1234567890Å");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsJavaScriptFail() {

        System.out.println("onlyDigitsJavaScriptFail");
        
        try {
        
            SecurityWhiteList.onlyDigits("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsSQLFail() {

        System.out.println("onlyDigitsSQLFail");
        
        try {
        
            SecurityWhiteList.onlyDigits("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsToLong() {

        System.out.println("DigitsToLong");
        
        try {
        
            SecurityWhiteList.onlyDigits("1234567890", 9);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void onlyDigitsLengthOK() {

        System.out.println("onlyDigitsLengthOK");
        
        try {
        
            SecurityWhiteList.onlyDigits("1234567890", 10);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept any Unicode characters
     */
    
    @Test
    public void anyUnicodeCharactersNull() {

        System.out.println("anyUnicodeCharactersNull");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersEmpty() {

        System.out.println("anyUnicodeyCharactersEmpty");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOK() {

        System.out.println("anyUnicodeyCharactersOK");
        String input = "abcABCabcåäöÅÄÖüÜ\u0626";
        System.out.println(input);
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters(input);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void anyUnicodeCharactersDigitsFail() {

        System.out.println("anyUnicodeCharactersDigitsFail");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("abcABCa7bc");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersJavaScriptFail() {

        System.out.println("anyUnicodeCharactersJavaScriptFail");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersSQLFail() {

        System.out.println("anyUnicodeCharactersSQLFail");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersToLong() {

        System.out.println("anyUnicodeCharactersToLong");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("abcABCabcÅÄÖ", 11);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersLengthOK() {

        System.out.println("anyUnicodeCharactersLengthOK");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacters("abcABCabcÅÄÖ", 12);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept any Unicode charaters and Digits
     */
    
    @Test
    public void anyUnicodeCharactersOrDigitNull() {

        System.out.println("anyUnicodeCharactersOrDigitNull");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharactersAndDigits(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitEmpty() {

        System.out.println("anyUnicodeCharactersOrDigitEmpty");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharactersAndDigits("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitOK() {

        System.out.println("anyUnicodeCharactersOrDigitsOK");
        String input = "aabcABCabcåäöÅÄÖüÜ1234567890\u0626";
        System.out.println(input);
        
        try {
        
            SecurityWhiteList.anyUnicodeCharactersAndDigits(input);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitJavaScriptFail() {

        System.out.println("anyUnicodeCharactersOrDigitJavaScriptFail");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharactersAndDigits("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitSQLFail() {

        System.out.println("anyUnicodeCharactersOrDigitSQLFail");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharactersAndDigits("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitToLong() {

        System.out.println("anyUnicodeCharactersOrDigitToLong");
        
        try {

            SecurityWhiteList.anyUnicodeCharacterAndDigits("abcABCabcåäöÅÄÖüÜ1234567890", 26);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyUnicodeCharactersOrDigitLengthOK() {

        System.out.println("anyUnicodeCharactersOrDigitLengthOK");
        
        try {
        
            SecurityWhiteList.anyUnicodeCharacterAndDigits("abcABCabcåäöÅÄÖüÜ1234567890", 27);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept any Latin characters and Whitespaces
     */
    
    @Test
    public void anyLatinCharactersAndWhitespacesNull() {

        System.out.println("anyLatinCharactersAndWhitespacesNull");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces(null);
        
            fail();
        }
        catch(NullPointerException npe) {
            
            System.out.println(npe.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespaceEmpty() {

        System.out.println("anyLatinCharactersAndWhitespaceEmpty");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespaceOK() {

        System.out.println("anyLatinCharactersAndWhitespaceOK");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("abcABCabcåäöÅÄÖüÜ \t\n\r");
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespaceDigitsFail() {

        System.out.println("anyLatinCharactersAndWhitespaceDigitsFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("abcABCabcåäöÅÄÖüÜ \t\n\r7");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespaceArabicFail() {

        System.out.println("anyLatinCharactersAndWhitespaceArabicFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("abcABCabcåäöÅÄÖüÜ \t\n\r\u0626");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespaceJavaScriptFail() {

        System.out.println("anyLatinCharactersAndWhitespaceJavaScriptFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespacesSQLFail() {

        System.out.println("anyLatinCharactersAndWhitespacesSQLFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespacesToLong() {

        System.out.println("anyLatinCharactersAndWhitespacesToLong");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("abcABCabcåäöÅÄÖüÜ \t\n\r", 20);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersAndWhitespacesLengthOK() {

        System.out.println("anyLatinCharactersAndWhitespacesLengthOK");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersAndWhitespaces("abcABCabcåäöÅÄÖüÜ \t\n\r", 21);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    /*
     * Accept any Latin characters, Whitespaces and Digits
     */

    public void anyLatinCharactersWhitespaceOrDigitNull() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitNull");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit(null);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitEmpty() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitEmpty");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitOK() {

        System.out.println("anyLatinCharactersAndWhitespaceOK");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("abcABCabcåäöÅÄÖüÜ \t\n\r1234567890");
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitArabicFail() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitArabicFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("abcABCabcåäöÅÄÖüÜ \t\n\r1234567890\u0626");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitJavaScriptFail() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitJavaScriptFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("<script>");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitSQLFail() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitSQLFail");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("select * from users");
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitToLong() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitToLong");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("abcABCabcåäöÅÄÖüÜ \t\n\r1234567890", 30);
        
            fail();
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        }
    }

    @Test
    public void anyLatinCharactersWhitespaceOrDigitLengthOK() {

        System.out.println("anyLatinCharactersWhitespaceOrDigitLengthOK");
        
        try {
        
            SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit("abcABCabcåäöÅÄÖüÜ \t\n\r1234567890", 31);
        }
        catch(IllegalArgumentException se) {
            
            System.out.println(se.getMessage());
        
            fail();
        }
    }

}
