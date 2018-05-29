package com.ravi.travel.budget_travel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {int x = 10;


    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";
    public static void main(String[] args)
    {


        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();;
    }


}
