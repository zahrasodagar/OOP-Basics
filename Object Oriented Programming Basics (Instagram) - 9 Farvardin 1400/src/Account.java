import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    static ArrayList<Account> allAccounts = new ArrayList<>();

    String username;
    private String password;
    String name;
    String bio = "";
    boolean isPrivate = false; // default

    ArrayList<Account> followers = new ArrayList<>();
    ArrayList<Account> followings = new ArrayList<>();
    ArrayList<Account> requests = new ArrayList<>();

    HashMap<Post, Boolean> posts = new HashMap<>();

    public Account() {
        allAccounts.add(this);
    }

    public Account(String username, String password, String name) {
        this();
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // static methods
    public static Account getAccount(String nameOrUsername) {
        Account account = searchUsername(nameOrUsername);
        if (account == null)
            account = searchName(nameOrUsername);
        return account;
    }

    public static Account searchUsername(String username) {
        for (Account account : allAccounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public static Account searchName(String name) {
        for (Account account : allAccounts) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public static Account login(String username, String password) {
        Account account = getAccount(username);
        if (account == null) {
            System.out.println("This user does not exist!");
            return null;
        }
        if (account.checkPassword(password)) {
            System.out.println("Login was successful ...");
            return account;
        } else {
            System.out.println("Wrong password!");
            return null;
        }
    }

    // methods
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void addRequest(Account account) {
        requests.add(account);
    }

    public void viewRequests() {
        for (Account account : requests) {
            System.out.println(account);
        }
    }

    //overriding example
    public String toString() {
        return username + "(" + name + ")";
    }

    public boolean isFollower(Account account) {
        for (Account a : followers) {
            if (a.equals(account))
                return true;
        }
        return false;
    }

    public boolean isFollowing(Account account) {
        for (Account a : followings) {
            if (a.equals(account))
                return true;
        }
        return false;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public ArrayList<Account> getFollowers() {
        return followers;
    }

    public ArrayList<Account> getFollowings() {
        return followings;
    }

    public ArrayList<Account> getRequests() {
        return requests;
    }

    public HashMap<Post, Boolean> getPosts() {
        return posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }


}
