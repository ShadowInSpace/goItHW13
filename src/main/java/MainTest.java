import java.io.IOException;

public class MainTest {
    static String testUserName = "Antonette";

    public static void main(String[] args) {

        int testUserId = 2;
        User user = new User("Ivan Yatskovets",
                "ShadowSpace",
                "ivan.yackovec@gmail.com",
                "shyroka",
                "Suite 41",
                "Lviv",
                "79000",
                "49.8418",
                "24.0315");


        try {
            MainClass.createUser(user);
            MainClass.updateUser(user, testUserId);
            MainClass.deleteUser(testUserId);
            System.out.println("allUsersInfo = " + MainClass.allUsersInfo());
            System.out.println("userInfo by id = " + MainClass.userInfo(testUserId));
            System.out.println("userInfo by userName = " + MainClass.userInfo(testUserName));

            MainClass.latestPostComments(testUserId);
            MainClass.whatToDo(testUserId);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
