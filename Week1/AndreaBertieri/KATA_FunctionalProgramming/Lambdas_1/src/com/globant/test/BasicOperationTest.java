package com.globant.test;
import com.globant.lambdas.BasicOperation;

//import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;

class BasicOperationTest {

	BinaryOperator<Integer> sum=(a,b)->a+b;
	BinaryOperator<Integer> subtract=(a,b)->a-b;
	BinaryOperator<Integer> multiply=(a,b)->a*b;
	
	@Test
    public void sum() {
		assertEquals(BasicOperation.execute(sum,3,4), 7);
    }
	@Test
    public void subtract() {
	assertEquals(BasicOperation.execute(subtract,3,4), -1);
	}
	@Test
    public void multiply() {
	assertEquals(BasicOperation.execute(multiply,3,4), 12);
	}
	

}
