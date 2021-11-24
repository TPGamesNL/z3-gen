package com.github.tpgamesnl.z3gen.variables;

import com.github.tpgamesnl.z3gen.predicates.Predicate;

import java.io.PrintWriter;

public class BoolVariable extends Variable implements Predicate {

    public BoolVariable(String name) {
        super("Bool", name);
    }

    @Override
    public void write(PrintWriter writer) {
        writer.write(name);
    }

}
