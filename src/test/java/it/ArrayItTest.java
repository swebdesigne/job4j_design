package it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ArrayItTest {

    @Test
    public void whenMultiCallNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(
                new int[] {}
        );
        it.next();
    }

}