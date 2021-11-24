package com.github.tpgamesnl.z3gen.predicates;

import java.io.PrintWriter;

public class RawPredicate implements Predicate {

    private final String string;

    public RawPredicate(String string) {
        this.string = string;
    }

    @Override
    public void write(PrintWriter writer) {
        writer.write(string);
    }

}
