# z3-gen

A simple Java library for generating z3 / SMT-LIB code.

The library contains only a small portion of z3's features, and is not fully documented.

Created for the course Applied Logic, 2ITX0.

## Getting started

1. Download the z3-gen.jar file from the latest [release](https://github.com/TPGamesNL/z3-gen/releases)
2. Add the z3-gen.jar file to your IDE (for VSCode, open a folder in your IDE, go to the File Explorer on the left side and expand Java Project, and click + next to Referenced Libraries and select the jar).
   1. For VSCode: open a folder in your IDE
   2. Open the File Explorer tab on the left
   3. Expand 'Java Projects'
   4. Expand the project to add it to (there's probably only one)
   5. Click the + next to Referenced Libraries
   6. Select the z3-gen.jar file
3. Take a look at the examples below, and try them out and play around with them to see how this library works.

## Examples
 
Check out a few examples, I recommend going over them in this order, in increasing difficulty:
1. [A simple proposition](examples/SimpleProposition.md)
2. [Approximating the square root of two](examples/SquareRootApproximation.md) 
3. [An example with loops](examples/LoopExample.md)
