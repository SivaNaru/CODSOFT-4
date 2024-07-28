package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateAPI {
    private static final String API_KEY = "d555195089eddc36f8289a0d"; 
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlStr = BASE_URL + "/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        JSONObject json = new JSONObject(content.toString());
        return json.getJSONObject("conversion_rates").getDouble(targetCurrency);
    }
}
