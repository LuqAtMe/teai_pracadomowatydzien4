package home.application.teai_pracadomowatydzien4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private List<Car> carList;

    public void createDB(){
        carList.add(new Car(1L, "BMW", "M5", "Blue"));
        carList.add(new Car(2L, "Mercedes-Benz", "AMG A320", "Orange"));
        carList.add(new Car(3L, "Lexus", "IS300H", "Red"));
    }

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        createDB();
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    //Car selected by Id value
    @Override
    public Car getCarById(long id) {
        return carList.stream().filter(car -> car.getIdCar() == id).findFirst().get();
    }

    //Cars selected by Color
    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> carsByColor = new ArrayList<>();
        carList.stream().filter(car -> car.getColor().equals(color)).forEach(carsByColor::add);
        return carsByColor;
    }

    @Override
    public boolean addCar(Car car) {
        carList.add(car);
        return true;
    }

    @Override
    public boolean removeCar(Car carToRemove) {
        carList.remove(carToRemove);
        return true;
    }

    @Override
    public boolean removeCar(long id) {
        Car carToRemove = carList.stream().filter(car -> car.getIdCar() == id).findFirst().get();
        removeCar(carToRemove);
        return false;
    }

    @Override
    public boolean updateCar(long id, String color) {
        carList.stream().filter(car -> car.getIdCar()==id).findFirst().get().setColor(color);
        return true;
    }

    @Override
    public boolean updateCar(Car carToUpdate) {
        Car oldCar = carList.stream().filter(car -> car.getIdCar() == carToUpdate.getIdCar()).findFirst().get();
        int index = carList.indexOf(oldCar);
        carList.set(index, carToUpdate);
        return true;
    }
}
