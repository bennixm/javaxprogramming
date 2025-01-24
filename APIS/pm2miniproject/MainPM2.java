import com.google.gson.Gson;
import com.google.gson.JsonObject;

package APIS.pm2miniproject;


public class MainPM2 {


    public static void processJsonResponse(String jsonResponse) {

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);


        double pm25 = jsonObject
                .getAsJsonArray("list")
                .get(0)
                .getAsJsonObject()
                .getAsJsonObject("components")
                .get("pm2_5")
                .getAsDouble();


        System.out.println("PM2.5 Value: " + pm25);
    }
}
