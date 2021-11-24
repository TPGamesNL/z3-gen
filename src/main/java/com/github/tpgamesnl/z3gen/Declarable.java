package com.github.tpgamesnl.z3gen;

import java.io.IOException;
import java.io.PrintWriter;

public interface Declarable {

    void writeDeclaration(PrintWriter writer) throws IOException;

}
