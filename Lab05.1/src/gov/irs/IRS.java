package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    //static factory method to obtain the instance - it will never get prematurely instantiated
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
