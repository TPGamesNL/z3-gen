package com.github.tpgamesnl.z3gen;

import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;
import com.github.tpgamesnl.z3gen.predicates.Predicate;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramBuilder {

    private final List<Declarable> declarables = new ArrayList<>();
    private final List<String> statements = new ArrayList<>();

    public ProgramBuilder() { }

    public ProgramBuilder addDeclarable(Declarable... declarables) {
        this.declarables.addAll(Arrays.asList(declarables));
        return this;
    }

    public ProgramBuilder addAssert(Predicate... asserts) {
        for (Predicate predicate : asserts) {
            addStatement("(assert " + predicate.asString() + ")");
        }
        return this;
    }

    public ProgramBuilder maximize(Arithmetic... arithmetics) {
        for (Arithmetic arithmetic : arithmetics) {
            addStatement("(maximize " + arithmetic.asString() + ")");
        }
        return this;
    }

    public ProgramBuilder minimize(Arithmetic... arithmetics) {
        for (Arithmetic arithmetic : arithmetics) {
            addStatement("(minimize " + arithmetic.asString() + ")");
        }
        return this;
    }

    public ProgramBuilder addStatement(String statement) {
        this.statements.add(statement);
        return this;
    }

    public void write(PrintWriter writer) throws IOException {
        for (Declarable declarable : declarables) {
            declarable.writeDeclaration(writer);
        }
        for (String statement : statements) {
            writer.println(statement);
        }
        writer.println("(check-sat)");
        writer.println("(get-model)");
    }

    public void write(File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(file);
        write(printWriter);
        printWriter.close();
    }

    public void write(String fileName) throws IOException {
        write(new File(fileName));
    }

    public void run(String fileName) throws IOException {
        write(fileName);
        Process process = new ProcessBuilder("z3", fileName).inheritIO().start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
