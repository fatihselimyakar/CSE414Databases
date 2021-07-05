package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS motor(
    motor_id integer primary key autoincrement not null,
    engine_capacity double not null,
    engine_power integer not null
);
 */
public class Motor implements ModelInterface<Motor>{
	private int motorId;
	private double engineCapacity;
	private int enginePower;
	
	public Motor() {
		
	}

	public Motor(int motorId, double engineCapacity, int enginePower) {
		super();
		this.motorId = motorId;
		this.engineCapacity = engineCapacity;
		this.enginePower = enginePower;
	}

	public int getMotorId() {
		return motorId;
	}

	public void setMotorId(int motorId) {
		this.motorId = motorId;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	@Override
	public String toString() {
		return "Motor [motorId=" + motorId + ", engineCapacity=" + engineCapacity + ", enginePower=" + enginePower
				+ "]";
	}
	
	@Override
	public Motor exportTableInstance(ResultSet rs) throws SQLException {
		return new Motor(rs.getInt("motor_id"),rs.getDouble("engine_capacity"),rs.getInt("engine_power"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM motor WHERE motor_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM motor";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM motor WHERE motor_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM motor;"+"DELETE FROM sqlite_sequence WHERE name='motor';";
	}

	@Override
	public String getInsertQuery(Motor object) {
		return "INSERT INTO motor (engine_capacity, engine_power) VALUES ("
		        +object.getEngineCapacity()+","+object.getEnginePower()+")";
	}
	
	@Override
	public String getUpdateQuery(Motor object,int id) {
		return "UPDATE motor SET motor_id='"+object.getMotorId()+"',engine_capacity='"+object.getEngineCapacity()+"',engine_power='"+object.getEnginePower()+"' WHERE motor_id="+id;
	}
}
