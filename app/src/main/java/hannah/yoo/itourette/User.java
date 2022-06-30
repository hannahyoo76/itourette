package hannah.yoo.itourette;


public class User{

    public String email;
    public String password;
    public String username;
    public String uid;
    public String level;


    public User() {
    }

    public User(String email, String password, String username, String uid, String level) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.uid = uid;
        this.level = level;
    }

}
