package ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionTracker {
    
    private static Map<String, String> transactions = new HashMap<>();
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void addTransaction(String transactionId, String type, double amount, String date) {
    
        String transactionDetails = type + "," + amount + "," + date;
        transactions.put(transactionId, transactionDetails);
        System.out.println("we added transaction: " + transactionId);
    }

    public static int countTransactionsYesterday() {
        int transactionCount = 0;
        String yesterday = getYesterdayDate();

        for (String transactionDetails : transactions.values()) {
            String[] details = transactionDetails.split(",");
            String transactionDate = details[3];
            if (transactionDate.equals(yesterday)) {
                transactionCount++;
            }
        }
        return transactionCount;
    }


    public static double calculateTotalIncome() {
        double totalIncome = 0.0;

        for (String transactionDetails : transactions.values()) {
            String[] details = transactionDetails.split(",");
            String type = details[0];
            double amount = Double.parseDouble(details[1]);

            if (type.equals("Sales")) {
                totalIncome += amount;
            }
        }
        return totalIncome;
    }

    public static double calculateTotalExpenses() {
        double totalExpenses = 0.0;


        for (String transactionDetails : transactions.values()) {
            String[] details = transactionDetails.split(",");
            String type = details[0];
            double amount = Double.parseDouble(details[1]);

            if (type.equals("Purchases")) {
                totalExpenses += amount;
            }
        }
        return totalExpenses;
    }


    private static String getYesterdayDate() {

        long oneDayMillis = 24 * 60 * 60 * 1000;  

        long currentTime = System.currentTimeMillis();
        long yesterdayMillis = currentTime - oneDayMillis;
        Date yesterday = new Date(yesterdayMillis);
        
        return dateFormat.format(yesterday);
    }

    public static void main(String[] args) {

        addTransaction("TX1001", "Sales", 200.50, "2025-01-16");
        addTransaction("TX1002", "Purchases", 50.00, "2025-01-15");
        addTransaction("TX1003", "Sales", 150.00, "2025-01-16");
        addTransaction("TX1004", "Purchases", 300.00, "2025-01-14");


        System.out.println("Transactions performed yesterday: " + countTransactionsYesterday());

        System.out.println("Total Income (Sales): " + calculateTotalIncome());

        System.out.println("Total Expenses (Purchases): " + calculateTotalExpenses());
    }
}
