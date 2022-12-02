//subclass
public class Account
{
    private String customerName;
    private String subscriptionType;
    private int activeDuration;

    //no arg constructor
    public Account()
    {
        customerName = "Unassigned";
        subscriptionType = "None";
        activeDuration = 0;
    }

    /**
     * arg constructor
     * @param customerName name of the customer who owns the package
     * @param subscriptionType package purchased by the customer (Basic, Sports, Movie, Ultra)
     * @param activeDuration amount of time in months that the account has been active
     */
    public Account(String customerName, String subscriptionType, int activeDuration)
    {
        this.customerName = customerName;
        this.subscriptionType = subscriptionType;
        this.activeDuration = activeDuration;
    }

    //copy constructor
    public Account(Account original)
    {
        this.customerName = original.customerName;
        this.subscriptionType = original.subscriptionType;
        this.activeDuration = original.activeDuration;
    }

    //override default toString()
    public String toString()
    {
        return String.format
        (
            "\tCustomer name: " + customerName +
            "\n\tSubscription type: " + subscriptionType +
            "\n\tActive duration: " + activeDuration + " months"
        );
    }

    //getters and setters
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setSubscriptionType(String subscriptionType)
    {
        this.subscriptionType = subscriptionType;
    }

    public String getSubscriptionType()
    {
        return subscriptionType;
    }

    public void setActiveDuration(int activeDuration)
    {
        this.activeDuration = activeDuration;
    }

    public int getActiveDuration()
    {
        return activeDuration;
    }
}