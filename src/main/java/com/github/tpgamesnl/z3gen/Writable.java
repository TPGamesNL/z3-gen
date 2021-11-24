package com.github.tpgamesnl.z3gen;

import java.io.PrintWriter;
import java.io.StringWriter;

public interface Writable {

    void write(PrintWriter writer);

    default String asString() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        write(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

}
