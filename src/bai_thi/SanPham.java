package bai_thi;

public abstract class SanPham {
    public int id;
    public String maSanPham;
    public String tenSanPham;
    public double giaBan;
    public int soLuong;
    public String nhaSanXuat;

    public SanPham() {
        id++;
    }

    public SanPham(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat) {
        this();
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id ='" + id + '\'' +
                ", maSanPham ='" + maSanPham + '\'' +
                ", tenSanPham ='" + tenSanPham + '\'' +
                ", giaBan =" + giaBan +
                ", soLuong =" + soLuong +
                ", nhaSanXuat ='" + nhaSanXuat + '\'' +
                '}';
    }
}
