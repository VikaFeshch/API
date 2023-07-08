package data;

public enum TypeCur {

    EUR("EUR"),
    USD("USD"),
    CAD("CAD");
    String currency;


    TypeCur(String currency) {
        this.currency = currency;
    }


    public String getCurrency() {
        System.out.println("*****"+currency);
        return currency;
    }
}
