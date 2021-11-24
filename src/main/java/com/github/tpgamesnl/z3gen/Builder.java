package com.github.tpgamesnl.z3gen;

import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;
import com.github.tpgamesnl.z3gen.arithmetic.Literal;
import com.github.tpgamesnl.z3gen.predicates.Predicate;
import com.github.tpgamesnl.z3gen.variables.*;

public class Builder {

    public static Predicate and(Predicate... predicates) {
        return new Library.And(predicates);
    }

    public static Predicate or(Predicate... predicates) {
        return new Library.Or(predicates);
    }

    public static Predicate not(Predicate predicate) {
        return new Library.Not(predicate);
    }

    public static Predicate implies(Predicate first, Predicate second) {
        return new Library.Implies(first, second);
    }

    public static Predicate iff(Predicate first, Predicate second) {
        return new Library.Iff(first, second);
    }

    public static Arithmetic add(Arithmetic... arithmetics) {
        return new Library.Add(arithmetics);
    }

    public static Arithmetic subtract(Arithmetic... arithmetics) {
        return new Library.Subtract(arithmetics);
    }

    public static Arithmetic sub(Arithmetic... arithmetics) {
        return subtract(arithmetics);
    }

    public static Arithmetic multiply(Arithmetic... arithmetics) {
        return new Library.Multiply(arithmetics);
    }

    public static Arithmetic mult(Arithmetic... arithmetics) {
        return multiply(arithmetics);
    }

    public static Arithmetic divide(Arithmetic... arithmetics) {
        return new Library.Divide(arithmetics);
    }

    public static Arithmetic div(Arithmetic... arithmetics) {
        return divide(arithmetics);
    }

    public static Predicate equals(Arithmetic... arithmetics) {
        return new Library.Equ(arithmetics);
    }

    public static Predicate equ(Arithmetic... arithmetics) {
        return equals(arithmetics);
    }

    public static Predicate notEquals(Arithmetic... arithmetic) {
        return new Library.Neq(arithmetic);
    }

    public static Predicate neq(Arithmetic... arithmetics) {
        return notEquals(arithmetics);
    }

    public static Predicate lessThan(Arithmetic first, Arithmetic second) {
        return new Library.Lss(first, second);
    }

    public static Predicate lss(Arithmetic first, Arithmetic second) {
        return lessThan(first, second);
    }

    public static Predicate lessThanEquals(Arithmetic first, Arithmetic second) {
        return new Library.Leq(first, second);
    }

    public static Predicate leq(Arithmetic first, Arithmetic second) {
        return lessThanEquals(first, second);
    }

    public static Predicate greaterThan(Arithmetic first, Arithmetic second) {
        return new Library.Gtr(first, second);
    }

    public static Predicate gtr(Arithmetic first, Arithmetic second) {
        return greaterThan(first, second);
    }

    public static Predicate greaterThanEquals(Arithmetic first, Arithmetic second) {
        return new Library.Geq(first, second);
    }

    public static Predicate geq(Arithmetic first, Arithmetic second) {
        return greaterThanEquals(first, second);
    }

    public static IntVariable intVar(String name) {
        return new IntVariable(name);
    }

    public static RealVariable realVar(String name) {
        return new RealVariable(name);
    }

    public static BoolVariable boolVar(String name) {
        return new BoolVariable(name);
    }

    public static Arithmetic literal(long n) {
        return new Literal(n);
    }

    public static Arithmetic literal(double n) {
        return new Literal(n);
    }

    public static Arithmetic lit(long n) {
        return literal(n);
    }

    public static Arithmetic lit(double n) {
        return literal(n);
    }

    public static Arithmetic number(long n) {
        return literal(n);
    }

    public static Arithmetic number(double n) {
        return literal(n);
    }

    public static Arithmetic num(long n) {
        return literal(n);
    }

    public static Arithmetic num(double n) {
        return literal(n);
    }

    public static Arithmetic ite(Predicate predicate, Arithmetic trueCase, Arithmetic falseCase) {
        return new Library.Ite(predicate, trueCase, falseCase);
    }

    public static Predicate distinct(Arithmetic... arithmetics) {
        return new Library.Distinct(arithmetics);
    }

}
