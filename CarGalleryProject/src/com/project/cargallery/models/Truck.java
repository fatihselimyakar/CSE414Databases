package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS truck(
    truck_id integer primary key autoincrement not null,
    towing_capacity integer not null,
    loading_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
 */
public class Truck implements ModelInterface<Truck>{
	private int truckId;
	private int towingCapacity;
	private int loadingCapacity;
	
	private int carId;
	
	public Truck() {
		
	}

	public Truck(int truckId, int towingCapacity, int loadingCapacity, int carId) {
		super();
		this.truckId = truckId;
		this.towingCapacity = towingCapacity;
		this.loadingCapacity = loadingCapacity;
		this.carId = carId;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public int getTowingCapacity() {
		return towingCapacity;
	}

	public void setTowingCapacity(int towingCapacity) {
		this.towingCapacity = towingCapacity;
	}

	public int getLoadingCapacity() {
		return loadingCapacity;
	}

	public void setLoadingCapacity(int loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "Truck [truckId=" + truckId + ", towingCapacity=" + towingCapacity + ", loadingCapacity="
				+ loadingCapacity + ", carId=" + carId + "]";
	}
	
	@Override
	public Truck exportTableInstance(ResultSet rs) throws SQLException {
		return new Truck(rs.getInt("truck_id"),rs.getInt("towing_capacity"),rs.getInt("loading_capacity"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM truck WHERE truck_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM truck";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM truck WHERE truck_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM truck;"+"DELETE FROM sqlite_sequence WHERE name='truck';";
	}

	@Override
	public String getInsertQuery(Truck object) {
		return "INSERT INTO truck (towing_capacity, loading_capacity,car_id) VALUES ("
		        +object.getTowingCapacity()+","+object.getLoadingCapacity()+","+object.getCarId()+")";
	}
	
	@Override
	public String getUpdateQuery(Truck object,int id) {
		return "UPDATE truck SET truck_id='"+object.getTruckId()+"',towing_capacity='"+object.getTowingCapacity()+"',loading_capacity='"+object.getLoadingCapacity()+"',car_id='"+object.getCarId()+"' WHERE truck_id="+id;
	}
	
	
}
