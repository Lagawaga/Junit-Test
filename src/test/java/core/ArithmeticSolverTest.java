package core;

import junit.framework.TestCase;

public class ArithmeticSolverTest extends TestCase{
	
	public void testAdd() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(4, solver.add(2,2));
		assertEquals(69, solver.add(34,35));
		
	}
	
	public void testSubtract() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(0, solver.subtract(2,2));
		assertEquals(5, solver.subtract(10,5));
	}
	
	public void testMultiply() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(4, solver.multiply(2,2));
		assertEquals(54, solver.multiply(9,6));
		
	}

	public void testDivide() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(0, solver.divide(2,2));
		
	}
	public void testModulus() {
		ArithmeticSolver solver = new ArithmeticSolver();
		assertEquals(1, solver.modulus(5,2));
		
	}
}
