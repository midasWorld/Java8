package com.java.whyjava8.class01;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class WhyJava8 {
    public void whyJava() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Before
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            if (i != numbers.size() - 1) {
                stringBuilder.append(" : ");
            }
        }
        System.out.println("Before : " + stringBuilder);

        // After
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));
        System.out.println("After : " + result);
    }
}
