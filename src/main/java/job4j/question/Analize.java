package job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info =  new Info(0, 0, 0);
        Map<Integer, String> users = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User value : previous) {
            if (!users.containsKey(value.getId())) {
                info.setDeleted(info.getDeleted() + 1);
            } else if (!users.containsValue(value.getName())) {
                info.setChanged(info.getChanged() + 1);
            }
        }
        info.setAdded(current.size() - (previous.size() - info.getDeleted()));
        return info;
    }
}