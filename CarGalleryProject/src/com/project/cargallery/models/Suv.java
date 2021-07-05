package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS suv(
    suv_id integer primary key autoincrement not null,
    is_awd boolean not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
 */
public class Suv implements ModelInterface<Suv>{
	private int suvId;
	private boolean isAwd;
	private int carId;
	
	public Suv() {}

	public Suv(int suvId, boolean isAwd, int carId) {
		super();
		this.suvId = suvId;
		this.isAwd = isAwd;
		this.carId = carId;
	}

	public int getSuvId() {
		return suvId;
	}

	public void setSuvId(int suvId) {
		this.suvId = suvId;
	}

	public boolean isAwd() {
		return isAwd;
	}

	public void setAwd(boolean isAwd) {
		this.isAwd = isAwd;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "Suv [suvId=" + suvId + ", isAwd=" + isAwd + ", carId=" + carId + "]";
	}
	
	@Override
	public Suv exportTableInstance(ResultSet rs) throws SQLException {
		return new Suv(rs.getInt("suv_id"),rs.getBoolean("is_awd"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM suv WHERE suv_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM suv";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM suv WHERE suv_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM suv;"+"DELETE FROM sqlite_sequence WHERE name='suv';";
	}

	@Override
	public String getInsertQuery(Suv object) {
		return "INSERT INTO suv (is_awd,car_id) VALUES ("
		        +object.isAwd()+","+object.getCarId()+")";
	}
	
	@Override
	public String getUpdateQuery(Suv object,int id) {
		return "UPDATE suv SET suv_id='"+object.getSuvId()+"',is_awd='"+object.isAwd()+"',car_id='"+object.getCarId()+"' WHERE suv_id="+id;
	}
}
