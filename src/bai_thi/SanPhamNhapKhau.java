package bai_thi;
//: Giá nhập khẩu, Tỉnh thành nhập, Thuế nhập khẩu.
public class SanPhamNhapKhau extends SanPham {
    double giaNhapKhau;
    String tinhThanhNhap;
    double thueNhapKhau;

    public SanPhamNhapKhau() {
        super();
    }

    public SanPhamNhapKhau(double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        this();
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau( String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }
    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" +
                ", id ='" + id + '\'' +
                ", maSanPham ='" + maSanPham + '\'' +
                ", tenSanPham ='" + tenSanPham + '\'' +
                ", giaBan =" + giaBan +
                ", soLuong =" + soLuong +
                ", nhaSanXuat ='" + nhaSanXuat + '\'' +
                "giaNhapKhau =" + giaNhapKhau +
                ", tinhThanhNhap ='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau =" + thueNhapKhau +
                '}';
    }
}
