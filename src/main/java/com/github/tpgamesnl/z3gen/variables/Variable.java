package com.github.tpgamesnl.z3gen.variables;

import com.github.tpgamesnl.z3gen.Declarable;
import com.github.tpgamesnl.z3gen.Writable;

import java.io.PrintWriter;

public abstract class Variable implements Writable, Declarable {

    private final String typeName;
    protected final String name;

    public Variable(String typeName, String name) {
        this.typeName = typeName;
        this.name = name;
    }

    @Override
    public void write(PrintWriter writer) {
        writer.print(name);
    }

    @Override
    public void writeDeclaration(PrintWriter writer) {
        writer.println("(declare-const " + name + " " + typeName + ")");
    }

}
