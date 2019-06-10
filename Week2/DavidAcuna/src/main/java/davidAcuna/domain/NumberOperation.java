package davidAcuna.domain;

public class NumberOperation {
    
	private Integer sum;
	private Long count;
	private Integer max;
	private Integer min;
	private Double average;
	
	public NumberOperation(Integer sum, Long count, Integer max, Integer min, Double average) {
		super();
		this.sum = sum;
		this.count = count;
		this.max = max;
		this.min = min;
		this.average = average;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
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

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}		
	
}
