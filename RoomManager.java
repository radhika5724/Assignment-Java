/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//"Room Number", "Apartment Number", "Room Name", "Room Avability", "Date"
public class RoomManager {
    private int roomNumber;
    private int apartmentNumber;
    private String roomName;
    private String roomAvail;
    private String roomdate;
    
    public RoomManager(int roomNumber, int apartmentNumber, String roomName, String roomAvail, String date){
        this.roomNumber= roomNumber;
        this.apartmentNumber= apartmentNumber;
        this.roomName= roomName;
        this.roomAvail= roomAvail;
        this.roomdate= date;
    }
    
    public void setMaintenanceNumber(int maintenanceNumber){
        this.roomNumber= maintenanceNumber;
    }
    
    public int getMaintenanceNumber(){
        return roomNumber;
    }
    
    public void setApartmentNumber(int apartmentNumber){
        this.apartmentNumber= apartmentNumber;
    }
    
    public int getApartmentNumber(){
        return apartmentNumber;
    }
    
    public void setMaintenanceFault(String maintenanceFault){
        this.roomName= maintenanceFault;
    }
    
    public String getMaintenanceFault(){
        return roomName;
    }
    
    public void setMaintenanceAction(String maintenanceAction){
        this.roomdate= maintenanceAction;
    }
    
    public String getMaintenanceAction(){
        return roomdate;
    }
    
    public void setMaintenanceDate(String maintenanceDate){
        this.roomAvail= maintenanceDate;
    }
    
    public String getMaintenanceDate(){
        return roomAvail;
    }
}
