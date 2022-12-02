//superclass
public class Bill
{
    private String billID; //data type is String because it should not be used in calculations
    private Account account;

    //no arg constructor
    public Bill()
    {
        billID = "Unassigned";
        //cost = 0;
        account = new Account();
    }

    /**
     * arg constructor
     * @param billID unique identifier for any given bill
     * @param account account associated with the bill
     */
    public Bill(String billID, /*double cost,*/ Account account)
    {
        this.billID = billID;
        this.account = new Account(account);
    }

    //override default toString()
    public String toString()
    {
        return String.format
        (
            "Bill ID: " + billID +
            "\nAccount: " +
            "\n" + account //implicit call of Account's toString() method
        );
    }

    //getters and setters
    public void setBillID(String billID)
    {
        this.billID = billID;
    }

    public String getBillID()
    {
        return billID;
    }

    public Account getAccount()
    {
        return new Account(account);
    }

    public double calculateBill()
    {
        final double NEW_BASIC_PACKAGE = 39.99;
        final double OLD_BASIC_PACKAGE = 35.99;
        final double NEW_SPORTS_PACKAGE = 29.99;
        final double OLD_SPORTS_PACKAGE = 26.99;
        final double NEW_MOVIE_PACKAGE = 19.99;
        final double OLD_MOVIE_PACKAGE = 17.99;
        final double NEW_ULTRA_PACKAGE = 79.49;
        final double OLD_ULTRA_PACKAGE = 71.54;

        final int OLD_ACCOUNT_THRESHOLD = 12; //months of service required for a loyalty discount
        double cost = 0;

        //eliminating based on suscription type first because it removes 75% of possibilities instead of the 50% eliminated based on new/old, increasing efficiency
        //no breaks after the if statements because they are exhaustive
        switch (account.getSubscriptionType())
        {
            case "Basic Channels Package":
                if (account.getActiveDuration() < OLD_ACCOUNT_THRESHOLD)
                {
                    cost = NEW_BASIC_PACKAGE;
                    break;
                }
                else if (account.getActiveDuration() >= OLD_ACCOUNT_THRESHOLD)
                {
                    cost = OLD_BASIC_PACKAGE;
                    break;
                }
            case "Sports Channels Package":
                if (account.getActiveDuration() < OLD_ACCOUNT_THRESHOLD)
                {
                    cost = NEW_SPORTS_PACKAGE;
                    break;
                }
                else if (account.getActiveDuration() >= OLD_ACCOUNT_THRESHOLD)
                {
                    cost = OLD_SPORTS_PACKAGE;
                    break;
                }
            case "Movie Channels Package":
                if (account.getActiveDuration() < OLD_ACCOUNT_THRESHOLD)
                {
                    cost = NEW_MOVIE_PACKAGE;
                    break;
                }
                else if (account.getActiveDuration() >= OLD_ACCOUNT_THRESHOLD)
                {
                    cost = OLD_MOVIE_PACKAGE;
                    break;
                }
            case "Ultra Package":
                if (account.getActiveDuration() < OLD_ACCOUNT_THRESHOLD)
                    {
                        cost = NEW_ULTRA_PACKAGE;
                        break;
                    }
                    else if (account.getActiveDuration() >= OLD_ACCOUNT_THRESHOLD)
                    {
                        cost = OLD_ULTRA_PACKAGE;
                        break;
                    }
        }

        return cost;
    }
}