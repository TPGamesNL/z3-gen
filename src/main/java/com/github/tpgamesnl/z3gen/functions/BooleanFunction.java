package com.github.tpgamesnl.z3gen.functions;

import com.github.tpgamesnl.z3gen.Writable;
import com.github.tpgamesnl.z3gen.predicates.Predicate;
import com.github.tpgamesnl.z3gen.predicates.SimplePredicate;

public class BooleanFunction extends Function {

    public BooleanFunction(String name, String returnType, String... parameterTypes) {
        super(name, returnType, parameterTypes);
    }

    @Override
    public Predicate call(Writable... arguments) {
        return new SimplePredicate(name, arguments);
    }

}
