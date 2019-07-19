/**
 * 
 */
package com.globant.bootcamp.functional.functional.katas.methodPattern;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.globant.bootcamp.functional.functional.katas.templateMethodPattern.TemplateCalculator;

/**
 * @author brayanguerrero
 *
 */
public class TemplateMethodPattern {
	
	TemplateCalculator positiveBasicCalculator = new TemplateCalculator();

	@Test
	public void sum(){
		Assert.assertThat(positiveBasicCalculator.executeOperation(3, 2, (a, b) -> a + b), is(5));
	}
	
	@Test
	public void substract(){
		Assert.assertThat(positiveBasicCalculator.executeOperation(3, 2, (a, b) -> a - b), is(1));
	}
	
	@Test
	public void multiply(){
		Assert.assertThat(positiveBasicCalculator.executeOperation(3, 2, (a, b) -> a * b), is(6));
	}
	
	@Test
	public void divide(){
		Assert.assertThat(positiveBasicCalculator.executeOperation(6, 2, (a, b) -> a / b), is(3));
	}
	
}
