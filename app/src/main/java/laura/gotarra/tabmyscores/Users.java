package laura.gotarra.tabmyscores;

import java.util.Map;
import java.util.TreeMap;

public class Users {
    private Map<String, User> users;

    public Users(){
        users = new TreeMap<>();

        User u = new User("Quim", "Fortaner", "PumKid", "1234");
        users.put(u.getName(), u);
    }

    public Map<String, User> getUsers(){
        return users;
    }
}
