package com.globant.sumlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SumList {

	public static void main(String[] args) {
		List<Integer> arrays = populate(new ArrayList<Integer>(), 2);
		arrays.stream().forEach((p)-> {	System.out.println(p);});
		int sum = arrays.stream().reduce(0, (a, b) -> a + b);
		System.out.println("La suma de los elementos random del ArrayList es:"+sum);
	}
	private static List<Integer> populate(List<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
 }

}
