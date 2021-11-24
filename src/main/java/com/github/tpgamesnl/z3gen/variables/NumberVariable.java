package com.github.tpgamesnl.z3gen.variables;

import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;

public abstract class NumberVariable extends Variable implements Arithmetic {

    public NumberVariable(String typeName, String name) {
        super(typeName, name);
    }

}
