package lop_va_doi_tuong.baitap;

import java.util.Date;
import java.util.Scanner;

public class StopWatch {
  Date satartTime;
  Date endTime;

  public void start(){
      Date date = new Date();
      this.satartTime = date;
  }
  public void stop(){
      Date date = new Date();
      this.endTime = date;
  }
  public long getElapsedTime(){
      return endTime.getSeconds() - satartTime.getSeconds();
  }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch date = new StopWatch();
        date.start();
        for (int i = 0; i< 9; i++ ){
            System.out.println("Nhap so vao");
            int test = scanner.nextInt();
            System.out.println(test);
        }
        date.stop();
        System.out.println("Chuong trinh chay mat: " + date.getElapsedTime()+"giay");
    }
}
