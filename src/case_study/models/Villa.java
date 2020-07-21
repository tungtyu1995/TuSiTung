package case_study.models;

public class Villa extends Services {

    @Override
    public void showInformation() {
        System.out.println("Your Services:");
        System.out.println("Id of services: "+super.id);
        System.out.println("Name of services: "+super.servicesName);
        System.out.println("Area of services: "+super.usedArea + " m2");
        System.out.println("Cost of services: "+super.rentAmount);
        System.out.println("Maximum of services: "+super.maxPerson);
        System.out.println("Type of services: "+super.renOfType);


    }
}
