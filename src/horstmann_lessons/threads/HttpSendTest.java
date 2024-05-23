package horstmann_lessons.threads;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpSendTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String urlString = "http://localhost:8082/order-api/get-order?id=1";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(urlString)).GET().build();

        CompletableFuture<Void>  f = client.sendAsync
                (request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(a -> {
                    System.out.println(a.body());
                });
        f.get();


    }
}
