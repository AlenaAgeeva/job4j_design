package ru.job4j.gc;

public class User {
    private int age;
    private String name;
    private boolean isEmployee;

    public User(int age, String name, boolean isEmployee) {
        this.age = age;
        this.name = name;
        this.isEmployee = isEmployee;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s %b%n", age, name, isEmployee);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + ", isEmployee=" + isEmployee + '}';
    }

    public static void main(String[] args) {
        User usr1 = new User(76, "n", true);
        User usr2 = new User(76, "n", true);
        User usr3 = new User(76, "n", true);
        System.out.println(usr1);
        System.out.println(usr2);
        System.out.println(usr3);
        for (int i = 1; i < 10000; i++) {
            System.out.println(new User(i, "n", i % 2 == 0));
        }
    }
}
