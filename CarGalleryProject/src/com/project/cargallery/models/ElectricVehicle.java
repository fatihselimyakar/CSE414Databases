package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS electricvehicle(
    ev_id integer primary key autoincrement not null,
    battery_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
 */
public class ElectricVehicle implements ModelInterface<ElectricVehicle>{
	private int evId;
	private int batteryCapacity;
	
	private int carId;
	
	public ElectricVehicle() {}

	public ElectricVehicle(int primaryKey, int batteryCapacity, int carId) {
		super();
		this.evId = primaryKey;
		this.batteryCapacity = batteryCapacity;
		this.carId = carId;
	}

	public int getEvId() {
		return evId;
	}

	public void setEvId(int primaryKey) {
		this.evId = primaryKey;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "ElectricVehicle [evId=" + evId + ", batteryCapacity=" + batteryCapacity + ", carId=" + carId
				+ "]";
	}
	
	@Override
	public ElectricVehicle exportTableInstance(ResultSet rs) throws SQLException {
		return new ElectricVehicle(rs.getInt("ev_id"),rs.getInt("battery_capacity"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM electricvehicle WHERE ev_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM electricvehicle";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM electricvehicle WHERE ev_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM electricvehicle;"+"DELETE FROM sqlite_sequence WHERE name='electricvehicle';";
	}

	@Override
	public String getInsertQuery(ElectricVehicle object) {
		return "INSERT INTO electricvehicle (battery_capacity,car_id) VALUES ("
		        +object.getBatteryCapacity()+","+object.getCarId()+")";
	}
	
	@Override
	public String getUpdateQuery(ElectricVehicle object,int id) {
		return "UPDATE electricvehicle SET ev_id='"+object.getEvId()+"',battery_capacity='"+object.getBatteryCapacity()+"', car_id='"+object.getCarId()+"' WHERE ev_id="+id;
	}

}
