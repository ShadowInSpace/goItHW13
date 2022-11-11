import org.jsoup.Jsoup;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainClass {
    private static final String url = "https://jsonplaceholder.typicode.com/users";
public static void createUser(String userData) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
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
                .uri(URI.create(url+"/"+userId))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(userData))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("User " + userId + " updated. statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void deleteUser(String userData, int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+"/"+userId))
                .DELETE()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("User " + userId + " deleted. statusCode() = " + response.statusCode());
    }
}
