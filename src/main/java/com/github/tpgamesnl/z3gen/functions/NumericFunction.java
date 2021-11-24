package com.github.tpgamesnl.z3gen.functions;

import com.github.tpgamesnl.z3gen.Writable;
import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;
import com.github.tpgamesnl.z3gen.arithmetic.SimpleArithmetic;

public class NumericFunction extends Function {

    public NumericFunction(String name, String returnType, String... parameterTypes) {
        super(name, returnType, parameterTypes);
    }

    @Override
    public Arithmetic call(Writable... arguments) {
        return new SimpleArithmetic(name, arguments);
    }

}
