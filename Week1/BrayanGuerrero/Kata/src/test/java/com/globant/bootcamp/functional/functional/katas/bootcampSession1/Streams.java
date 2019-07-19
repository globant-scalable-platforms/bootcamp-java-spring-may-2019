package com.globant.bootcamp.functional.functional.katas.bootcampSession1;

import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.globant.bootcamp.functional.functional.katas.streams.Office.OfficeService;

public class Streams {

	protected static final List<Integer> LISTA_NUMEROS = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4, 5));

    @Test
    public void stream1() {

        System.out.println(Arrays.asList("juan","pedro","juan","trump").stream().distinct().map(a -> a+"yahoo").count());
        Arrays.asList("juan","pedro","juan","trump").stream()
                .distinct().map(a -> a+"yahoo").forEach(System.out::println );
    }
    
    @Test
    public void sum(){
    	OfficeService officeService = new OfficeService();
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 3));
        Assert.assertThat(officeService.sumList(list), is(9));
    }

    @Test
    public void avoidDuplicates(){
    	OfficeService officeService = new OfficeService();
        Assert.assertEquals(officeService.deleteDuplicates(LISTA_NUMEROS), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
    }
    
}
