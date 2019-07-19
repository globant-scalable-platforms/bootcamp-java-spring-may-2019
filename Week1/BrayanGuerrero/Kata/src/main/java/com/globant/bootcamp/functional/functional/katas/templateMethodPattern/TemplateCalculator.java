package com.globant.bootcamp.functional.functional.katas.templateMethodPattern;

/**
 * Class whom implement a basic calculator
 */
public class TemplateCalculator {
	
    public Integer executeOperation(Integer a, Integer b, TemplateCalculatorOperation operation) {
        final Integer result = operation.doOperation(a, b);

        return result;
    }

}
