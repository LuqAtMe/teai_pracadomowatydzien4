package home.application.teai_pracadomowatydzien4;

public class Car {

    private long idCar;
    private String mark;
    private String model;
    private String color;

    public Car() {
    }

    public Car(long idCar, String mark, String model, String color) {
        this.idCar = idCar;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
