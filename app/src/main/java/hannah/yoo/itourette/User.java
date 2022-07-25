package hannah.yoo.itourette;


import java.util.HashMap;
import java.util.Map;

public class User{

    public String email;
    public String password;
    public String username;
    public String uid;
    public String level;
    public Map<String,Integer> map = new HashMap<>();


    public User() {
    }

    public User(String email, String password, String username, String uid, String level) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.uid = uid;
        this.level = level;
        this.map.put("0_key", 0);
    }
}
