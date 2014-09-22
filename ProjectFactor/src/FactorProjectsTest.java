import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class FactorProjectsTest {
	
	@Test
	public void testFactorValues() {
		ArrayList<Integer> factors = Main.factors(67);
		Assert.assertEquals("Value should be 1", 1, factors.get(0).intValue());
		Assert.assertEquals("Value should be 67", 67, factors.get(1).intValue());
	}
	
	@Test
	public void testFactorSize() {
		ArrayList<Integer> factors = Main.factors(100);
		Assert.assertEquals("The length should be 9", 9, factors.size());
		factors = Main.factors(12);
		Assert.assertEquals("The length should be 6", 6, factors.size());
	}
	
	@Test
	public void testFactorRange(){
		ArrayList<Integer> betweenFactor1 = new ArrayList<Integer>();
		betweenFactor1.add(0);
		Assert.assertFalse("The value 0 should not be inbetween 1 and 100",Main.inbetweenOneAndOneHundred(betweenFactor1));
		ArrayList<Integer> betweenFactor2 = new ArrayList<Integer>();
		betweenFactor2.add(101);
		Assert.assertFalse("The value 101 should not be inbetween 1 and 100",Main.inbetweenOneAndOneHundred(betweenFactor2));
		ArrayList<Integer> betweenFactor3 = new ArrayList<Integer>();
		betweenFactor3.add(70);
		Assert.assertTrue("The value 70 should be inbetween 1 and 100", Main.inbetweenOneAndOneHundred(betweenFactor3));
	}
	
	@Test
	public void testGCD() {
		ArrayList<Integer> gcdTest = new ArrayList<Integer>();
		gcdTest.add(12);
		gcdTest.add(64);
		gcdTest.add(100);
		gcdTest.add(16);
		Assert.assertEquals("The GCD should be 4", 4, Main.getGCD(gcdTest));
		gcdTest.add(2);
		Assert.assertEquals("The GCD should be 2", 2, Main.getGCD(gcdTest));
		}
	
	@Test
	public void testGCDRange(){
		ArrayList<Integer> gcdTestRange1 = new ArrayList<Integer>();
		gcdTestRange1.add(12);
		gcdTestRange1.add(72);
		Assert.assertTrue("{12, 72} are all inbetween 1 and 100",Main.inbetweenOneAndOneHundred(gcdTestRange1));
		ArrayList<Integer> gcdTestRange2 = new ArrayList<Integer>();
		gcdTestRange2.add(101);
		gcdTestRange2.add(60);
		gcdTestRange2.add(1);
		gcdTestRange2.add(100);
		Assert.assertFalse("{101, 60, 1, 100} are not all inbetween 1 and 100", Main.inbetweenOneAndOneHundred(gcdTestRange2));
	}

}
