/*
 * Security Whitelist validate input fields on server side.
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.security;

import java.util.regex.Pattern;

/**
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class SecurityWhiteList {

    public static final boolean DONT_ALLOW_NULL_OR_EMPTY_INPUT = true;
    public static final boolean ALLOW_NULL_OR_EMPTY_INPUT = false;

    private static final Pattern ONLY_ASCII_CHARACTERS = Pattern.compile("[a-zA-Z]*");
    private static final Pattern ONLY_ASCII_CHARACTERS_AND_DIGITS = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern ONLY_DIGITS = Pattern.compile("[0-9]*");
    private static final Pattern ONLY_UNICODE_CHARACTERS = Pattern.compile("\\p{L}*");  // Allow Unicode characters
    private static final Pattern ONLY_UNICODE_CHARACTERS_AND_DIGITS = Pattern.compile("[\\p{L}0-9]*");  // Allow Unicode characters and digits
    private static final Pattern ONLY_LATIN_CHARACTERS_AND_WHITESPACE = Pattern.compile("[\\p{IsLatin}\\s]*");  // Allow Latin characters and whitespace
    private static final Pattern ONLY_LATIN_CHARACTERS_AND_WHITESPACE_AND_DIGITS = Pattern.compile("[\\p{IsLatin}\\s0-9]*");  // Allow Latin characters, whitespace and digits

    public static void onlyAsciiCharacters(String input, boolean checkIfNullOrEmpty) throws SecurityException {

        if (checkIfNullOrEmpty) {

            checkIfNullOrEmpty(input);
        }

        if (!ONLY_ASCII_CHARACTERS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters [a-zA-Z], input = '" + input + "'");
        }
    }

    public static void onlyAsciiCharacters(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        onlyAsciiCharacters(input, ALLOW_NULL_OR_EMPTY_INPUT);
    }

    public static void onlyAsciiCharactersAndDigits(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_ASCII_CHARACTERS_AND_DIGITS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not in [a-zA-Z0-9], input = '" + input + "'");
        }
    }

    public static void onlyAsciiCharactersAndDigits(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        onlyAsciiCharactersAndDigits(input);
    }

    public static void onlyDigits(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_DIGITS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not in [0-9], input = '" + input + "'");
        }
    }

    public static void onlyDigits(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        onlyDigits(input);
    }

    public static void anyUnicodeCharacters(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_UNICODE_CHARACTERS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not just unicode characters, input = '" + input + "'");
        }
    }

    public static void anyUnicodeCharacters(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        SecurityWhiteList.anyUnicodeCharacters(input);
    }

    public static void anyUnicodeCharactersAndDigits(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_UNICODE_CHARACTERS_AND_DIGITS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not just unicode characters or digits, input = '" + input + "'");
        }
    }

    public static void anyUnicodeCharacterAndDigits(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        SecurityWhiteList.anyUnicodeCharactersAndDigits(input);
    }

    public static void anyLatinCharactersAndWhitespaces(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_LATIN_CHARACTERS_AND_WHITESPACE.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not just Latin characters or whitspace, input = '" + input + "'");
        }
    }

    public static void anyLatinCharactersAndWhitespaces(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        SecurityWhiteList.anyLatinCharactersAndWhitespaces(input);
    }

    public static void anyLatinCharactersWhitespaceOrDigit(String input) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (!ONLY_LATIN_CHARACTERS_AND_WHITESPACE_AND_DIGITS.matcher(input).matches()) {

            throw new SecurityException("Input field contains unallowed characters not just Latin characters, whiotespace or digits, input = '" + input + "'");
        }
    }

    public static void anyLatinCharactersWhitespaceOrDigit(String input, int maxLength) throws SecurityException {

        checkIfNullOrEmpty(input);

        if (input.length() > maxLength) {

            throw new SecurityException("Input field to long, input = '" + input.substring(0, maxLength) + "'...");
        }

        SecurityWhiteList.anyLatinCharactersWhitespaceOrDigit(input);
    }

    /*
     * Helper methods
     */
    private static void checkIfNullOrEmpty(String input) throws SecurityException {

        if (input == null) {

            throw new SecurityException("Input field is null");
        }

        if (input.isEmpty()) {

            throw new SecurityException("Input field is empty");
        }
    }
}