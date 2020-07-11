package com.vlad;

public class Fact {

    final int[] code;
    final int correctlyPlaced;
    final int incorrectlyPlaced;

    public Fact(int[] code, int correctlyPlaced, int incorrectlyPlaced) {
        this.code = code;
        this.correctlyPlaced = correctlyPlaced;
        this.incorrectlyPlaced = incorrectlyPlaced;
    }
}
