package com.github.tpgamesnl.z3gen;

import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;
import com.github.tpgamesnl.z3gen.arithmetic.SimpleArithmetic;
import com.github.tpgamesnl.z3gen.predicates.Predicate;
import com.github.tpgamesnl.z3gen.predicates.SimplePredicate;

public class Library {

    public static class And extends SimplePredicate {
        public And(Predicate... predicates) {
            super("and", predicates);
        }
    }

    public static class Or extends SimplePredicate {
        public Or(Predicate... predicates) {
            super("or", predicates);
        }
    }

    public static class Not extends SimplePredicate {
        public Not(Predicate predicate) {
            super("not", predicate);
        }
    }

    public static class Implies extends SimplePredicate {
        public Implies(Predicate first, Predicate second) {
            super("implies", first, second);
        }
    }

    public static class Iff extends SimplePredicate {
        public Iff(Predicate first, Predicate second) {
            super("iff", first, second);
        }
    }

    public static class Add extends SimpleArithmetic {
        public Add(Arithmetic... arithmetics) {
            super("+", arithmetics);
        }
    }

    public static class Subtract extends SimpleArithmetic {
        public Subtract(Arithmetic... arithmetics) {
            super("-", arithmetics);
        }
    }

    public static class Multiply extends SimpleArithmetic {
        public Multiply(Arithmetic... arithmetics) {
            super("*", arithmetics);
        }
    }

    public static class Divide extends SimpleArithmetic {
        public Divide(Arithmetic... arithmetics) {
            super("/", arithmetics);
        }
    }

    public static class Equ extends SimplePredicate {
        public Equ(Arithmetic... arithmetics) {
            super("=", arithmetics);
        }
    }

    public static class Neq extends SimplePredicate {
        public Neq(Arithmetic... arithmetics) {
            super("not", new Equ(arithmetics));
        }
    }

    public static class Lss extends SimplePredicate {
        public Lss(Arithmetic first, Arithmetic second) {
            super("<", first, second);
        }
    }

    public static class Leq extends SimplePredicate {
        public Leq(Arithmetic first, Arithmetic second) {
            super("<=", first, second);
        }
    }

    public static class Gtr extends SimplePredicate {
        public Gtr(Arithmetic first, Arithmetic second) {
            super(">", first, second);
        }
    }

    public static class Geq extends SimplePredicate {
        public Geq(Arithmetic first, Arithmetic second) {
            super(">=", first, second);
        }
    }

    public static class Ite extends SimpleArithmetic {
        public Ite(Predicate predicate, Arithmetic trueCase, Arithmetic falseCase) {
            super("ite", predicate, trueCase, falseCase);
        }
    }

    public static class Distinct extends SimplePredicate {
        public Distinct(Arithmetic... arithmetics) {
            super("distinct", arithmetics);
        }
    }

}
