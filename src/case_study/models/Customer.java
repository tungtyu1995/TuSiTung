package case_study.models;

public class Customer {
    private String nameCustomer;
    private String dayOfBirth;
    private String gender;
    private int idCustomer;
    private int phoneNumberCustomer;
    private String typeOfCustomer;
    private String addressCustomer;
    private String email;
    Services services;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(String nameCustomer, String dayOfBirth, String gender, int idCustomer, int phoneNumberCustomer, String email, String typeOfCustomer, String addressCustomer) {
        this.nameCustomer = nameCustomer;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCustomer = idCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.typeOfCustomer = typeOfCustomer;
        this.addressCustomer = addressCustomer;
        this.email = email;
    }

    Customer() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(int phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String showInfor() {
        return "Customer{" +
                "nameCustomer= " + nameCustomer + '\'' +
                ", dayOfBirth= " + dayOfBirth + '\'' +
                ", gender= " + gender + '\'' +
                ", idCustomer= " + idCustomer +
                ", phoneNumberCustomer= " + phoneNumberCustomer +
                ", typeOfCustomer= " + typeOfCustomer + '\'' +
                ", addressCustomer= " + addressCustomer + '\'' +
                ", services= " + services +
                '}';
    }
}
