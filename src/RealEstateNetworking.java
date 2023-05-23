import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class RealEstateNetworking {

    public static House getHouseDetails(int zipCode){
        String body = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://realty-mole-property-api.p.rapidapi.com/properties?zipCode=" + zipCode))
                    .header("X-RapidAPI-Key", "5369683703msh0d8168b0fd53192p121c77jsn2464802197da")
                    .header("X-RapidAPI-Host", "realty-mole-property-api.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            body += response.body();
            System.out.println(body);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        JSONObject jsonObj = new JSONObject(body);

        JSONObject currentObj = jsonObj.getJSONObject("0");
}
}
