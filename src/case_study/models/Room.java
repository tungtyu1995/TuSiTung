package case_study.models;

//: Dịch vụ miễn phí đi kèm
public class Room extends Services {
    private String freeService;

    public Room(String id, String servicesName, double usedArea, double rentAmount, int maxPerson, String renOfType, String freeService) {
        super(id, servicesName, usedArea, rentAmount, maxPerson, renOfType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
