package hw;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;

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
		@ForAll final String string1, @ForAll final String string2
	) {
		final var conc = string1 + string2;
		assertTrue(conc.length() > string1.length());
		assertTrue(conc.length() > string2.length());
	}  

  @Example
	void squareRootOf16is4() { 
		assertEquals(4.0, Math.sqrt(16), 0.01);
	}

	@Example
	boolean add1plu3is4() {
		return (1 + 3) == 4;
	}
}
