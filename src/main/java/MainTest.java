import java.io.IOException;

public class MainTest {
    static String testUserName = "Antonette";
    public static void main(String[] args) {

        int testUserId = 2;


        try {
            MainClass.createUser(User.userData());
            MainClass.updateUser(User.userData(),testUserId);
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
