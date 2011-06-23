package primeFactors;

import junit.framework.TestCase;

import static java.util.Arrays.asList;

/**
 * PrimeFactorsTest is responsible for
 *
 * @author skuenzli
 */
public class PrimeFactorsTest extends TestCase {

	public void testZero() throws Exception {
		assertEquals(asList(), PrimeFactors.generate(0));
	}

	public void testOne() throws Exception {
		assertEquals(asList(), PrimeFactors.generate(1));
	}

	public void testTwo() throws Exception {
		assertEquals(asList(2), PrimeFactors.generate(2));
	}

	public void testThree() throws Exception {
		assertEquals(asList(3), PrimeFactors.generate(3));
	}

	public void testFour() throws Exception {
		assertEquals(asList(2, 2), PrimeFactors.generate(4));
	}

	public void testFive() throws Exception {
		assertEquals(asList(5), PrimeFactors.generate(5));
	}

	public void testSix() throws Exception {
		assertEquals(asList(2, 3), PrimeFactors.generate(6));
	}

	public void testEight() throws Exception {
		assertEquals(asList(2, 2, 2), PrimeFactors.generate(8));
	}

	public void testNine() throws Exception {
		assertEquals(asList(3, 3), PrimeFactors.generate(9));
	}

	public void test_AReallyBigNumber() throws Exception {
		assertEquals(asList(2,2,3,3,5,5,7,7), PrimeFactors.generate(2*2*3*3*5*5*7*7));
	}

}
