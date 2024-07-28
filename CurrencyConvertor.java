package p1;
import java.util.Scanner;

public class CurrencyConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            double exchangeRate = ExchangeRateAPI.getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;

            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
