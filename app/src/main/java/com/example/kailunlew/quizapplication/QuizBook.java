package com.example.kailunlew.quizapplication;

/**
 * Created by kailunlew on 01/12/2017.
 */

public class QuizBook {

    public static String[] questions = new String []{
            "A pentagon is a 5-sided polygon.",
            "A Heptagon is a 4-sided polygon.",
            "The area of rectangle is 32cm.",
            "The are of circle is 5m.",
            "The formula of circle area is (π x r²).",
            "The formula of triangle area is (1/2 x base x height).",
            "The diameter of circle is 6cm.",
            "The volume of rectangle is 120cm³.",
            "The volume of cylinder is 942cm³."

    };

    public static int[] images = new int[]{
            R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
            R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,

    };


    public static boolean[] answers = new boolean[]{
            true, false, false, false, true, true, false, true, true
    };
}
