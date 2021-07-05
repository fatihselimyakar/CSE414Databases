package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS department(
    dept_name varchar(50) primary key not null,
    building varchar(50) not null,
    budget integer not null,
    
    showroom_id integer,
    employee_id integer,
    h_name varchar(50) not null,
    foreign key (showroom_id) references showroom(showroom_id),
    foreign key (employee_id) references employee(employee_id),
    foreign key (h_name) references hearquarter(h_name)
);
 */
public class Department implements ModelInterface<Department>{
	private String deptName;
	private String building;
	private int budget;

	private String hName;
	
	public Department() {}

	public Department(String deptName, String building, int budget, String hName) {
		super();
		this.deptName = deptName;
		this.building = building;
		this.budget = budget;
		this.hName = hName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", building=" + building + ", budget=" + budget + ", hName=" + hName + "]";
	}
	
	@Override
	public Department exportTableInstance(ResultSet rs) throws SQLException {
		return new Department(rs.getString("dept_name"),rs.getString("building"),rs.getInt("budget"),rs.getString("h_name"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM department WHERE dept_name=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM department";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM department WHERE dept_name=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM department;"+"DELETE FROM sqlite_sequence WHERE name='department';";
	}

	@Override
	public String getInsertQuery(Department object) {
		return "INSERT INTO department (dept_name, building, budget, h_name) VALUES ("
		        +"'"+object.getDeptName()+"'"+","+"'"+object.getBuilding()+"'"+","+object.getBudget()+","+"'"+object.gethName()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Department object,int id) {
		return "UPDATE department SET dept_name='"+object.getDeptName()+"',building='"+object.getBuilding()+"', budget='"+object.getBudget()+"', h_name='"+object.gethName()+"' WHERE dept_name='"+object.getDeptName()+"'";
	}

}
