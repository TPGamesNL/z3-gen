### Approximating the square root of two

This example approximates the square root of two, by asserting that `a * a = b` and `1.999 < b < 2.001`.
```java
import com.github.tpgamesnl.z3gen.ProgramBuilder;
import com.github.tpgamesnl.z3gen.variables.RealVariable;

import java.io.IOException;

import static com.github.tpgamesnl.z3gen.Builder.*;

public class SquareRootApproximation {

    public static void main(String[] args) throws IOException {
        // Create two variables of type Real (number that is not necessarily an integer), a and b
        RealVariable a = realVar("a");
        RealVariable b = realVar("b");

        ProgramBuilder programBuilder = new ProgramBuilder()
                .addDeclarable(a, b)
                // Add the first assertion, b = a * a
                .addAssert(b.equ(a.mult(a)))
                // Add the second assertion, 1.999 < b < 2.001 (b > 1.999 and b < 2.001)
                .addAssert(and(b.gtr(num(1.999)), b.lss(num(2.001))));
        
        programBuilder.run("test.txt");
    }

}
```

Output:
```
sat
(
  (define-fun a () Real
    (/ 181.0 128.0))
  (define-fun b () Real
    (/ 32761.0 16384.0))
)
```
in other words: a = 181.0 / 128.0 = 1.4140625