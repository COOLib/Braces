package com.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {

    private List<String> trueList;
    private List<String> falseList;

    @Before
    public void initAndFill() {
        trueList = new ArrayList<String>();
        trueList.addAll(Arrays.asList("", "()", "()()", "(({}))", "{([])}", "{()}[]","5-4", "(4)-4",
                                      "(7+3)(9)", "(43-({43}+564))", "{([]-34)+45}", "{()3}[]"));
        falseList = new ArrayList<String>();
        falseList.addAll(Arrays.asList("))", "(()", "{[}", "())", "((", ")("));
    }


    @Test
    public void testApp() {

        for (String s : trueList) {
            assertEquals("Верно", App.isValidExpr(s));
        }

        for (String s : falseList) {
            assertEquals("Не верно", App.isValidExpr(s));
        }
    }
}
