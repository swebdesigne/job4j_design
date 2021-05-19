package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class TriggerTest {
    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, new Trigger().someLogic1());
    }
}