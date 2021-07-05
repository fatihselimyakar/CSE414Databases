package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS sales_responsible(
    sr_id integer primary key autoincrement not null,
    car_type varchar(50) not null,
    
    employee_id integer not null,
    sale_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (sale_id) references sale(sale_id)
);
 */
public class SalesResponsible implements ModelInterface<SalesResponsible> {
	
	private int srId;
	private String carType;
	
	private int employeeId;
	private int saleId;
	
	
	public SalesResponsible() {}
	
	public SalesResponsible(int srId, String carType, int employeeId, int saleId) {
		super();
		this.srId = srId;
		this.carType = carType;
		this.employeeId = employeeId;
		this.saleId = saleId;
	}
	public int getSrId() {
		return srId;
	}
	public void setSrId(int srId) {
		this.srId = srId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	
	@Override
	public String toString() {
		return "SalesResponsible [srId=" + srId + ", carType=" + carType + ", employeeId=" + employeeId + ", saleId="
				+ saleId + "]";
	}
	
	@Override
	public SalesResponsible exportTableInstance(ResultSet rs) throws SQLException {
		return new SalesResponsible(rs.getInt("sr_id"),rs.getString("car_type"),rs.getInt("employee_id"),rs.getInt("sale_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM sales_responsible WHERE sr_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM sales_responsible";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM sales_responsible WHERE sr_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM sales_responsible;"+"DELETE FROM sqlite_sequence WHERE name='sales_responsible';";
	}

	@Override
	public String getInsertQuery(SalesResponsible object) {
		return "INSERT INTO sales_responsible (car_type, employee_id, sale_id) VALUES ("
		        +"'"+object.getCarType()+"'"+","+object.getEmployeeId()+","+object.getSaleId()+")";
	}
	
	@Override
	public String getUpdateQuery(SalesResponsible object,int id) {
		return "UPDATE sales_responsible SET sr_id='"+object.getSrId()+"',car_type='"+object.getCarType()+"',employee_id='"+object.getEmployeeId()+"',sale_id='"+object.getSaleId()+"' WHERE sr_id="+id;
	}
	
	
}
