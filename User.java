import java.util.stream.Stream;

public class User {
    private String name;
    private boolean isActive;
    private String roles;
    private double balance;
    private String email;
    private int reggYear;

    public User(String name, boolean isActive, String roles, double balance, String email, int reggYear) {
        this.name = name;
        this.isActive = isActive;
        this.roles = roles;
        this.balance = balance;
        this.email = email;
        this.reggYear = reggYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getReggYear() {
        return reggYear;
    }

    public void setReggYear(int reggYear) {
        this.reggYear = reggYear;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public void printL(User user) {
         Stream.of(user).forEach(System.out::println);
        //return user;
    }
}
