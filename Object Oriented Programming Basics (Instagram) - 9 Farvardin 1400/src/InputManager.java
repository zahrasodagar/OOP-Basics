public class InputManager {
    static String input;

    static boolean checkInput(String inputLine) {
        input = inputLine;

        return checkLogin() || checkSignup() || checkFollow() || checkUnFollow() || checkSearch();
    }

    static boolean checkLogin() { //todo
        if (input.contains("Login")) {
            /*
             * */
            return true;
        } else
            return false;
    }

    static boolean checkSignup() { //todo
        return true;
    }

    static boolean checkFollow() { //todo
        return false;
    }

    static boolean checkUnFollow() { //todo
        return false;
    }

    static boolean checkSearch() { //todo
        return false;
    }
    // etc...
}


// Login -> user -> password -> successful/unsuccessful
// Signup -> username, password
// Follow user
// Search user/ name
// View user/ name
// new post
// delete post
// hide post

// add person
// remove person




