package home.application.teai_pracadomowatydzien4;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car getCarById(long id);

    List<Car> getCarsByColor(String color);

    void createDB();

    boolean addCar(Car car);

    boolean removeCar(Car car);

    boolean removeCar(long id);

    boolean updateCar(long id, String color);

    boolean updateCar(Car car);
}
