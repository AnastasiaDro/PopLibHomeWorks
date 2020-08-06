package com.geekbrains.myapplication.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {

    private CalcAmount calcAmount;

    @Before
    public void before() {
        calcAmount = new CalcAmount();
    }

    // в методе calcSum
    // к введённому числу firstItem прибавляется 50
    @Test
    public void calcSum_when_isCorrect(){
        int firstItem = 10;
        int sum = calcAmount.calcSum(firstItem);
        Assert.assertEquals(sum, 60);
    }

    @Test
    public void calcSum_when_inCorrect(){
        int firstItem = 10;
        int sum = calcAmount.calcSum(firstItem);
        Assert.assertEquals(sum, 70);
    }

}
