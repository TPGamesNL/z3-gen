package com.github.tpgamesnl.z3gen.arithmetic;

import com.github.tpgamesnl.z3gen.Writable;
import com.github.tpgamesnl.z3gen.Builder;
import com.github.tpgamesnl.z3gen.predicates.Predicate;

public interface Arithmetic extends Writable {

    default Arithmetic add(Arithmetic arithmetic) {
        return Builder.add(this, arithmetic);
    }

    default Arithmetic subtract(Arithmetic arithmetic) {
        return Builder.subtract(this, arithmetic);
    }

    default Arithmetic sub(Arithmetic arithmetic) {
        return Builder.subtract(this, arithmetic);
    }

    default Arithmetic multiply(Arithmetic arithmetic) {
        return Builder.multiply(this, arithmetic);
    }

    default Arithmetic mult(Arithmetic arithmetic) {
        return Builder.multiply(this, arithmetic);
    }

    default Arithmetic divide(Arithmetic arithmetic) {
        return Builder.divide(this, arithmetic);
    }

    default Arithmetic div(Arithmetic arithmetic) {
        return Builder.divide(this, arithmetic);
    }

    default Predicate equals(Arithmetic arithmetic) {
        return Builder.equals(this, arithmetic);
    }

    default Predicate equ(Arithmetic arithmetic) {
        return Builder.equals(this, arithmetic);
    }

    default Predicate notEquals(Arithmetic arithmetic) {
        return Builder.notEquals(this, arithmetic);
    }

    default Predicate neq(Arithmetic arithmetic) {
        return Builder.notEquals(this, arithmetic);
    }

    default Predicate lessThan(Arithmetic arithmetic) {
        return Builder.lessThan(this, arithmetic);
    }

    default Predicate lss(Arithmetic arithmetic) {
        return Builder.lessThan(this, arithmetic);
    }

    default Predicate lessThanEquals(Arithmetic arithmetic) {
        return Builder.lessThanEquals(this, arithmetic);
    }

    default Predicate leq(Arithmetic arithmetic) {
        return Builder.lessThanEquals(this, arithmetic);
    }

    default Predicate greaterThan(Arithmetic arithmetic) {
        return Builder.greaterThan(this, arithmetic);
    }

    default Predicate gtr(Arithmetic arithmetic) {
        return Builder.greaterThan(this, arithmetic);
    }

    default Predicate greaterThanEquals(Arithmetic arithmetic) {
        return Builder.greaterThanEquals(this, arithmetic);
    }

    default Predicate geq(Arithmetic arithmetic) {
        return Builder.greaterThanEquals(this, arithmetic);
    }

    default Arithmetic increment() {
        return Builder.add(this, Builder.num(1));
    }

    default Arithmetic inc() {
        return Builder.add(this, Builder.num(1));
    }

    default Arithmetic decrement() {
        return Builder.sub(this, Builder.num(1));
    }

    default Arithmetic dec() {
        return Builder.sub(this, Builder.num(1));
    }

    default Arithmetic mult(long n) {
        return Builder.multiply(this, Builder.num(n));
    }

    default Arithmetic mult(double n) {
        return Builder.multiply(this, Builder.num(n));
    }

}
