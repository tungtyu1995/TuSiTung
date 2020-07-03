package lop_va_doi_tuong.baitap;

public class XayDungLopFan {

        final int slow = 1;
        final int medium = 2;
        int fast = 3;
        int speed = slow;
        boolean on = false;
        private double radius = 5;
        private String color = "blue";
        public XayDungLopFan (){

        }

        public int getSlow() {
            return slow;
        }

        public int getMedium() {
            return medium;
        }

        public int getFast() {
            return fast;
        }

        public void setFast(int fast) {
            this.fast = fast;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            if (isOn()) {
                return ("fan is on " + "\n" + "color: " + getColor() + "\n" +"radius: "+getRadius()+ "\n" +"speed: " + getSpeed());

            } else {
                return ("fan is off" + "\n"+ "color: " + getColor() + "\n" +"radius: "+getRadius() + "\n" +"speed: "+ getSpeed());
            }
        }
        public static   void main(String[] args) {
            System.out.println("Quạt 1 chạy");
            XayDungLopFan fan1 = new XayDungLopFan();
            fan1.setSpeed(fan1.fast);
            fan1.setRadius(10);
            fan1.setColor("yellow");
            fan1.setOn(true);
            System.out.println(fan1.toString());

            System.out.println("Quạt 2 chạy");
            XayDungLopFan fan2 = new XayDungLopFan();
            fan2.setSpeed(fan2.medium);
            fan2.setRadius(5);
            fan2.setColor("blue");
            fan2.setOn(false);
            System.out.println(fan2.toString());
        }

}





