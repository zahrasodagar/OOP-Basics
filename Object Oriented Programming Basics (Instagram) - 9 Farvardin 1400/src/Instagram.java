import java.util.Scanner;

public class Instagram {
    Account currentAccount = null;

    private static Instagram instagram;

    private Instagram() {

    }

    public static Instagram getInstance() {
        if (instagram == null) {
            instagram = new Instagram();
        }
        return instagram;
    }

    public void login(String username, String password) {
        currentAccount = Account.login(username, password);
    }

    public void signup(String username) {
        if (Account.searchUsername(username) != null) {
            System.out.println("This username is already taken");
            return;
        }
        String input;
        String password = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password");
        while (!(input = scanner.nextLine()).equals("CANCEL")) {
            if (isPasswordSecure(input)) {
                password = input;
                break;
            } else
                System.out.println("your password is not secure enough");
        }
        if (password == null) {

        } else {
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            currentAccount = new Account(username, password, name);
            System.out.println("Done!");
        }

    }

    public boolean isPasswordSecure(String password) {
        return password.contains("YOHAHAHA");
    }

    public void addPost() {

    }

    public void follow(String usernameOrName) {
        Account account = Account.getAccount(usernameOrName);
        follow(account);
    }

    public void follow(Account account) {
        if (account == null)
            System.out.println("This user does not exist");
        else {
            if (currentAccount.isFollowing(account)) {
                System.out.println("You have already followed this account");
            } else {
                if (account.isPrivate) {
                    account.addRequest(currentAccount);
                } else {
                    currentAccount.followings.add(account);
                    account.followers.add(currentAccount);
                }
            }
        }
    }

    public void addComment(Post post, String text, Comment replyingTo) {
        Comment comment = new Comment(text, currentAccount, replyingTo);
        post.addComment(comment);
    }

    public void likePost(Post post) {
        post.addLike(currentAccount);
    }

    public void likeComment(Comment comment) {
        comment.addLike(currentAccount);
    }
}
