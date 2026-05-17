package roastery.users;

public abstract class User {
    protected String name;
    protected String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public abstract void showMenu();

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
