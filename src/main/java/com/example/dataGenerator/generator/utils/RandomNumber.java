package com.example.dataGenerator.generator.utils;

import java.util.Random;

public class RandomNumber {
    public static int getRandomNumber(int maxIndex){
        Random random = new Random();
        return random.nextInt(maxIndex);
    }
}
