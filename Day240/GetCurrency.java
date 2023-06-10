package Day240;

import java.text.NumberFormat;
import java.util.Locale;

public class GetCurrency {

    public static void main(String[] args) {
        double amount = 12345.67;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        String formattedAmount = currencyFormatter.format(amount);
        System.out.println("US Currency: " + formattedAmount);

        Locale locale1 = new Locale("fr", "FR");
        NumberFormat currencyFormatter1 = NumberFormat.getCurrencyInstance(locale1);

        String formattedAmountFr = currencyFormatter1.format(amount);
        System.out.println("France Currency: " + formattedAmountFr);

        Locale localIndia = new Locale("en", "IN");
        NumberFormat currencyFormatterIn = NumberFormat.getCurrencyInstance(localIndia);
        String formattedAmountIn = currencyFormatterIn.format(amount);
        System.out.println("INDIA Currency: " + formattedAmountIn);

        Locale localChina = new Locale("zh", "CN");
        NumberFormat currencyFormatterCn = NumberFormat.getCurrencyInstance(localChina);
        String formattedAmountCn = currencyFormatterCn.format(amount);
        System.out.println("CHINA Currency: " + formattedAmountCn);
    }
}
