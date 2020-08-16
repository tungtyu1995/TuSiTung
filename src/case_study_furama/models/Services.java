package case_study_furama.models;
//Tên dịch vụ, diện tích sử dụng, chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
public abstract class Services {
    protected String typeService;
    protected double area;
    protected double priceRents;
    protected int maxNumberOfCustomer;
    protected String typeRents;
    public abstract String showInforWithIndex();
    public abstract String showInfor();

    public Services() {
    }
    protected Services(String typeService, double area, double priceRents, int maxNumberOfCustomer, String typeRents) {
        this.typeService = typeService;
        this.area = area;
        this.priceRents = priceRents;
        this.maxNumberOfCustomer = maxNumberOfCustomer;
        this.typeRents = typeRents;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPriceRents() {
        return priceRents;
    }

    public void setPriceRents(double priceRents) {
        this.priceRents = priceRents;
    }

    public int getMaxNumberOfCustomer() {
        return maxNumberOfCustomer;
    }

    public void setMaxNumberOfCustomer(int maxNumberOfCustomer) {
        this.maxNumberOfCustomer = maxNumberOfCustomer;
    }

    public String getTypeRents() {
        return typeRents;
    }

    public void setTypeRents(String typeRents) {
        this.typeRents = typeRents;
    }
}

