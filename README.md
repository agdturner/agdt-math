# [agdt-java-math](https://github.com/agdturner/agdt-java-math)

## Description
A Java library with some generally useful mathematics functionality complimenting [Java Development Kit, version 15](https://openjdk.java.net/projects/jdk/15/) and [BigMath](https://github.com/eobermuhlner/big-math), including:
- Additional [fixed point arithmetic](https://en.wikipedia.org/wiki/Fixed-point_arithmetic) based on [BigInteger](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/math/BigInteger.html) and [BigDecimal](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/math/BigDecimal.html).
- Additional [arbitrary precision arithmetic](https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic) based on [BigRational](https://github.com/eobermuhlner/big-math/blob/master/ch.obermuhlner.math.big/src/main/java/ch/obermuhlner/math/big/BigRational.java) and [Math_BigRationalSqrt](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/Math_BigRationalSqrt.java) which deals with [surds](https://en.wikipedia.org/wiki/Nth_root) - specifically simplification of calculations involving square roots of rational numbers.
- [Math_Matrix_BR](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/matrices/Math_Matrix_BR.java) for processing matrices holding BigRational numbers.
- [Math_PrimeNumbers](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/primes/Math_PrimeNumbers.java) for processing and identifying prime numbers.

For [fixed point arithmetic](https://en.wikipedia.org/wiki/Fixed-point_arithmetic) functions that return BigDecimal numbers, the user specifies a minimum precision scale for the precision of the result where: a positive value gives the number of decimal places the result must be accurate to; and, a negative value gives a scale of unit to the left of the decimal point that the number must be accurate to. More accurate results may be provided, but the results provided are accurate at least to the minimum precision scale specified. If a result cannot be stored precisely as a BigDecimal, rounding is done using [RoundingMode.HALF_UP](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/math/RoundingMode.html#HALF_UP).

As the [openJDK](https://openjdk.java.net/) evolves, some of the functionality provided by this library may become redundant. This code is [modularised](https://en.wikipedia.org/wiki/Java_Platform_Module_System), an effort is being made to better document, test and [contribute](https://openjdk.java.net/contribute/) it. I also plan to extend it based on use case scenarios in an [agile](https://en.wikipedia.org/wiki/Agile_software_development) way.

[BigMath](https://github.com/eobermuhlner/big-math) has much similar functionality, but it is slightly different in general in that it focusses on users specifying a precision (rather than a scale), so whereas BigMath might provide an answer to a specified number of significant digits, this library aims to provide a result accurate to a specific scale (e.g 2 decimal places, e.g. the nearest thousand). BigMath has an extremely useful [BigRational](https://github.com/eobermuhlner/big-math/blob/master/ch.obermuhlner.math.big/src/main/java/ch/obermuhlner/math/big/BigRational.java) class that allows for a wide range and very detailed rational number storage. I discovered BigMath in the year 2020 as I began developing [agdt-java-vector3d](https://github.com/agdturner/agdt-java-vector3d) - a Euclidean geometry library. There is much that can be done to compare implementations and probably rationalise, optimise the code and perhaps combine efforts ultimately by [contributing to the development of openJDK](https://openjdk.java.net/contribute/).  , and some bespoke implementations for [logarithmic numbers](https://en.wikipedia.org/wiki/Logarithmic_number_system) and [symbolic computation](https://en.wikipedia.org/wiki/Symbolic_computation).  

## Latest versions
Developed and tested on [Java Development Kit, version 15](https://openjdk.java.net/projects/jdk/15/).
### Stable
```
<!-- https://mvnrepository.com/artifact/io.github.agdturner/agdt-java-math -->
<dependency>
    <groupId>io.github.agdturner</groupId>
    <artifactId>agdt-java-math</artifactId>
    <version>1.7</version>
</dependency>
```
A stable JAR is available:
https://repo1.maven.org/maven2/io/github/agdturner/agdt-java-math/1.7/agdt-java-math-1.7.jar

### Unstable development version
```
<!-- https://mvnrepository.com/artifact/io.github.agdturner/agdt-java-math -->
<dependency>
    <groupId>io.github.agdturner</groupId>
    <artifactId>agdt-java-math</artifactId>
    <version>1.8-SNAPSHOT</version>
</dependency>
```
[//]: # (Move to version history section if/when a new version and summary are added)
New to 1.8-SNAPSHOT:
- [Math_Matrix_BR](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/matrices/Math_Matrix_BR.java) for processing matrices holding BigRational numbers;
- [Math_BigRationalSqrt](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/Math_BigRationalSqrt.java)

## Development plans/ideas
- Do some computational comparison with [BigMath](https://github.com/eobermuhlner/big-math).
- Take steps towards [contributing code to the openJDK](https://openjdk.java.net/contribute/).
- Compare Math_BigDecimal.sqrt(BigDecimal, int, RoundingMode) with BigDecimal.sqrt(MathContext) and BigDecimalMath.sqrt()
- Generalise [Math_BigRationalSqrt](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/Math_BigRationalSqrt.java) for [nth roots](https://en.wikipedia.org/wiki/Nth_root).
- Develop functionality for processing complex numbers where the real and imaginary parts are stored as BigRational or [Math_BigRationalSqrt](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/Math_BigRationalSqrt.java) based on [Math_Complex_double](https://github.com/agdturner/agdt-java-math/blob/master/src/main/java/uk/ac/leeds/ccg/math/Math_Complex_double.java).
- For exponentiation and logarithms, review the implementation of [logarithmic numbers](https://en.wikipedia.org/wiki/Logarithmic_number_system).
- Generally improve the coverage of unit tests and review code.
- Consider developing more functionality for [symbolic computation](https://en.wikipedia.org/wiki/Symbolic_computation) so as to simplify more prior to computation.

## Development history
- Early versions of this code were bundled together with lots of other code developed for academic research projects. A separation of code produced [agdt-java-generic](https://github.com/agdturner/agdt-java-generic) a generic higher level library upon which this depends. agdt-java-generic has some basic functionality for dealing with numbers. From version 1.7 an attempt is being made to provide a summary of changes for each version released on Maven Central.

## Contributions
- Welcome.

## LICENCE
- APACHE LICENSE, VERSION 2.0: https://www.apache.org/licenses/LICENSE-2.0

## Acknowledgements
- The [University of Leeds](http://www.leeds.ac.uk) and succession of externally funded research grants have supported the development of this library.
- Thank you to all Java developers that contribute to the [openJDK](https://openjdk.java.net/) and develop other useful libraries out in the wild that have inspired me. In particular, thank you Eric for the [BigMath](https://github.com/eobermuhlner/big-math) library.
- Thank you to all those that help maintain and contribute usefully to:
-- [Wikimedia](https://www.wikimedia.org/) projects, in particular [en.wikipedia](https://en.wikipedia.org/wiki/Main_Page)
-- [StackExchange](https://stackexchange.com), in particular [StackOverflow](https://stackoverflow.com/) and (http://math.stackexchange.com/).
-- The information on the Web that has helped me develop this library. I have made an effort to keep links to the content that I have used in the documentation.
- If you think you are owed an acknowledgement, please let me know.
