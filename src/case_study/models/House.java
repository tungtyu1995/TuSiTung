package case_study.models;

//Tiêu chuẩn phòng, Mô tả tiện nghi khác, Số tầng.
public class House extends Services {
    private String roomStandard;
    private String otherFacilities;
    private int numberOfFloors;

    public House(String id, String servicesName, double usedArea, double rentAmount, int maxPerson, String renOfType, String roomStandard, String otherFacilities, int numberOfFloors) {
        super(id, servicesName, usedArea, rentAmount, maxPerson, renOfType);
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
