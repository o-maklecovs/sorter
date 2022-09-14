package com.sparta.Olegs.utils;

import java.util.Random;

public class RandArrayBuilder {

    public int[] build(int size) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = rand.nextInt(size);
        return result;
    }
}
