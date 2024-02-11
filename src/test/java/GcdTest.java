import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.GCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GcdTest {

	private static GCD gcd;

	@BeforeAll
	public static void init() {
		gcd = new GCD();
	}

	@Test
	void testGcdNormalNumbers() {
		assertEquals(14, gcd.gcd(42, 56), "Testing normal gcd");
	}

	@Test
	void testGcdLargeNumbers() {
		assertEquals(18, gcd.gcd(461952, 116298), "Testing large numbers #1");
		assertEquals(32, gcd.gcd(7966496, 314080416), "Testing large numbers #2");
		assertEquals(526, gcd.gcd(24826148, 45296490), "Testing large numbers #3");
	}

	@Test
	void testGcdWithZero() {
		assertEquals(12, gcd.gcd(12, 0), "Testing gcd with zero #1");
		assertEquals(0, gcd.gcd(0, 0), "Testing gcd with zero #2");
		assertEquals(9, gcd.gcd(0, 9), "Testing gcd with zero #3");
	}

	@Test
	void testGcdWithNegativeNumbers() {
		assertEquals(6, gcd.gcd(-24, -18), "Testing gcd with negative numbers #1");
		assertEquals(1, gcd.gcd(-7, 13), "Testing gcd with negative numbers #2");
		assertEquals(8, gcd.gcd(-16, 8), "Testing gcd with negative numbers #3");
	}

	@Test
	void testNonUnitCoprimeArguments() {
		assertEquals(1, gcd.gcd(15, 28), "Testing non-unit coprime arguments #1");
	}

	@Test
	void testEqualArguments() {
		assertEquals(5, gcd.gcd(-5, -5), "Testing equal arguments #1");
		assertEquals(7, gcd.gcd(7, 7), "Testing equal arguments #2");
		assertEquals(0, gcd.gcd(0, 0), "Testing equal arguments #3");
	}

	@Test
	void testOneDividesTheOther() {
		assertEquals(7, gcd.gcd(14, 7), "Testing one divides the other #1");
		assertEquals(5, gcd.gcd(5, 10), "Testing one divides the other #2");
	}

	@Test
	void testNonEqualArguments() {
		assertEquals(12, gcd.gcd(24, 36), "Testing non-equal arguments #1");
	}

	@Test
	void testBoundaryValues() {
		int min = -1 * ((int) Math.pow(2, 31));
		int max = Math.abs(min) - 1;
		assertEquals(max, gcd.gcd(max, max));
		assertEquals(max, gcd.gcd(0, max));
		assertEquals(max, gcd.gcd(max, 0));

		assertEquals(Math.abs(min), gcd.gcd(0, min));
		assertEquals(Math.abs(min), gcd.gcd(min, 0));
		assertEquals(Math.abs(min), gcd.gcd(min, min));
	}

	@Test
	void testFibonacciArgs() {
		int n40 = 102334155;
		int n41 = 165580141;
		assertEquals(1, gcd.gcd(n40, n41));
	}
}