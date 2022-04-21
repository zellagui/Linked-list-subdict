import java.util.Objects;

/**
 * @author Anis Zellagui
 * Comp 249, Assignement #4, return before 15/04/2022
 * This software have purpose to work with linked list.
 * @version 1.0
 */

public class Cellphone {

    private long serialNum;
    private String brand;
    private int year;
    private double price;

    //constructor
    public Cellphone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }


    //Copy constructor
    public Cellphone(Cellphone cell, long serialNumm){

        if(cell == null) throw new NullPointerException();

        this.brand = cell.brand;
        this.year = cell.year;
        this.price = cell.price;
        this.serialNum = serialNumm; //Could have issu with this statement
        //in a issue case cell.serialNum = ser
    }

    //GETTER AND SETTER
    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//      To string method
    @Override
    public String toString() {
        return "Cellphone{" +
                "serialNum=" + serialNum +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

//    Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cellphone cellphone = (Cellphone) o;
        return serialNum == cellphone.serialNum && year == cellphone.year && Double.compare(cellphone.price, price) == 0 && Objects.equals(brand, cellphone.brand);
    }

//    clone method
    public Object clone (long serialNum) throws CloneNotSupportedException {
        return new Cellphone (serialNum, this.brand, this.year, this.price);
    }


}
