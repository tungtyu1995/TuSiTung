package io_binaryfile_serialization.baitap.copy_file_nhiphan;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao duong dan file goc: ");
        String sourceFile = scanner.nextLine();
        System.out.println("Nhap vao duong dan file dich: ");
        String targetFile = scanner.nextLine();
        FileCopy Object1 = new FileCopy();
        Object1.copyFileBinary(sourceFile, targetFile);
    }
    public void copyFileBinary(String sourceFile, String targetFile) throws IOException {
        File file = new File(sourceFile);
        FileInputStream fileSource = null;
        ObjectInputStream objectInputStreamSource = null;
        FileInputStream fileInputTarget = null;
        FileOutputStream fileOutputTarget = null;
        ObjectOutputStream objectOutputStreamTarget = null;
        ObjectInputStream objectInputStreamTarget = null;
        try {
            fileSource = new FileInputStream(sourceFile);
            objectInputStreamSource = new ObjectInputStream(fileSource);
            fileOutputTarget = new FileOutputStream(targetFile);
            objectOutputStreamTarget = new ObjectOutputStream(fileOutputTarget);
            System.out.println("Du lieu cua file goc: ");
            Object objectReadSoure = objectInputStreamSource.readObject();
            System.out.println(objectReadSoure);

            objectOutputStreamTarget.writeObject(objectReadSoure);
            fileInputTarget = new FileInputStream(targetFile);
            objectInputStreamTarget = new ObjectInputStream(fileInputTarget);

            System.out.println("Du lieu cua file dich:  ");
            System.out.println(objectInputStreamTarget.readObject());
            System.out.println("So byte cua file: "+file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileSource.close();
            fileOutputTarget.close();
            objectOutputStreamTarget.close();
            objectInputStreamSource.close();
            objectInputStreamTarget.close();
        }
    }


}
