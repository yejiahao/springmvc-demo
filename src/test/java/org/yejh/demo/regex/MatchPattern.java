package org.yejh.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPattern {
    public static String str = "I'm a    person lives in GuangZhou.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("wordCount: " + count);
    }
}
