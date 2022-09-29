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
    return fixture.echoTwice(aString).length() == 2 * aString.length() + 1;
  }

  @Property
  boolean absoluteValueOfAllNumbersIsPositive(@ForAll @IntRange(min = Integer.MIN_VALUE + 1, max = Integer.MAX_VALUE) final int anInteger) {
    return Math.abs(anInteger) >= 0;
  }

  @Property
  void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
      @ForAll final String string1, @ForAll final String string2) {
    final var conc = string1 + string2;
    assertTrue(conc.length() >= string1.length());
    assertTrue(conc.length() >= string2.length());
  }

  @Property
  boolean lengthOfConcatenatedStringIsGreaterThanLengthOfEachAsBoolean(
      @ForAll final String string1, @ForAll final String string2) {
    final var conc = string1 + string2;
    return conc.length() >= string1.length() && conc.length() >= string2.length();
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
    final var input = List.of(w);
    assertEquals(1, input.size());
    assertEquals(w, input.get(0));
  }

  @Property
  void inputFiveEqualWords(@ForAll @AlphaChars final String w) {
    final var input = List.of(w, w, w, w, w);
    assertEquals(5, input.size());
    assertEquals(w, input.get(4));
  }

  @Property
  void inputNEqualWords(@ForAll @AlphaChars final String w, @ForAll @Positive final int n) {
    final var input = Collections.nCopies(n, w);
    assertEquals(n, input.size());
    assertEquals(w, input.get(n - 1));
  }

  @Property
  void inputArbitraryIterator(@ForAll final List<String> values) {
    final var size = values.size();
    final var sum = values.stream().count();
    assertEquals(sum, size);
  }
}
