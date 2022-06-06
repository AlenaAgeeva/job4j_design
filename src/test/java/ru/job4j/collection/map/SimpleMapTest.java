package ru.job4j.collection.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutIsTrue() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        assertTrue(map.put("Test", new Object()));
    }

    @Test
    public void whenPutIsFalse() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        map.put("Test", new Object());
        assertFalse(map.put("Test", new Object()));
    }

    @Test
    public void whenGetIsValue() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        Object expected = new Object();
        map.put("Test", expected);
        assertEquals(map.get("Test"), expected);
    }

    @Test
    public void whenGetIsNull() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        map.put("Test1", new Object());
        assertNull(map.get("Test"));
    }

    @Test
    public void whenGetIsNull2() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        assertNull(map.get("Test"));
    }

    @Test
    public void whenRemoveIsTrue() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        map.put("Test", new Object());
        assertTrue(map.remove("Test"));
    }

    @Test
    public void whenRemoveIsFalse() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        map.put("Test", new Object());
        assertFalse(map.remove("Test2"));
    }

    @Test
    public void whenRemoveIsFalse2() {
        SimpleMap<String, Object> map = new SimpleMap<>();
        assertFalse(map.remove("Test"));
    }
}