/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.Car;
import com.services.webcarservices.CarService_Service;
import com.services.webcarservices.Exception_Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class CarService {
    
    private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.CarService.class.getName());
    
    CarService_Service carService;
    com.services.webcarservices.CarService carProxy;
    
    public CarService(){
    carService = new CarService_Service();
    carProxy = carService.getCarServicePort();
       
    }
    
    public void createCar(Car car) throws Exception_Exception {
       carProxy.createCar(car);
       LOG.info("110Create...");
    }
    
    public List<Car> getCarList() {
        return carProxy.getCarList();
    }
    
    public List<Car> getCarDetailsById(int id) {
        return carProxy.getCarDetailsById(id);
    }
    
    public List<Car> getCarDetailsByproductId(String productid) {
        return carProxy.getCarDetailsByproductId(productid);
    }
    
    
    public List<Car> getCarChevroletList() {
        return carProxy.getCarChevroletList();
    }
    public List<Car> getCarBuickList() {
        return carProxy.getCarBuickList();
    }
    public List<Car> getCarGMCList() {
        return carProxy.getCarGMCList();
    }
    public List<Car> getCarHyundaiList() {
        return carProxy.getCarHyundaiList();
    }
    
    public List<Car> getCarToyotaList() {
        return carProxy.getCarToyotaList();
    }
    
    public Car getCarId(int id) throws Exception_Exception {
        return carProxy.getCarById(id);
    }

        
    public void updateCar(Integer id, Car car){
        try {
            
            CarService_Service carServ = new CarService_Service();
            carProxy = carServ.getCarServicePort();
            carProxy.updateCarById(id,car);
            LOG.info("120Update......");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    public void deleteCar(int id){
     
       try {
           
            CarService_Service carServ = new CarService_Service();
            carProxy = carServ.getCarServicePort();            
            carProxy.deleteCarById(id);
            LOG.info("121delete...");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
        
        
    
    
    
}
