package com.globant.bootcamp.functional.functional.katas.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class StreamFunctionsTest{
    @Test
    public void sumList(){
        StreamFunctions sf = new StreamFunctions();
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8));
        Assert.assertThat(sf.sumList(list), is(33));
    }

    @Test
    public void deleteDuplicates(){
        StreamFunctions sf = new StreamFunctions();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4, 5));
        Assert.assertEquals(sf.deleteDuplicates(list), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
    }
}