package xu_ly_ngoai_le_va_debug.baitap;

public class TestIllegalTriangleException extends Exception {
    public TestIllegalTriangleException(String message) {
        super(message);
    }

    public static void checkTheTriangle(int c1, int c2, int c3) throws TestIllegalTriangleException {

        if (c1 < 0 || c2 < 0 || c3 < 0) {
            throw new TestIllegalTriangleException("Canh tam giac phai la so duong");
        }
        if (c1 + c2 <= c3 || c1 + c3 <= c2 || c2 + c3 <= c1) {
            throw new TestIllegalTriangleException("Tong 2 canh phai lon hon canh con lai");
        }

    }
}
