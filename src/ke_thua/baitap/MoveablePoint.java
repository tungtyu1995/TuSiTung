package ke_thua.baitap;

public class MoveablePoint extends Point {
    float xSpeed = 0.0f;
    float ySpeed = 0.0f;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {

    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float[] getSpeed() {
        float[] arr = {getxSpeed(), getySpeed()};
        return arr;
    }

    public MoveablePoint move() {
        super.setXY(super.getX() + this.xSpeed, super.getY() + this.ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + "speed = " + (xSpeed + "," + ySpeed);
    }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint.toString());

        MoveablePoint moveablePoint1 = new MoveablePoint();
        moveablePoint1 = new MoveablePoint(1, 3, 5, 7);
        System.out.println(moveablePoint1);
        moveablePoint1.move();
        System.out.println(moveablePoint1.toString());
    }
}
