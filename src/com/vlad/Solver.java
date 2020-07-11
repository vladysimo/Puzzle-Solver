package com.vlad;

import java.util.Set;

public class Solver {

    public static void solve(int[] partial_solution, Fact[] facts, Set<Integer> digits, int k) {

       if (k == partial_solution.length) {
           if (validate(partial_solution, facts)) {
               System.out.println("Found something");
               for (int digit : partial_solution) {
                   System.out.print(digit + " ");
               }
               System.out.println();
           }
           return;
       }

       for (int digit : digits) {
           partial_solution[k] = digit;
           solve(partial_solution, facts, digits, k + 1);
           partial_solution[k] = -1;
       }
    }

    public static boolean validate(int[] partial_solution, Fact[] facts) {

        for (Fact fact : facts) {

            int correctlyPlaced = 0;
            int incorrectlyPlace = 0;
            for (int i = 0; i < fact.code.length; i++) {
                if (fact.code[i] == partial_solution[i]) {
                    correctlyPlaced++;
                }
                for (int j = 0; j < partial_solution.length; j++) {
                    if (i != j && fact.code[i] == partial_solution[j]) {
                        incorrectlyPlace++;
                    }
                }
            }

            if (correctlyPlaced != fact.correctlyPlaced || incorrectlyPlace != fact.incorrectlyPlaced) {
                return false;
            }
        }

        return true;
    }
}
