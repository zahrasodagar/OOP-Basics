import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Post {
    Date date;
    // ArrayList<File> pictures = new ArrayList<>();
    ArrayList<String> pictures = new ArrayList<>();
    String caption;
    ArrayList<Comment> comments = new ArrayList<>();
    ArrayList<Account> likers = new ArrayList<>();
    int likes = 0;

    public Post() {

    }

    public Post(ArrayList<String> pictures, String caption) {
        date = new Date();
        this.pictures = pictures;
        this.caption = caption;
    }

    // overriding example
    public Post clone() {
        Post post = new Post();
        post.pictures = this.pictures;
        post.caption = this.caption;

        return post;
    }

    public void addLike(Account account) {
        for (Account a : likers) {
            if (a.equals(account)) {
                System.out.println("You have already liked this post");
                return;
            }
        }
        likers.add(account);
        ++likes;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
