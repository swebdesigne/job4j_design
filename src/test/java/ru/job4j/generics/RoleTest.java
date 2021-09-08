package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleTest {
    @Test
    public void whenAddRole() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("0", "Developer", 33);
        roleStore.add(role);
        assertThat(roleStore.findById("0"), is(role));
    }

    @Test
    public void whenReplaceRole() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("0", "Developer", 33);
        roleStore.add(role);
        assertThat(roleStore.replace("0", new Role("0", "Designer", 33)), is(true));
    }

    @Test
    public void whenDeleteRole() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("0", "Developer", 33);
        roleStore.add(role);
        assertThat(roleStore.delete("0"), is(true));
    }

    @Test
    public void whenFindById() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("0", "Developer", 33);
        roleStore.add(role);
        assertThat(roleStore.findById("0"), is(role));
    }

    @Test
    public void whenNotFindById() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("0", "Developer", 33);
        roleStore.add(role);
        assertThat(roleStore.findById("1"), is(nullValue()));
    }
}