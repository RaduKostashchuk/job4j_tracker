package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User \"" + login + "\' is not found.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User \"" + user.getUsername() + "\" is not vaild.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentiev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentiev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eInval) {
            eInval.printStackTrace();
        } catch (UserNotFoundException eNotFound) {
            eNotFound.printStackTrace();
        }
    }
}
