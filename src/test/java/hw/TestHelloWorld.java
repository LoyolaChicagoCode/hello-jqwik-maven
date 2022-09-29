package hw;

import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class TestHelloWorld {

  final HelloWorld fixture = new HelloWorld();

  @Property
  boolean lengthOfEchoTwiceIsTwiceLengthOfArg(@ForAll final String aString) {
    return fixture.echoTwice(aString).length() == 2 * aString.length();
  }

  @Property
  boolean absoluteValueOfAllNumbersIsPositive(@ForAll final int anInteger) {
    return Math.abs(anInteger) >= 0;
  }

  @Property
  void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
      @ForAll final String string1, @ForAll final String string2) {
    final var conc = string1 + string2;
    assertTrue(conc.length() > string1.length());
    assertTrue(conc.length() > string2.length());
  }

  @Property
  boolean lengthOfConcatenatedStringIsGreaterThanLengthOfEachAsBoolean(
      @ForAll final String string1, @ForAll final String string2) {
    final var conc = string1 + string2;
    return conc.length() > string1.length() && conc.length() > string2.length();
  }

  @Example
  void squareRootOf16is4() {
    assertEquals(4.0, Math.sqrt(16), 0.01);
  }

  @Example
  boolean add1plu3is4() {
    return (1 + 3) == 4;
  }

  @Example
  void testHello1() {
    assertEquals("hello", fixture.echo("hello"));
  }

  @Example
  void testHello2() {
    assertEquals("", fixture.echo(""));
  }

  @Property
  boolean echoReturnsItsArgument(@ForAll final String s) {
    return fixture.echo(s).equals(s);
  }

  @Example
  void testHello3() {
    assertEquals(" ", fixture.echoTwice(""));
  }

  @Example
  void testHello4() {
    assertEquals("world world", fixture.echoTwice("world"));
  }

  @Property
  boolean echoTwiceReturnsItsArgumentTwice(@ForAll final String s) {
    return fixture.echoTwice(s).equals(s + " " + s);
  }

  @Property
  void inputOneWord(@ForAll @AlphaChars final String w) {
    final var sut = null; // word frequency distribution calculator
    final var input = List.of(w).iterator();
    final var result = sut.process(input);
    assertEquals(1, result.size());
    assertEquals(1 , result.get(w.length));
  }

  @Property
  void inputFiveEqualWords(@ForAll @AlphaChars final String w) {
    final var sut = null; // word frequency distribution calculator
    final var input = List.of(w, w, w, w, w).iterator();
    final var result = sut.process(input);
    assertEquals(1, result.size());
    assertEquals(5, result.get(w.length));
  }

  @Property
  void inpuNEqualWords(@ForAll @AlphaChars final String w, @ForAll @Positive final int n) {
    final var sut = null; // word frequency distribution calculator
    final var input = Collections.nCopies(n, w).iterator();
    final var result = sut.process(input);
    assertEquals(1, result.size());
    assertEquals(n, result.get(w.length));
  }

  @Property
  void inputArbitraryIterator(@ForAll final List<String> values) {
    final var sut = null; // word frequency distribution calculator
    final var input = values.iterator();
    final var size = values.size();
    final var result = sut.process(input);
    final var sum = // sum of all frequency values
    assertEquals(sum, size);
  }

}
