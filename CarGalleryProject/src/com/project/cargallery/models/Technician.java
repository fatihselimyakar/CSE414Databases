package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS technician(
    tech_id integer primary key autoincrement not null,
    mastery varchar(50) not null,
    
    employee_id integer not null,
    m_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (m_id) references maintanence(m_id)
);
 */
public class Technician implements ModelInterface<Technician> {
	
	private int techId;
	private String mastery;
	private int employeeId;
	private int mId;
	
	
	public Technician() {}

	public Technician(int techId, String mastery, int employeeId, int mId) {
		super();
		this.techId = techId;
		this.mastery = mastery;
		this.employeeId = employeeId;
		this.mId = mId;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getMastery() {
		return mastery;
	}

	public void setMastery(String mastery) {
		this.mastery = mastery;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}
	

	@Override
	public String toString() {
		return "Technician [techId=" + techId + ", mastery=" + mastery + ", employeeId=" + employeeId + ", mId=" + mId
				+ "]";
	}

	@Override
	public Technician exportTableInstance(ResultSet rs) throws SQLException {
		return new Technician(rs.getInt("tech_id"),rs.getString("mastery"),rs.getInt("employee_id"),rs.getInt("m_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM technician WHERE tech_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM technician";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM technician WHERE tech_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM technician;"+"DELETE FROM sqlite_sequence WHERE name='technician';";
	}

	@Override
	public String getInsertQuery(Technician object) {
		return "INSERT INTO technician (mastery, employee_id, m_id) VALUES ("
		        +"'"+object.getMastery()+"'"+","+object.getEmployeeId()+","+object.getmId()+")";
	}
	
	@Override
	public String getUpdateQuery(Technician object,int id) {
		return "UPDATE technician SET tech_id='"+object.getTechId()+"',mastery='"+object.getMastery()+"',employee_id='"+object.getEmployeeId()+"',m_id='"+object.getmId()+"' WHERE tech_id="+id;
	}
}
