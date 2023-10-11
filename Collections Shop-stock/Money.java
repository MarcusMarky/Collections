
//HW1: 

public class Money<CurrencyType> {
    private Integer amount;
    private CurrencyType currency;

    public Money(Integer amount, CurrencyType currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "money amount: " + amount + ", currency: " + currency;
    }
}