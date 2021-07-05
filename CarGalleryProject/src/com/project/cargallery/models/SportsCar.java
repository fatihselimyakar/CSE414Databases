package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS sportscar(
    sc_id integer primary key autoincrement not null,
    max_speed integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
 */
public class SportsCar implements ModelInterface<SportsCar> {
	private int scId;
	private int maxSpeed;
	private int carId;
	
	public SportsCar() {}

	public SportsCar(int scId, int maxSpeed, int carId) {
		super();
		this.scId = scId;
		this.maxSpeed = maxSpeed;
		this.carId = carId;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "SportsCar [scId=" + scId + ", maxSpeed=" + maxSpeed + ", carId=" + carId + "]";
	}
	
	@Override
	public SportsCar exportTableInstance(ResultSet rs) throws SQLException {
		return new SportsCar(rs.getInt("sc_id"),rs.getInt("max_speed"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM sportscar WHERE sc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM sportscar";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM sportscar WHERE sc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM sportscar;"+"DELETE FROM sqlite_sequence WHERE name='sportscar';";
	}

	@Override
	public String getInsertQuery(SportsCar object) {
		return "INSERT INTO sportscar (max_speed,car_id) VALUES ("
		        +object.getMaxSpeed()+","+object.getCarId()+")";
	}
	
	@Override
	public String getUpdateQuery(SportsCar object,int id) {
		return "UPDATE sportscar SET sc_id='"+object.getScId()+"',max_speed='"+object.getMaxSpeed()+"',car_id='"+object.getCarId()+"' WHERE sc_id="+id;
	}
	
}
