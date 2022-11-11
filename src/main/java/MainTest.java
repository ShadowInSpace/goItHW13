import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {


        try {
            //MainClass.createUser(User.userData());
            //MainClass.updateUser(User.userData(),10);
            MainClass.deleteUser(User.userData(),10);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
