package com.github.tpgamesnl.z3gen.predicates;

import com.github.tpgamesnl.z3gen.Builder;
import com.github.tpgamesnl.z3gen.Writable;
import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;

public interface Predicate extends Writable {

    default Predicate and(Predicate predicate) {
        return Builder.and(this, predicate);
    }

    default Predicate or(Predicate predicate) {
        return Builder.or(this, predicate);
    }

    default Predicate not() {
        return Builder.not(this);
    }

    default Predicate implies(Predicate predicate) {
        return Builder.implies(this, predicate);
    }

    default Predicate iff(Predicate predicate) {
        return Builder.iff(this, predicate);
    }

    default Arithmetic toInt() {
        return Builder.ite(this, Builder.num(1), Builder.num(0));
    }

}
