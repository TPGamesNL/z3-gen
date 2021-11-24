package com.github.tpgamesnl.z3gen.arithmetic;

import com.github.tpgamesnl.z3gen.Writable;

import java.io.PrintWriter;

public class SimpleArithmetic implements Arithmetic {

    private final String prefix;
    private final Writable[] writables;

    public SimpleArithmetic(String prefix, Writable... writables) {
        this.prefix = prefix;
        this.writables = writables;
    }

    @Override
    public void write(PrintWriter writer) {
        writer.write("(" + prefix);
        for (Writable writable : writables) {
            writer.write(" ");
            writable.write(writer);
        }
        writer.write(")");
    }

}
