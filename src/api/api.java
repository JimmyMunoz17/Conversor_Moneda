package api;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class api {
    String conexion_api = "https://v6.exchangerate-api.com/v6/5fa56fe2a10e8ad2744fb269/latest/USD";
    String key = "5fa56fe2a10e8ad2744fb269";
    public String jsonResponse ;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(conexion_api))
            .build();
    HttpResponse<String> response;
    {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

