package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS manager(
    mng_id integer primary key autoincrement not null,
    graduated_unv varchar(50) not null,
    
    employee_id integer not null,
    h_name varchar(50) not null,
    foreign key (employee_id) references employee(employee_id),
    foreign key (h_name) references headquarter(h_name)
);
 */
public class Manager implements ModelInterface<Manager> {
	
	private int mngId;
	private String graduatedUnv;
	private int employeeId;
	private String hName;
	
	public Manager() {}
	
	public Manager(int mngId, String graduatedUnv, int employeeId, String hName) {
		super();
		this.mngId = mngId;
		this.graduatedUnv = graduatedUnv;
		this.employeeId = employeeId;
		this.hName = hName;
	}

	public int getMngId() {
		return mngId;
	}

	public void setMngId(int mngId) {
		this.mngId = mngId;
	}

	public String getGraduatedUnv() {
		return graduatedUnv;
	}

	public void setGraduatedUnv(String graduatedUnv) {
		this.graduatedUnv = graduatedUnv;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}
	

	@Override
	public String toString() {
		return "Manager [mngId=" + mngId + ", graduatedUnv=" + graduatedUnv + ", employeeId=" + employeeId + ", hName="
				+ hName + "]";
	}

	@Override
	public Manager exportTableInstance(ResultSet rs) throws SQLException {
		return new Manager(rs.getInt("mng_id"),rs.getString("graduated_unv"),rs.getInt("employee_id"),rs.getString("h_name"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM manager WHERE mng_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM manager";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM manager WHERE mng_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM manager;"+"DELETE FROM sqlite_sequence WHERE name='manager';";
	}

	@Override
	public String getInsertQuery(Manager object) {
		return "INSERT INTO manager (graduated_unv, employee_id, h_name) VALUES ("
		        +"'"+object.getGraduatedUnv()+"'"+","+object.getEmployeeId()+","+"'"+object.gethName()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Manager object,int id) {
		return "UPDATE manager SET mng_id='"+object.getMngId()+"',graduated_unv='"+object.getGraduatedUnv()+"',employee_id='"+object.getEmployeeId()+"',h_name='"+object.gethName()+"' WHERE mng_id="+id;
	}
}
