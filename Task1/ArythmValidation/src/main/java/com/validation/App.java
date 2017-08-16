package com.validation;

import java.util.*;

public class App {

    private static Map<Character, Character> curvesMap;

    public static void main(String[] args) {

        System.out.println(isValidExpr("()"));

    }


    public static String isValidExpr(String expr) {
        initMap();

        if (expr.length() == 0) {
            return "Верно";
        }

        LinkedList<Character> stack = new LinkedList();
        Set<Map.Entry<Character, Character>> entrySet = curvesMap.entrySet();
        char ch1 = 0;
        char ch2 = 0;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (curvesMap.containsKey(ch)) {
                stack.add(ch);
            }

            if (!stack.isEmpty()) {
                ch1 = stack.getLast();
            }

            if (curvesMap.containsValue(ch)) {

                if (stack.isEmpty()) {
                    return "Не верно";
                }

                for (Map.Entry<Character, Character> pair : entrySet) {
                    if (ch == pair.getValue()) {
                        ch2 = pair.getKey();
                    }
                }

                if (ch1 == ch2) {
                    stack.removeLast();
                }
            }
        }

        if (stack.isEmpty()){
            return "Верно";
        } else {
            return "Не верно";
        }
    }

    private static void initMap() {
        curvesMap = new HashMap<Character, Character>();
        curvesMap.put('(', ')');
        curvesMap.put('{', '}');
        curvesMap.put('[', ']');
    }
}
