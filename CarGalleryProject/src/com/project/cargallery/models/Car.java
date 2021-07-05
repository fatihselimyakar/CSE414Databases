package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

public class Car implements ModelInterface<Car> {
     
    private int carId;
    private String mark;
    private int weight;
    private int size;
    private int consumption;
    
    private int equipmentId;
    private int appointmentId;
    private int tyreId;
    private int motorId;
    private int showroomId;
    private int truckId;
    private int scId;
    private int ncId;
    private int suvId;
    private int evId;
    
    public Car() {
    	
    }
    
    public Car(int carId, String mark, int weight, int size, int consumption, int equipmentId, int appointmentId,
			int tyreId, int motorId, int showroomId, int truckId, int scId, int ncId, int suvId, int evId) {
		super();
		this.carId = carId;
		this.mark = mark;
		this.weight = weight;
		this.size = size;
		this.consumption = consumption;
		this.equipmentId = equipmentId;
		this.appointmentId = appointmentId;
		this.tyreId = tyreId;
		this.motorId = motorId;
		this.showroomId = showroomId;
		this.truckId = truckId;
		this.scId = scId;
		this.ncId = ncId;
		this.suvId = suvId;
		this.evId = evId;
	}
    
    
    public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getConsumption() {
		return consumption;
	}


	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}


	public int getEquipmentId() {
		return equipmentId;
	}


	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}


	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}


	public int getTyreId() {
		return tyreId;
	}


	public void setTyreId(int tyreId) {
		this.tyreId = tyreId;
	}


	public int getMotorId() {
		return motorId;
	}


	public void setMotorId(int motorId) {
		this.motorId = motorId;
	}


	public int getshowroomId() {
		return showroomId;
	}


	public void setshowroomId(int showroomId) {
		this.showroomId = showroomId;
	}


	public int getTruckId() {
		return truckId;
	}


	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}


	public int getScId() {
		return scId;
	}


	public void setScId(int scId) {
		this.scId = scId;
	}


	public int getNcId() {
		return ncId;
	}


	public void setNcId(int ncId) {
		this.ncId = ncId;
	}


	public int getSuvId() {
		return suvId;
	}


	public void setSuvId(int suvId) {
		this.suvId = suvId;
	}


	public int getEvId() {
		return evId;
	}


	public void setEvId(int evId) {
		this.evId = evId;
	}

	

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", mark=" + mark + ", weight=" + weight + ", size=" + size + ", consumption="
				+ consumption + ", equipmentId=" + equipmentId + ", appointmentId=" + appointmentId + ", tyreId="
				+ tyreId + ", motorId=" + motorId + ", showroomId=" + showroomId + ", truckId=" + truckId + ", scId="
				+ scId + ", ncId=" + ncId + ", suvId=" + suvId + ", evId=" + evId + "]";
	}

	@Override
	public Car exportTableInstance(ResultSet rs) throws SQLException {
		return new Car(rs.getInt("car_id"),rs.getString("mark"),rs.getInt("weight"),rs.getInt("size"), rs.getInt("consumption"), rs.getInt("equipment_id"), rs.getInt("appointment_id"),
        		rs.getInt("tyre_id"), rs.getInt("motor_id"), rs.getInt("showroom_id"), rs.getInt("truck_id"), rs.getInt("sc_id"), rs.getInt("nc_id"), rs.getInt("suv_id"), rs.getInt("ev_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM car WHERE car_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM car";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM car WHERE car_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM car;"+" DELETE FROM sqlite_sequence WHERE name='car';";
	}

	@Override
	public String getInsertQuery(Car object) {
		return "INSERT INTO car (mark, weight, size, consumption,equipment_id,appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) VALUES ("
		        +"'"+object.getMark()+"'"+","+object.getWeight()+","+object.getSize()+","+object.getConsumption()+","+object.getEquipmentId()+","+object.getAppointmentId()+","+object.getTyreId()+","+object.getMotorId()+","+object.getshowroomId()+","+object.getTruckId()+","+object.getScId()+","+object.getNcId()+","+object.getSuvId()+","+object.getEvId()+")";
	}

	@Override
	public String getUpdateQuery(Car object,int id) {
		return "UPDATE car SET car_id='"+object.getCarId()+"',mark='"+object.getMark()+"', weight='"+object.getWeight()+"', size='"+object.getSize()+"', consumption='"+object.getConsumption()+"',equipment_id='"+object.getEquipmentId()+"',appointment_id='"+object.getAppointmentId()+"',tyre_id='"+object.getTyreId()+"',motor_id='"+object.getMotorId()+"',showroom_id='"+object.getshowroomId()+"',truck_id='"+object.getTruckId()+"',sc_id='"+object.getScId()+"',nc_id='"+object.getNcId()+"',suv_id='"+object.getSuvId()+"',ev_id='"+object.getEvId()+"' WHERE car_id="+id;
	}

}
