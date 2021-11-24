package com.github.tpgamesnl.z3gen.functions;

import com.github.tpgamesnl.z3gen.Declarable;
import com.github.tpgamesnl.z3gen.Writable;

import java.io.PrintWriter;

// TODO add function creation to library and builder
public abstract class Function implements Declarable {

    protected final String name;
    private final String returnType;
    private final String[] parameterTypes;

    public Function(String name, String returnType, String... parameterTypes) {
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    @Override
    public void writeDeclaration(PrintWriter writer) {
        writer.print("(declare-fun ");
        writer.print(name);
        writer.print(" (");
        for (int i = 0; i < parameterTypes.length; i++) {
            writer.print(parameterTypes[i]);
            if (i != parameterTypes.length - 1) {
                writer.print(" ");
            }
        }
        writer.print(") ");
        writer.print(returnType);
        writer.print(")");
        writer.println();
    }

    public abstract Writable call(Writable... arguments);

}
