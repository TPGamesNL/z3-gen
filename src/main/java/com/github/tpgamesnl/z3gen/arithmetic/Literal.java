package com.github.tpgamesnl.z3gen.arithmetic;

public class Literal extends RawArithmetic {

    public Literal(long number) {
        super("" + number);
    }

    public Literal(double number) {
        super("" + number);
    }

}
