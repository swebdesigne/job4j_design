package job4j.map;

import job4j.map.SimpleMap;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutSuccess() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        assertTrue(simpleMap.put("Igor", "Sivolobov"));
    }

    @Test
    public void whenAddSameElementFalse() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "33");
        assertFalse(simpleMap.put("Michail", "10"));
    }

    @Test
    public void whenAddSameElementTrue() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "33");
        simpleMap.put("Igor", "10");
        assertThat(simpleMap.get("Igor"), is("10"));
    }

    @Test
    public void whenIncreaseCapacity() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "33");
        simpleMap.put("Boris", "35");
        simpleMap.put("Alina", "37");
        simpleMap.put("Ivan", "28");
        simpleMap.put("Petr", "12");
        simpleMap.put("Ekaterina", "44");
        simpleMap.put("Sergey", "55");
        assertThat(simpleMap.get("Sergey"), is("55"));
    }

    @Test
    public void whenGetSuccess() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        assertThat(simpleMap.get("Igor"), is("Sivolobov"));
    }

    @Test
    public void whenGetSuccessFalse() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        assertFalse(simpleMap.put("Michail", "33"));
    }

    @Test
    public void whenGetIsNull() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        assertNull(simpleMap.get("Boris"));
    }

    @Test
    public void whenRemoveSuccess() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        assertTrue(simpleMap.remove("Igor"));
    }

    @Test
    public void whenRemoveNotSuccess() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        assertFalse(simpleMap.remove("Boris"));
    }

    @Test
    public void whenIteratorSuccess() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov1");
        simpleMap.put("Boris", "Sivolobov2");
        Iterator<String> it = simpleMap.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), Is.is("Sivolobov2"));
        assertTrue(it.hasNext());
        assertThat(it.next(), Is.is("Sivolobov1"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<String, String> simpleMap = new SimpleMap();
        simpleMap.put("Igor", "Sivolobov");
        Iterator<String> it = simpleMap.iterator();
        simpleMap.put("Boris", "Sivolobov");
        it.next();
    }
}