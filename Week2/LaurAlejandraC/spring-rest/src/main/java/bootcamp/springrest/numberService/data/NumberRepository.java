package bootcamp.springrest.numberService.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRepository {
    private BigDecimal average;
    private BigInteger count;
    private BigInteger max;
    private BigInteger min;
    private BigInteger sum;
    private List<BigInteger> numbers;

    public NumberRepository(){
        numbers = new ArrayList<>();
        average = null;
        count = new BigInteger("0");
        max = null;
        min = null;
        sum = new BigInteger("0");
    }

    public HttpStatus initializeFromFile(MultipartFile file){
        try{
            String[] toParse = (new String(file.getBytes())).split(",");

            numbers = Arrays.stream(toParse)
                    .map(String::trim)
                    .map(BigInteger::new)
                    .collect(Collectors.toList());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return HttpStatus.BAD_REQUEST;
        }

        for(BigInteger cur : numbers){
            max = max == null || cur.compareTo(max) > 0 ? cur : max;
            min = min == null || cur.compareTo(min) < 0 ? cur : min;
            sum = sum.add(cur);
            count = count.add(BigInteger.ONE);
        }

        average = new BigDecimal(sum);
        average = average.divide(new BigDecimal(count), 4, BigDecimal.ROUND_DOWN);

        return HttpStatus.OK;
    }

    public List<BigInteger> getNumbers() {
        return numbers;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public BigInteger getCount() {
        return count;
    }

    public BigInteger getMax() {
        return max;
    }

    public BigInteger getMin() {
        return min;
    }

    public BigInteger getSum() {
        return sum;
    }
}