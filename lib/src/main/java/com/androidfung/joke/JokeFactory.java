package com.androidfung.joke;

import java.util.Random;

public class JokeFactory {

    private static final String[] JOKES = {"What's the best thing about Switzerland?\nI don't know, but the flag is a big plus.",
            "I invented a new word!\nPlagiarism!"};



    public static String getRandomJoke(){
        int pos = new Random().nextInt(JOKES.length);

        return JOKES[pos];
    }

}
