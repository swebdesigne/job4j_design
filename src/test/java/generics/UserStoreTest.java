package generics;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserStoreTest {

    @Test
    public void whenAddUser() {
        UserStore userStore = new UserStore();
        User user = new User("0", "Igor", 33);
        userStore.add(user);
        assertThat(userStore.findById("0"), is(user));
    }

    @Test
    public void whenReplaceUser() {
        UserStore userStore = new UserStore();
        User user = new User("0", "Igor", 33);
        userStore.add(user);
        assertThat(userStore.replace("0", new User("0", "Boris", 33)), is(true));
    }

    @Test
    public void whenDeleteUser() {
        UserStore userStore = new UserStore();
        User user = new User("0", "Igor", 33);
        userStore.add(user);
        assertThat(userStore.delete("0"), is(true));
    }

    @Test
    public void whenFindById() {
        UserStore userStore = new UserStore();
        User user = new User("0", "Igor", 33);
        userStore.add(user);
        assertThat(userStore.findById("0"), is(user));
    }

    @Test
    public void whenNotFindById() {
        UserStore userStore = new UserStore();
        User user = new User("0", "Igor", 33);
        userStore.add(user);
        assertThat(userStore.findById("1"), is(nullValue()));
    }

}