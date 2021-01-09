package cn.test;

public class Phone {
    private String brand;
    private int price;

    public Phone() {
        System.out.println("Phone:no params constructor  method");
    }
    public Phone(int price) {
        this.price = price;
    }
    public Phone(int price,String brand){
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (price != phone.price) return false;
        return brand.equals(phone.brand);
    }

    public void call() {
        System.out.println("call...");
    }
    public void sendMsg() {
        System.out.println("send message...");
    }
}
