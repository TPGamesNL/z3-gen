## An example with loops

Create an n * n square where each cell contains a number greater than 5, and all cells in a row contain unique values.

```java
import com.github.tpgamesnl.z3gen.ProgramBuilder;
import com.github.tpgamesnl.z3gen.arithmetic.Arithmetic;
import com.github.tpgamesnl.z3gen.functions.NumericFunction;
import com.github.tpgamesnl.z3gen.predicates.Predicate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.tpgamesnl.z3gen.Builder.*;

public class LoopExample {

    public static void main(String[] args) throws IOException {
        // Create a function named F from (Int, Int) to (Int)
        NumericFunction f = new NumericFunction("F", "Int", "Int Int");

        int n = 3;

        // Create a list of predicates.
        //  A Predicate is any boolean value, such as a propositional formula, a Bool variable or a Bool function call.
        List<Predicate> predicates = new ArrayList<>();

        // Loop over all cells (rows & columns)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // f(i, j) > 5
                Predicate predicate = f.call(num(i), num(j)).gtr(num(5));

                // add the predicate to the list
                predicates.add(predicate);
            }
        }

        // Loop over all rows
        for (int i = 1; i <= n; i++) {
            // Creates a list of arithmetics.
            //  An Arithmetic is any numerical value, such as a number (created by num(x)), a mathematical formula, a numerical variable or a numerical function call.
            List<Arithmetic> calls = new ArrayList<>();

            // Loop over the columns
            for (int j = 1; j <= n; j++) {
                // f(i, j)
                Arithmetic call = f.call(num(i), num(j));
                // add the function call to the list
                calls.add(call);
            }

            // Create an array of the Arithmetics
            Arithmetic[] callArray = calls.toArray(new Arithmetic[0]);
            // assert all values in a row are distinct
            predicates.add(distinct(callArray));
        }

        ProgramBuilder programBuilder = new ProgramBuilder()
                // declare the function
                .addDeclarable(f)
                // Create an array of the predicates, and add assert them.
                .addAssert(predicates.toArray(new Predicate[0]));

        programBuilder.run("loop.txt");
    }

}
```

The output:
```
sat
(
  (define-fun F ((x!0 Int) (x!1 Int)) Int
    (ite (and (= x!0 1) (= x!1 2)) 7
    (ite (and (= x!0 1) (= x!1 3)) 8
    (ite (and (= x!0 2) (= x!1 2)) 7
    (ite (and (= x!0 2) (= x!1 3)) 8
    (ite (and (= x!0 3) (= x!1 2)) 7
    (ite (and (= x!0 3) (= x!1 3)) 8
      6)))))))
)
```
It's a bit difficult to read the model from this, 
but you can see that each cell with j = 1 got a 6, j = 2 got 7 and j = 3 got 8.

The following SMT-LIB code was written to the file:
```
(declare-fun F (Int Int) Int)
(assert (> (F 1 1) 5))
(assert (> (F 1 2) 5))
(assert (> (F 1 3) 5))
(assert (> (F 2 1) 5))
(assert (> (F 2 2) 5))
(assert (> (F 2 3) 5))
(assert (> (F 3 1) 5))
(assert (> (F 3 2) 5))
(assert (> (F 3 3) 5))
(assert (distinct (F 1 1) (F 1 2) (F 1 3)))
(assert (distinct (F 2 1) (F 2 2) (F 2 3)))
(assert (distinct (F 3 1) (F 3 2) (F 3 3)))
(check-sat)
(get-model)
```