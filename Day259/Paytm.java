package Day259;

public class Paytm implements UPIPayment {
    @Override
    public String doPayment(String source, String dest) {
        String txDate = UPIPayment.datePatterns("yyyy-MM-dd");
        return null;
    }

    @Override
    public double getScratchCard() {
        return UPIPayment.super.getScratchCard();
    }
}
