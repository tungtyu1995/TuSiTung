package case_study.models;

abstract class Services {
    protected String id;
    protected String servicesName;
    protected double usedArea;
    protected double rentAmount;
    protected int maxPerson;
    protected String renOfType;


    public Services( String id,String servicesName, double usedArea, double rentAmount, int maxPerson, String renOfType) {
        this.id = id;
        this.servicesName = servicesName;
        this.usedArea = usedArea;
        this.rentAmount = rentAmount;
        this.maxPerson = maxPerson;
        this.renOfType = renOfType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", servicesName='" + servicesName + '\'' +
                ", usedArea=" + usedArea +
                ", rentAmount=" + rentAmount +
                ", maxPerson=" + maxPerson +
                ", renOfType='" + renOfType + '\'' +
                '}';
    }

    public abstract void showInfor();
}

