package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS reception(
    rec_id integer primary key autoincrement not null,
    phone_number varchar(50) not null,
    
    employee_id integer not null,
    appointment_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (appointment_id) references appointment(appointment_id)
);
 */

public class Reception implements ModelInterface<Reception>  {
	private int recId;
	private String phoneNumber;
	private int employeeId;
	private int appointmentId;
	
	public Reception(int recId, String phoneNumber, int employeeId, int appointmentId) {
		super();
		this.recId = recId;
		this.phoneNumber = phoneNumber;
		this.employeeId = employeeId;
		this.appointmentId = appointmentId;
	}

	public Reception() {
		// TODO Auto-generated constructor stub
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Reception [recId=" + recId + ", phoneNumber=" + phoneNumber + ", employeeId=" + employeeId
				+ ", appointmentId=" + appointmentId + "]";
	}
	
	@Override
	public Reception exportTableInstance(ResultSet rs) throws SQLException {
		return new Reception(rs.getInt("rec_id"),rs.getString("phone_number"),rs.getInt("employee_id"),rs.getInt("appointment_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM reception WHERE rec_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM reception";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM reception WHERE rec_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM reception;"+"DELETE FROM sqlite_sequence WHERE name='reception';";
	}

	@Override
	public String getInsertQuery(Reception object) {
		return "INSERT INTO reception (phone_number, employee_id, appointment_id) VALUES ("
		        +"'"+object.getPhoneNumber()+"'"+","+object.getEmployeeId()+","+object.getAppointmentId()+")";
	}
	
	@Override
	public String getUpdateQuery(Reception object,int id) {
		return "UPDATE reception SET rec_id='"+object.getRecId()+"',phone_number='"+object.getPhoneNumber()+"',employee_id='"+object.getEmployeeId()+"',appointment_id='"+object.getAppointmentId()+"' WHERE rec_id="+id;
	}
	
	
}
