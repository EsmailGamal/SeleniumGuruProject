package utilities.models;

public class CustomerData {
    public String customerId;
    public String lastUpdated;

    public CustomerData() {
    }

    public CustomerData(String customerId, String lastUpdated) {
        this.customerId = customerId;
        this.lastUpdated = lastUpdated;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

