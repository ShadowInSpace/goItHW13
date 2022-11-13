import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    private static final String urlUser = "https://jsonplaceholder.typicode.com/users";
    private static final String baseUrl = "https://jsonplaceholder.typicode.com";
    private final static Gson gson = new Gson();

    public static void createUser(String userData) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(userData))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("User Created. statusCode = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void updateUser(String userData, int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser + "/" + userId))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(userData))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("User " + userId + " updated. statusCode = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void deleteUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser + "/" + userId))
                .DELETE()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("User " + userId + " deleted. statusCode = " + response.statusCode());
    }

    public static String allUsersInfo() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("AllUsersInfo statusCode = " + response.statusCode());
        // System.out.println("response.body() = " + response.body());
        return response.body();
    }

    public static String userInfo(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser + "/" + userId))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("userInfo statusCode = " + response.statusCode());
//         System.out.println("response.body() = " + response.body());
        return response.body();
    }

    public static String userInfo(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlUser + "?username=" + userName))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("userInfo statusCode = " + response.statusCode());
//         System.out.println("response.body() = " + response.body());
        return response.body();
    }

    public static void latestPostComments(int userId) throws IOException {
        String text;
        int oldestPostId = 0;
        String coments;
        //отримуємо всі пости користувача
        text = Jsoup.connect(urlUser + "/" + userId + "/posts")
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();
        List<Post> allPosts = gson.fromJson(text, type);
//знаходимо найстарший

        for (Post post : allPosts) {
            if (post.getId() > oldestPostId) oldestPostId = post.getId();
        }
        coments = Jsoup.connect(baseUrl + "/posts/" + oldestPostId + "/comments")
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        try (OutputStream fos = new FileOutputStream("user-" + userId + "-post-" + oldestPostId + "-comments.json")) {
            fos.write(coments.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void whatToDo(int userId) throws IOException {
        String tasks;
        tasks = Jsoup.connect(urlUser + "/" + userId + "/todos")
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        Type taskType = TypeToken
                .getParameterized(List.class, Task.class)
                .getType();
        List<Task> allTasks = gson.fromJson(tasks, taskType);
        List<Task> uncompletedTasks = allTasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
        System.out.println("uncompletedTasks = " + uncompletedTasks);
        //if needed return uncompletedTasks;
    }
}
