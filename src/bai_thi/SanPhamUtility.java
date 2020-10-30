package bai_thi;

import demo.character1.WorkerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamUtility {
    private static List<SanPham> listSanPham = new ArrayList<>();
    private static final String FILE_PATH = "D:\\C0520G1-Tung\\src\\bai_thi\\SanPham.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,ma san pham,ten san pham,gia ban,so luong,nha san xuat,gia nhap khau,tinh thanh nhap, thue nhap khau,gia xuat khau, quoc gia nhap san pham";

    private static File file = new File(FILE_PATH);


    public static List<SanPham> readFile() {
        try {

            listSanPham.clear();


            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            int id;
            String maSanPham;
            String tenSanPham;
            double giaBan;
            int soLuong;
            String nhaSanXuat;
            double giaNhapKhau;
            String tinhThanhNhap;
            double thueNhapKhau;
            double giaXuatKhau;
            String quocGiaNhapSanPham;


            SanPham outputSanPham;
            String[] sanPhamStringArray;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sanPhamStringArray = line.split(",");
                if ("id".compareTo(sanPhamStringArray[0]) == 0) {
                    continue;
                }
                id = Integer.parseInt(sanPhamStringArray[0]) ;
                maSanPham = sanPhamStringArray[1];
                tenSanPham = sanPhamStringArray[2];
                giaBan = Double.parseDouble(sanPhamStringArray[3]) ;
                soLuong = Integer.parseInt(sanPhamStringArray[4]);
                nhaSanXuat =sanPhamStringArray[5];
                giaNhapKhau = Double.parseDouble(sanPhamStringArray[6]);
                tinhThanhNhap = sanPhamStringArray[7];
                thueNhapKhau = Double.parseDouble(sanPhamStringArray[8]);
                giaXuatKhau = Double.parseDouble(sanPhamStringArray[9]);
                quocGiaNhapSanPham= sanPhamStringArray[10];
               if (giaNhapKhau > 0){
                outputSanPham = new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);

                listSanPham.add(outputSanPham);
            }else {
                   outputSanPham = new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
                   listSanPham.add(outputSanPham);
               }
            }


            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        return listSanPham;
    }

    //Write the worker file
    public static void writeFile(List<SanPham> listSanPham ) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            //Create a stream and link to source
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            //Write the file
            if (!listSanPham.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(FILE_HEADER);
                stringBuilder.append(NEW_LINE_SEPARATOR);

                for (SanPham sanPham : listSanPham) {

                }

                bufferedWriter.append(stringBuilder);

            } else {
                System.out.println("The list is empty. Please add new worker...");
            }

            //Close the stream
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
