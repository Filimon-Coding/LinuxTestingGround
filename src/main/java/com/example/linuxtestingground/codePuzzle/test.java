package com.example.linuxtestingground.codePuzzle;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();

        r1 = 32;
        r2 = 47;

        while (r1 != r2){


            long lastDig = (r1 % 10); // 2

            long midDig = ((r1 /10) % 10); // 3


            r1 = lastDig  + midDig + r1;  // 37
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(r1);
    }
}