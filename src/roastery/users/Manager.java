package roastery.users;

public class Manager extends User {
    public Manager(String name) {
        super(name, "Manager");
    }

    @Override
    public void showMenu() {
        System.out.println("Manager Menu:");
        System.out.println("1. Set production goals");
        System.out.println("2. View overall progress report");
        System.out.println("3. View role progress report");
        System.out.println("4. Exit");
    }
}
