package com.github.tpgamesnl.z3gen.predicates;

import com.github.tpgamesnl.z3gen.Writable;

import java.io.PrintWriter;

public class SimplePredicate implements Predicate {

    private final String prefix;
    private final Writable[] writables;

    public SimplePredicate(String prefix, Writable... writables) {
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
