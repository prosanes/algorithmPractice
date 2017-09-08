package com.prosanes.stringContainsStringPermutation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toMatch = scanner.next();
        String big = scanner.next();

        ArrayList<Integer> matches = new Solver(toMatch, big).solve();
        matches.forEach(i-> {
            for (int t = 0; t < i; t++)
                System.out.print(" ");
            System.out.println(
                    big.substring(i,
                        i + toMatch.length())
            );
        });
    }
}
