package com.bootcamp.springRest.model;

import java.util.Comparator;
import java.util.List;

public class Average {
	
	private Integer average;
	private Integer count;
	private Integer max;
	private Integer min;
	private Integer sum;
	private List<Integer> list;
	
	public Average(List<Integer> list) {
		this.list = list;
		this.count = list.size();
		this.max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		this.min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		this.sum = list.stream().mapToInt(Integer::valueOf).sum();
		this.average = (list.stream().mapToInt(Integer::valueOf).sum())/list.size();
	}
	
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Integer getAverage() {
		return average;
	}
	public void setAverage(Integer average) {
		this.average = average;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}

}
