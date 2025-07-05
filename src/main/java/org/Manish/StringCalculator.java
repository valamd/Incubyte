package org.Manish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.lang.Integer.parseInt;
public class StringCalculator {
    private static final int MAX = 1000;
    private String delimiter = ",|\\n";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");
            String delimiterPart = input.substring(2, delimiterEnd);
            delimiter = build_DelimiterRegex(delimiterPart);
            input = input.substring(delimiterEnd + 1);
        }

        String[] tokens = input.split(delimiter);
        check_Negatives(tokens);
        return calculate_Sum(tokens);
    }

    private String build_DelimiterRegex(String delimiterPart) {
        if (delimiterPart.startsWith("[")) {
            List<String> delimiters = new ArrayList<>();
            int i = 0;
            while (i < delimiterPart.length()) {
                int start = delimiterPart.indexOf("[", i);
                int end = delimiterPart.indexOf("]", i);
                if (start == -1 || end == -1) break;
                String raw = delimiterPart.substring(start + 1, end);
                delimiters.add(java.util.regex.Pattern.quote(raw));
                i = end + 1;
            }
            return String.join("|", delimiters);
        } else {
            return java.util.regex.Pattern.quote(delimiterPart);
        }
    }

    private void check_Negatives(String[] tokens) {
        List<String> negatives = new ArrayList<>();
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                negatives.add(token);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(", ", negatives));
        }
    }


    private int calculate_Sum(String[] tokens) {
        HashSet<Integer> seen = new HashSet<>();
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num <= MAX && seen.add(num)) {
                sum += num;
            }
        }
        return sum;
    }
}
