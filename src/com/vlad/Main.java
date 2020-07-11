package com.vlad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static final int CODE_LENGTH = 4;

    public static void main(String[] args) throws FileNotFoundException {

        final Scanner input = new Scanner(new File("resources/input.txt"));
        final LinkedList<Fact> facts = new LinkedList<>();
        final Set<Integer> digits = new HashSet<>();
        while (input.hasNext()) {
            final char[] chars = input.next().toCharArray();
            final int[] code = new int[CODE_LENGTH];
            for(int i = 0; i < code.length; i++)
            {
                try {
                    code[i] = chars[i] - 48;
                    digits.add(code[i]);
                } catch (NumberFormatException nfe) {
                    //Not an integer
                }
            }
            final int correctlyPlaced = input.nextInt();
            final int incorrectlyPlaced = input.nextInt();
            if (correctlyPlaced > 0) {
                facts.addFirst(new Fact(code, correctlyPlaced, incorrectlyPlaced));
            }
            if (incorrectlyPlaced > 0) {
                facts.addLast(new Fact(code, correctlyPlaced, incorrectlyPlaced));
            }
        }
        Fact[] factsArray = new Fact[facts.size()];
        factsArray = facts.toArray(factsArray);

        final int[] partialSolution = new int[CODE_LENGTH];
        Arrays.fill(partialSolution, -1);

        Solver.solve(partialSolution, factsArray, digits, 0);
    }
}
