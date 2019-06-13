package springbootcamp.springrest.controllers.domain;

public class FileResult {

    private double average;
    private long count;
    private int max;
    private int min;
    private long sum;

    public FileResult(double average, long count, int max, int min, long sum) {
        this.average = average;
        this.count = count;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
