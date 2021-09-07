package job4j.iterator;

import job4j.iterator.ListUtils;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(0, 1, 3, 2), Is.is(input));
    }

    @Test
    public void whenRemove() {
        List<Integer> first = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> x = integer -> integer < 3;
        ListUtils.removeIf(first, x);
        assertThat(Arrays.asList(3), Is.is(first));
    }

    @Test
    public void whenReplace() {
        List<Integer> first = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Predicate<Integer> x = integer -> integer == 2;
        ListUtils.replaceIf(first, x, 4);
        assertThat(Arrays.asList(0, 1, 4, 3), Is.is(first));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> first = new ArrayList<>(Arrays.asList(0, 1, 2, 5));
        List<Integer> second = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeAll(first, second);
        assertThat(Arrays.asList(5), Is.is(first));
    }
}