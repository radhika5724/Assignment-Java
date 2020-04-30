
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DAO {
    public Connection getDBConnection() { //database connection
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:Hotel.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			System.out.println("Connected");
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
    
    public ArrayList<Booking> searchByBookingId(int bookingId) throws SQLException{
        ArrayList<Booking> bookingResults= new ArrayList<Booking>();
        Connection dbConnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql= "SELECT BOOKINGNUMBER, Customer.CustomerNumber, ApartmentNumber, FIRSTNAME, LASTNAME, DateBooked, CheckInDate, CheckOutDate" +
            " FROM BOOKING INNER JOIN Customer"
                + " ON booking.CustomerNumber= Customer.customerNumber"
                + " WHERE BOOKINGNUMBER= "+bookingId+";";
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                Booking booking= new Booking(result.getInt("BookingNumber"), result.getInt("CustomerNumber"), result.getInt("ApartmentNumber"), result.getString("FirstName"), result.getString("LastName"), result.getString("DateBooked"), result.getString("CheckInDate"), result.getString("CheckOutDate"));
                bookingResults.add(booking);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return bookingResults;
    }
    
    public ArrayList<RoomManager> checkRoomManagerToday(){
        ArrayList<RoomManager> list= new ArrayList<RoomManager>();
        Connection dbConnection= null;
        Statement statement= null;
        ResultSet result= null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        String sql="SELECT * FROM RoomManager"
                + " WHERE RoomManagerDATE = '"+date+"';";
        
        try{
            dbConnection = getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                RoomManager RoomManager= new RoomManager(result.getInt("RoomManagerNumber"), result.getInt("ApartmentNumber"), result.getString("RoomManagerFault"), result.getString("RoomManagerDate"), result.getString("RoomManagerAction"));
                list.add(RoomManager);
            }
            
        }catch(SQLException e){
            e.getMessage();
        }
        
        return list;
    }
    
    public ArrayList<Booking> searchByPhoneNumber(String phoneNumber){
        ArrayList<Booking> bookingResults= new ArrayList<Booking>();
        Connection dbConnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql="SELECT BOOKINGNUMBER, Customer.CustomerNumber, ApartmentNumber, FIRSTNAME, LASTNAME, DateBooked, CheckInDate, CheckOutDate" +
            " FROM BOOKING INNER JOIN Customer"
                + " ON booking.CustomerNumber= Customer.customerNumber"
                + " WHERE PhoneNumber= '"+phoneNumber+"';";
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                Booking booking= new Booking(result.getInt("BookingNumber"), result.getInt("CustomerNumber"), result.getInt("ApartmentNumber"), result.getString("FirstName"), result.getString("LastName"), result.getString("DateBooked"), result.getString("CheckInDate"), result.getString("CheckOutDate"));
                bookingResults.add(booking);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return bookingResults;
    }
    
    public void deleteBooking(int bookingNumber){
        Connection dbConnection= null;
        Statement statement= null;
        String sql= "DELETE FROM BOOKING"
                + " WHERE BOOKINGNUMBER= "+bookingNumber;
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            statement.executeUpdate(sql);
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public ArrayList<String> getAllApartments(){
        Connection dbConnection= null;
        Statement statement=null;
        ArrayList<String> apartments= new ArrayList<String>();
        ResultSet result= null;
        String sql= "SELECT APARTMENTNUMBER FROM APARTMENT";
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                apartments.add(result.getString("ApartmentNumber"));
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return apartments;
    }
    
    public void insertRoomManager(int apartmentNumber, String RoomManagerFault, String RoomManagerAction){
        Connection dbConnection= null; 
        Statement statement= null;
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String RoomManagerDate = df.format(new Date());
        String sql= "INSERT INTO RoomManager(ApartmentNumber, RoomManagerFault, RoomManagerDate, RoomManagerAction)"
                + "VALUES (?, ?, ?, ?)";
        try{
            dbConnection= getDBConnection();
            PreparedStatement ps= dbConnection.prepareStatement(sql);
            ps.setInt(1, apartmentNumber);
            ps.setString(2, RoomManagerFault);
            ps.setString(3, RoomManagerDate);
            ps.setString(4, RoomManagerAction);
            ps.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
       
    }
    
    public void deleteRoomManager(int RoomManagerNumber){
        Connection dbConnection= null; 
        Statement statement= null;
        String sql= "DELETE FROM RoomManager WHERE RoomManagerNUMBER= "+RoomManagerNumber;
        
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            statement.executeUpdate(sql);
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    public ArrayList<RoomManager> searchRoomManagerByApartment(int ApartmentNumber){
        ArrayList<RoomManager> listResult= new ArrayList<RoomManager>();
        Connection dbConnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql="SELECT * FROM RoomManager"
                + " WHERE APARTMENTNUMBER= "+ApartmentNumber;
        
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                RoomManager RoomManager= new RoomManager(result.getInt("RoomManagerNumber"), result.getInt("ApartmentNumber"), result.getString("RoomManagerFault"), result.getString("RoomManagerDate"), result.getString("RoomManagerAction"));
                listResult.add(RoomManager);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return listResult;
    }
    
    public ArrayList<RoomManager> searchMaintenceById(int RoomManagerNumber){
         ArrayList<RoomManager> listResult= new ArrayList<RoomManager>();
        Connection dbConnection= null;
        Statement statement= null;
        ResultSet result= null;
        String sql="SELECT * FROM RoomManager"
                + " WHERE RoomManagerNUMBER= "+RoomManagerNumber;
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                RoomManager RoomManager= new RoomManager(result.getInt("RoomManagerNumber"), result.getInt("ApartmentNumber"), result.getString("RoomManagerFault"), result.getString("RoomManagerDate"), result.getString("RoomManagerAction"));
                listResult.add(RoomManager);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return listResult;
        
    }
    
    public void insertBooking(String firstName, String lastName, String address, String postCode, String phoneNumber, String checkInDate, String checkOutDate, int apartmentNumber) throws SQLException{
        Connection dbConnection= null;
        Statement statement = null;
        ResultSet result= null;
        int customerNumber=0;
        String sql= "INSERT INTO CUSTOMER (FirstName, LastName, Address, PostCode, PhoneNumber)"
        + "VALUES (?, ?, ?, ?, ?)";
        try{
            dbConnection= getDBConnection();
            PreparedStatement ps= dbConnection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, address);
            ps.setString(4, postCode);
            ps.setString(5, phoneNumber);
            ps.executeUpdate();
            System.out.println(ps.toString());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            if (dbConnection != null) {
		dbConnection.close();
            }
        }
    
        
        sql= "SELECT CustomerNumber FROM CUSTOMER"
                + " WHERE PhoneNumber ='"+phoneNumber+"'";
        try{
            dbConnection= getDBConnection();
            statement=dbConnection.createStatement();
            result= statement.executeQuery(sql);        
            
            while(result.next()){
                customerNumber= result.getInt("CustomerNumber");
                System.out.println(customerNumber);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            if(dbConnection !=null){
                dbConnection.close();
            }
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateBooked = df.format(new Date());
        
        sql= "INSERT INTO BOOKING(CustomerNumber, ApartmentNumber, DateBooked, CheckInDate, CheckOutDate)"
                + "VALUES(?, ?, ?, ?, ?)";
        try{
            dbConnection= getDBConnection();
            PreparedStatement ps2= dbConnection.prepareStatement(sql);
            ps2.setInt(1, customerNumber);
            ps2.setInt(2, apartmentNumber);
            ps2.setString(3, dateBooked);
            ps2.setString(4, checkInDate);
            ps2.setString(5, checkOutDate);
            ps2.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public String[] retrieveDetails(String phoneNumber) throws SQLException{
        String[] details= new String[4];
        Connection dbConnection=null;
        Statement statement= null;
        ResultSet result= null;
        String sql="SELECT FirstName, LastName, Address, PostCode FROM CUSTOMER"
                + " WHERE PhoneNumber= '"+phoneNumber+"';";
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                details[0]= result.getString("FirstName");
                details[1]= result.getString("LastName");
                details[2]= result.getString("Address");
                details[3]= result.getString("PostCode");
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return details;
    }
    
    public ArrayList<Integer> CheckRooms(String checkInDate, String checkOutDate) throws SQLException{
        Connection dbConnection= null;
        Statement statement = null;
        ResultSet result= null;
        ArrayList<Integer> availableApartments= new ArrayList<Integer>();
        String sql= "SELECT APARTMENTNUMBER FROM APARTMENT WHERE APARTMENTNUMBER NOT IN(SELECT APARTMENTNUMBER FROM BOOKING"
                + " WHERE (CheckInDate > '"+checkInDate+"' AND CheckInDate< '"+checkOutDate+"') "
                + "OR (CheckOutDate > '"+checkInDate+"' AND CheckOutDate < '"+checkOutDate+"')"
                + " GROUP BY APARTMENTNUMBER)";
        System.out.println(sql);
        try{
            dbConnection= getDBConnection();
            statement=dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                //String convert= Integer.toString(result.getInt("ApartmentNumber"));
                availableApartments.add(result.getInt("ApartmentNumber"));
            }
        }catch(SQLException e){
            e.getMessage();
        }
        
     return availableApartments;   
    }
    
    public ArrayList<RoomManager> getAllRoomManager() throws SQLException{
        Connection dbConnection= null;
        ArrayList<RoomManager> RoomManagerResults= new ArrayList<RoomManager>();
        Statement statement= null;
        ResultSet result= null;
        String sql= "SELECT * FROM RoomManager";
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                RoomManager RoomManager= new RoomManager(result.getInt("RoomManagerNumber"), result.getInt("ApartmentNumber"), result.getString("RoomManagerFault"), result.getString("RoomManagerDate"), result.getString("RoomManagerAction"));
                RoomManagerResults.add(RoomManager);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return RoomManagerResults;
    }
    
    
    public ArrayList<Booking> getAll()throws SQLException{
        Connection dbConnection = null;
        ArrayList<Booking> bookings= new ArrayList<Booking>();
        Statement statement= null;
	ResultSet result= null;
        String sql= "SELECT BOOKINGNUMBER, Customer.CustomerNumber, ApartmentNumber, FIRSTNAME, LASTNAME, DateBooked, CheckInDate, CheckOutDate" +
            " FROM BOOKING INNER JOIN Customer"
                + " ON booking.CustomerNumber= Customer.customerNumber";
        
        try{
            dbConnection= getDBConnection();
            statement= dbConnection.createStatement();
            result= statement.executeQuery(sql);
            
            while(result.next()){
                Booking booking= new Booking(result.getInt("BookingNumber"), result.getInt("CustomerNumber"), result.getInt("ApartmentNumber"), result.getString("FirstName"), result.getString("LastName"), result.getString("DateBooked"), result.getString("CheckInDate"), result.getString("CheckOutDate"));
                bookings.add(booking);
            }
            return bookings;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            if (result != null) {
		result.close();
            }
            if (statement != null) {
		statement.close();
            }
            if (dbConnection != null) {
		dbConnection.close();
            }
        } 
        return bookings;
    }
}
