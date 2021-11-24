package com.github.tpgamesnl.z3gen.arithmetic;

import java.io.PrintWriter;

public class RawArithmetic implements Arithmetic {

    private final String string;

    public RawArithmetic(String string) {
        this.string = string;
    }

    @Override
    public void write(PrintWriter writer) {
        writer.write(string);
    }

}
