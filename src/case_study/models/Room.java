package case_study.models;

//: Dịch vụ miễn phí đi kèm
public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String typeService, double area, double priceRents, int maxNumberOfCustomer, String typeRents, String freeService) {
        super(typeService, area, priceRents, maxNumberOfCustomer, typeRents);
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    @Override
    public String showInfor() {
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s", typeService, area, priceRents, maxNumberOfCustomer, typeRents, freeService);

    }
    public String showInforWithIndex(){
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","", typeService, area, priceRents, maxNumberOfCustomer, typeRents, freeService);
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                ", typeService='" + typeService + '\'' +
                ", area=" + area +
                ", priceRents=" + priceRents +
                ", maxNumberOfCustomer=" + maxNumberOfCustomer +
                ", typeRents='" + typeRents + '\'' +
                '}';
    }
}
