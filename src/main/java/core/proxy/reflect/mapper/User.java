package core.proxy.reflect.mapper;

public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "userid: " + id + ", name: " + name;
    }
}
