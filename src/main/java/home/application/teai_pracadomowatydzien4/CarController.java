package home.application.teai_pracadomowatydzien4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCars(Model model) {
        model.addAttribute("allCars", carService.getAllCars());
        model.addAttribute("car", new Car());
        return "cars";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/cars";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam long idCar) {
        carService.removeCar(idCar);
        return "redirect:/cars";
    }

    @GetMapping("/resetDB")
    public String resetDB() {
        carService.getAllCars().clear();
        carService.createDB();
        return "redirect:/cars";
    }

    @PostMapping("/findCarById")
    public String findCarById (@RequestParam long idCar){
        Car car = carService.getCarById(idCar);
        carService.getAllCars().clear();
        carService.addCar(car);
        return "redirect:/cars";
    }

    @PostMapping("/findCarByColor")
    public String findCarByColor(@RequestParam String color){
        List<Car> carsByColor = carService.getCarsByColor(color);
        carService.getAllCars().clear();
        carService.getAllCars().addAll(carsByColor);
        return "redirect:/cars";
    }

    @GetMapping ("/modifyCar/{idCar}")
    public String updateCar(@PathVariable long idCar, Model model){
        model.addAttribute("selectedCar",carService.getCarById(idCar));
        return "updateCar";
    }

    @PostMapping ("/modifyCar")
    public String updateCar(@ModelAttribute Car selectedCar){
        carService.updateCar(selectedCar);
        return "redirect:/cars";
    }



}
