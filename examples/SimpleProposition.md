### A simple propositional formula

![](https://i.imgur.com/t5cojKX.png)

Java code:
```java
import com.github.tpgamesnl.z3gen.ProgramBuilder;
import com.github.tpgamesnl.z3gen.variables.BoolVariable;

import java.io.IOException;

// I recommend adding this static import to your Java files, as it makes the code shorter and more readable
import static com.github.tpgamesnl.z3gen.Builder.*;

public class SimpleProposition {

    public static void main(String[] args) throws IOException {
        // Create four boolean variables, a, b, c and d
        BoolVariable a = boolVar("a");
        BoolVariable b = boolVar("b");
        BoolVariable c = boolVar("c");
        BoolVariable d = boolVar("d");

        // Create a new program builder
        ProgramBuilder programBuilder = new ProgramBuilder()
                // Add the declarations for our variables
                .addDeclarable(a, b, c, d)
                // Add the whole propositional formula
                .addAssert(and(a.iff(d.and(b)), c.implies(b), not(or(a, b, d.not())), or(not(a).and(c), d)));

        // Write our program in prop.txt and run it
        programBuilder.run("prop.txt");
        // You can also use programBuilder.write("test.txt"),
        //  to write the program to the file without running it
    }

}
```

When running the program, we get this output:
```
sat
(
  (define-fun c () Bool
    false)
  (define-fun a () Bool
    false)
  (define-fun b () Bool
    false)
  (define-fun d () Bool
    true)
)
```

The written SMT-LIB code is as follows:
```
(declare-const a Bool)
(declare-const b Bool)
(declare-const c Bool)
(declare-const d Bool)
(assert (and (iff a (and d b)) (implies c b) (not (or a b (not d))) (or (and (not a) c) d)))
(check-sat)
(get-model)
```