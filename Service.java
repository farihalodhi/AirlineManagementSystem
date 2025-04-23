package oop_project;

public class Service {
    protected String serviceType;
    protected double charges;

    public Service(String serviceType, double charges) {
        this.serviceType = serviceType;
        this.charges = charges;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void applyService(String serviceType, double charges) {}
}
