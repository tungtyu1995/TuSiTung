package case_study.models;
//Dịch vụ đi kèm sẽ bao gồm các thông tin: Tên dịch vụ đi kèm, Đơn vị, Giá tiền
public class ExtraSevice {
    private String extraSeviceName;
    private String unit;
    private double extraSevicePrice;

    public ExtraSevice(String extraSeviceName, String unit, double extraSevicePrice) {
        this.extraSeviceName = extraSeviceName;
        this.unit = unit;
        this.extraSevicePrice = extraSevicePrice;
    }

    public String getExtraSeviceName() {
        return extraSeviceName;
    }

    public void setExtraSeviceName(String extraSeviceName) {
        this.extraSeviceName = extraSeviceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getExtraSevicePrice() {
        return extraSevicePrice;
    }

    public void setExtraSevicePrice(double extraSevicePrice) {
        this.extraSevicePrice = extraSevicePrice;
    }

    @Override
    public String toString() {
        return "ExtraSevice{" +
                "extraSeviceName='" + extraSeviceName + '\'' +
                ", unit='" + unit + '\'' +
                ", extraSevicePrice=" + extraSevicePrice +
                '}';
    }
}
