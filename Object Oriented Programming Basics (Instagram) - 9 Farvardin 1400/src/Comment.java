import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Comment {
    String text;
    Account sender;
    Date date;
    Comment previews;
    ArrayList<Account> likers = new ArrayList<>();
    int likes = 0;

    public Comment(String text, Account sender, Comment previews) {
        date = new Date();
        this.text = text;
        this.sender = sender;
        this.previews = previews;
    }

    // overriding example
    public String toString() {
        return text;
    }

    public void addLike(Account account) {
        for (Account a : likers) {
            if (a.equals(account)) {
                System.out.println("You have already liked this comment");
                return;
            }
        }
        likers.add(account);
        ++likes;
    }
}
