package case_study.models;

//: Dịch vụ miễn phí đi kèm
public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String typeService, double area, double priceRents, int maxNumberOfCustomer, String typeRents, String freeService) {
        super(typeService, area, priceRents, maxNumberOfCustomer, typeRents);
    }

    @Override
    public String showInfor() {
        return "Room{" +
                ", typeSerivce='" + typeService + '\'' +
                ", area=" + area +
                ", priceRents=" + priceRents +
                ", maxNumberOfCustomer=" + maxNumberOfCustomer +
                ", typeRents='" + typeRents + '\'' +
                "freeService='" + freeService + '\'' +
                '}';
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
