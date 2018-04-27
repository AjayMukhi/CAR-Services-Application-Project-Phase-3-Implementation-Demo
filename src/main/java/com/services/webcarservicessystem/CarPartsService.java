/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.CarParts;
import com.services.webcarservices.CarPartsService_Service;
import com.services.webcarservices.Exception_Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class CarPartsService {
    
    private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.CarPartsService.class.getName());
    

    CarPartsService_Service carpartsService;
    com.services.webcarservices.CarPartsService carpartsProxy;
    
    public CarPartsService(){
    carpartsService = new CarPartsService_Service();
    carpartsProxy = carpartsService.getCarPartsServicePort();
       
    }
    
    
     public void createCarParts(CarParts carparts) throws Exception_Exception {
       carpartsProxy.createCarParts(carparts);
       LOG.info("110Create...");
    }
    
    public List<CarParts> getCarPartsList() {
        return carpartsProxy.getCarPartsList();
    }
    public List<CarParts> getCarPartsAntennaList() {
        return carpartsProxy.getCarPartsAntennaList();
    }
    public List<CarParts> getCarPartsAirCleanerList() {
        return carpartsProxy.getCarPartsAirCleanerList();
    }
    
    public List<CarParts> getCarPartsBoltList() {
        return carpartsProxy.getCarPartsBoltList();
    }
    
    public List<CarParts> getCarPartsBrakePadList() {
        return carpartsProxy.getCarPartsBrakePadList();
    }
    public List<CarParts> getCarPartsBrakeDiscList() {
        return carpartsProxy.getCarPartsBrakeDiscList();
    }
    
    public List<CarParts> getCarPartsConnectorList() {
        return carpartsProxy.getCarPartsConnectorList();
    }
    public List<CarParts> getCarPartsCoolingSystemList() {
        return carpartsProxy.getCarPartsCoolingSystemList();
    }
    public List<CarParts> getCarPartsDoorWeatherstripSteelList() {
        return carpartsProxy.getCarPartsDoorWeatherstripSteelList();
    }
    public List<CarParts> getCarPartsEngineList() {
        return carpartsProxy.getCarPartsEngineList();
    }
    
    public List<CarParts> getCarPartsElectricWiresList() {
        return carpartsProxy.getCarPartsElectricWiresList();
    }
    
    public List<CarParts> getCarPartsIgnitionList() {
        return carpartsProxy.getCarPartsIgnitionList();
    }
    public List<CarParts> getCarPartsLightBulbsList() {
        return carpartsProxy.getCarPartsLightBulbsList();
    }
    public List<CarParts> getCarPartsLEDBulbsList() {
        return carpartsProxy.getCarPartsLEDBulbsList();
    }
    
       
    public List<CarParts> getCarPartsLugNutsList() {
        return carpartsProxy.getCarPartsLugNutsList();
    }
    
    public List<CarParts> getCarPartsWashersList() {
        return carpartsProxy.getCarPartsWashersList();
    }
    
        
    public List<CarParts> getCarPartsWheelsList() {
        return carpartsProxy.getCarPartsWheelsList();
    }
    
    public List<CarParts> getCarPartsWiperBladesList() {
        return carpartsProxy.getCarPartsWiperBladesList();
    }
    
    
    
    
    //Special Parts......//
    
    public List<CarParts> getCarPartsPowerTorqueList() {
        return carpartsProxy.getCarPartsPowerTorqueList();
    }
    
    public List<CarParts> getCarPartsArmourAllList() {
        return carpartsProxy.getCarPartsArmourAllList();
    }
    
    public List<CarParts> getCarPartsACDelcoList() {
        return carpartsProxy.getCarPartsACDelcoList();
    }
          
          
    public List<CarParts> getCarPartsShellRotelaList() {
        return carpartsProxy.getCarPartsShellRotelaList();
    }
            
            
    public List<CarParts> getCarPartsTowelList() {
        return carpartsProxy.getCarPartsTowelList();
    }
    
    
    
    
public List<CarParts> getCarPartsDetailsBypartId(String partid) {
        return carpartsProxy.getCarPartsDetailsBypartId(partid);
    }
        
    public void updateCarParts(Integer id, CarParts carParts){
        try {
            
            CarPartsService_Service carpServ = new CarPartsService_Service();
            carpartsProxy = carpServ.getCarPartsServicePort();
            carpartsProxy.updateCarPartsById(id,carParts);
            LOG.info("120Update......");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    public void deleteCarParts(int id){
     
       try {
           
            CarPartsService_Service carServ = new CarPartsService_Service();
            carpartsProxy = carServ.getCarPartsServicePort();            
            carpartsProxy.deleteCarPartsById(id);
            LOG.info("121delete...");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
    


}
