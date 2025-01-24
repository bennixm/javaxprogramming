import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

package APIS.pm2miniproject;

public class pm2 {

    public static String getAirPollutionData(String apiKey, String lat, String lon) {
        String urlString = String.format("https://api.openweathermap.org/data/2.5/air_pollution?lat=%s&lon=%s&appid=%s", lat, lon, apiKey);
        
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                return response.toString(); 
            } else {
                System.out.println("Error: Received HTTP response code " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;  
    }

    public static void main(String[] args) {
        String apiKey = "b6fc49424ed09bac875e0d52d1457aea";
        String lat = "48.8566";
        String lon = "2.3522";

        String jsonResponse = getAirPollutionData(apiKey, lat, lon);
        
        if (jsonResponse != null) {
            MainPM2.processJsonResponse(jsonResponse);
        }
    }
}
