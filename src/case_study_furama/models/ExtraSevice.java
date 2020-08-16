package case_study_furama.models;
//Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
public class ExtraSevice {
    private String extraServiceName;
    private String unit;
    private double extraServicePrice;

    public ExtraSevice(String extraServiceName, String unit, double extraServicePrice) {
        this.extraServiceName = extraServiceName;
        this.unit = unit;
        this.extraServicePrice = extraServicePrice;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getExtraServicePrice() {
        return extraServicePrice;
    }

    public void setExtraServicePrice(double extraServicePrice) {
        this.extraServicePrice = extraServicePrice;
    }

    @Override
    public String toString() {
        return "ExtraSevice{" +
                "extraSeviceName='" + extraServiceName + '\'' +
                ", unit='" + unit + '\'' +
                ", extraSevicePrice=" + extraServicePrice +
                '}';
    }
}
