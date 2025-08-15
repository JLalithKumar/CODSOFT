import java.net.http.*;
import java.net.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class CurrencyConverter {
    private static final HttpClient client = HttpClient.newHttpClient();

public static double convert(String from, String to, double amount) throws IOException, InterruptedException {
    String url = String.format(
        "https://api.frankfurter.app/latest?amount=%s&from=%s&to=%s",
        URLEncoder.encode(Double.toString(amount), "UTF-8"),
        URLEncoder.encode(from, "UTF-8"),
        URLEncoder.encode(to, "UTF-8")
    );

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() != 200) {
        throw new IOException("HTTP error: " + response.statusCode());
    }

    JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();

    if (root.has("rates")) {
        JsonObject rates = root.getAsJsonObject("rates");
        if (rates.has(to)) {
            return rates.get(to).getAsDouble();
        }
    }
    throw new IOException("Unexpected API response: " + response.body());
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Simple Currency Converter (exchangerate.host) ===");

        while (true) {
            System.out.print("Base currency (e.g. USD) or 'q' to quit: ");
            String from = sc.next().trim().toUpperCase();
            if (from.equals("Q")) break;

            System.out.print("Target currency (e.g. INR): ");
            String to = sc.next().trim().toUpperCase();

            System.out.print("Amount: ");
            String amtStr = sc.next().trim();
            double amount;
            try {
                amount = Double.parseDouble(amtStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            try {
                double result = convert(from, to, amount);
                System.out.printf(Locale.US, "%.2f %s = %.2f %s%n", amount, from, result, to);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.print("Convert another? (y/n): ");
            String again = sc.next().trim().toLowerCase();
            if (!again.equals("y")) break;
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}
