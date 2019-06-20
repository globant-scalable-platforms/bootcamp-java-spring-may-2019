package com.globant.bootcamp.spring.week2.challenges.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Challenge3Impl implements Challenge3File {

	public Map<String, Double> fileOperations() throws FileNotFoundException {

		BufferedReader Buff = new BufferedReader(new FileReader("src/main/resources/numbers.txt"));
		String content = null;
		try {
			content = Buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] numbers = content.split(",");
		List<Integer> numbersInt = new ArrayList<>();

		for (String s : numbers) {
			numbersInt.add(Integer.parseInt(s));
		}

		Double average = numbersInt.stream().mapToInt(a -> a).average().orElse(0.0);
		int count = numbersInt.size();
		Double dCount= new Double(count);
		int max = Collections.max(numbersInt);
		Double dMax= new Double(max);
		int min = Collections.min(numbersInt);
		Double dMin= new Double(min);
		int sum = numbersInt.stream().mapToInt(i -> i).sum();
		Double dSum= new Double(sum);
		
		Map<String, Double> results = new HashMap<>();
		
		results.put("Average", average);
		results.put("Count", dCount);
		results.put("Max", dMax);
		results.put("Min", dMin);
		results.put("Sum", dSum);
		

		return results;

	}

}
