package com.globant.avoidduplicate;
import java.util.stream.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidDuplicate {
	public static void main(String[] args) {
		
		List<Integer> arrays =new ArrayList<Integer>();
		arrays.add(1);
		arrays.add(2);
		arrays.add(2);
		arrays.add(3);
		arrays.add(3);
		arrays.add(3);
		arrays.add(4);
		
		System.out.println(arrays);
		
	    arrays=arrays.stream().distinct().collect(Collectors.toList());
		
		System.out.println(arrays);
		
	}
	
}
