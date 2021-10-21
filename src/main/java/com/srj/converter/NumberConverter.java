package com.srj.converter;

public class NumberConverter {

    private static final String[] unit = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    private static final String[] tens = {
            "",        // ->0
            "",            // ->1
            "Twenty",    // ->2
            "Thirty",    // ->3
            "Forty",    // ->4
            "Fifty",    // ->5
            "Sixty",    // ->6
            "Seventy",    // ->7
            "Eighty",    // ->8
            "Ninety"    // ->9
    };

    /**
     * Returns a {@code String} representing this
     * {@code Integer}'s value.
     * @param n  The {@code int} to be converted.
     * @return value as String.
     */
    public static String int2str(final int n) {
        if (n < 0) {
            return "Minus " + int2str(-n).trim();
        }
        if(n==0){
            return "Zero";
        }
        if (n < 20) {
            return unit[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? "-" : "") + unit[n % 10];
        }

        if (n < 1000) {
            return (unit[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + int2str(n % 100)).trim();
        }

        if (n < 1000000) {
            return (int2str(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + int2str(n % 1000)).trim();
        }

        if (n < 1000000000) {
            return (int2str(n / 1000000) + " Million" + ((n % 10000000 != 0) ? " " : "") + int2str(n % 1000000)).trim();
        }

        return (int2str(n / 1000000000) + " Billion " + int2str(n % 1000000000)).trim();
    }
}
