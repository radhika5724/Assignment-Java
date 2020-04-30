/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Booking {
    private int bookingNumber;
    private int customerNumber;
    private int apartmentNumber;
    private String FirstName;
    private String LastName;
    private String dateBooked;
    private String checkInDate;
    private String checkOutDate;
    
    Booking(int bookingNumber, int customerNumber, int apartmentNumber, String FirstName, String LastName, String dateBooked, String checkInDate, String checkOutDate){
        this.bookingNumber= bookingNumber;
        this.customerNumber= customerNumber;
        this.apartmentNumber= apartmentNumber;
        this.FirstName= FirstName;
        this.LastName= LastName;
        this.dateBooked= dateBooked;
        this.checkInDate= checkInDate;
        this.checkOutDate= checkOutDate;
    }
    
    public int getBookingNumber(){
        return bookingNumber;
    }
    
    public int getCustomerNumber(){
        return customerNumber;
    }
    
    public int getApartmentNumber(){
        return apartmentNumber;
    }
    
    public String getDateBooked(){
        return dateBooked;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }
   
    public void setCheckInDate(String chkInDate){
        checkInDate= chkInDate;
    }
    
    public String getCheckInDate(){
        return checkInDate;
    }
    
    public void setCheckOutDate(String chkOutDate){
        checkOutDate= chkOutDate;
    }
    
    public String getCheckOutDate(){
        return checkOutDate;
    }
}
