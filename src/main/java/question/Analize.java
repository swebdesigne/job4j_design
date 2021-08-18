package question;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info =  new Info(0, 0, 0);

//        if (!previous.containsAll(current) && current.size() > previous.size()) {
//            info.setAdded(info.getAdded() + 1);
//        }
//
//        if (!current.contains(previous) && current.size() < previous.size()) {
//            info.setDeleted(info.getDeleted() + 1);
//        }

        for (User name : current) {
            for (User name2 : previous) {
                if (name.getId() == name2.getId()
                        && !name.getName().equals(name2.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
            }
        }
        return info;
    }
}
