import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class RealEstateNetworking {

    public static ArrayList<House> getHouseDetails(int zipCode){
        ArrayList<House> houseArrayList = new ArrayList<>();

        String body = "";
        String body2 = "";
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

        JSONArray jsonArray = new JSONArray(body);


        for(int i = 0; i < jsonArray.length(); i++){

            JSONObject currentObj = jsonArray.getJSONObject(i);

            String address = currentObj.getString("formattedAddress");
            int sqrefeet = currentObj.getInt("lotSize");
            int bedrooms = currentObj.getInt("bedrooms");
            int bathrooms = currentObj.getInt("bathrooms");

            if(i == 0) {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("https://realty-mole-property-api.p.rapidapi.com/rentalPrice?bedrooms=" + bedrooms + "&bathrooms=" + bathrooms + "&squareFootage=" + sqrefeet + "&compCount=10"))
                            .header("X-RapidAPI-Key", "5369683703msh0d8168b0fd53192p121c77jsn2464802197da")
                            .header("X-RapidAPI-Host", "realty-mole-property-api.p.rapidapi.com")
                            .method("GET", HttpRequest.BodyPublishers.noBody())
                            .build();
                    HttpResponse<String> response2 = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                    body2 += response2.body();
                    System.out.println(body2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            JSONObject obj = new JSONObject(body2);
            JSONArray jsonArray1 = obj.getJSONArray("listings");
            JSONObject currentObj1 = jsonArray1.getJSONObject(i);

            double price = currentObj1.getDouble("price");
            double rentEstimate = obj.getDouble("rent");
            double correlation = currentObj1.getDouble("correlation");

            houseArrayList.add(new House(address, price, rentEstimate, sqrefeet, bedrooms, bathrooms, correlation));

        }

        return houseArrayList;

    }
}
