package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS leasing_responsible(
    lr_id integer primary key autoincrement not null,
    
    employee_id integer not null,
    leasing_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (leasing_id) references leasing(leasing_id)
);
 */
public class LeasingResponsible implements ModelInterface<LeasingResponsible> {
	
	private int lrId;
	
	private int employeeId;
	private int leasingId;
	
	public LeasingResponsible() {}
			
	public LeasingResponsible(int lrId, int employeeId, int leasingId) {
		super();
		this.lrId = lrId;
		this.employeeId = employeeId;
		this.leasingId = leasingId;
	}

	public int getLrId() {
		return lrId;
	}

	public void setLrId(int lrId) {
		this.lrId = lrId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getLeasingId() {
		return leasingId;
	}

	public void setLeasingId(int leasingId) {
		this.leasingId = leasingId;
	}

	@Override
	public String toString() {
		return "LeasingResponsible [lrId=" + lrId +  ", employeeId=" + employeeId + ", leasingId="
				+ leasingId + "]";
	}
	
	@Override
	public LeasingResponsible exportTableInstance(ResultSet rs) throws SQLException {
		return new LeasingResponsible(rs.getInt("lr_id"),rs.getInt("employee_id"),rs.getInt("leasing_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM leasing_responsible WHERE lr_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM leasing_responsible";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM leasing_responsible WHERE lr_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM leasing_responsible;"+"DELETE FROM sqlite_sequence WHERE name='leasing_responsible';";
	}

	@Override
	public String getInsertQuery(LeasingResponsible object) {
		return "INSERT INTO leasing_responsible (employee_id, leasing_id) VALUES ("
		        +object.getEmployeeId()+","+object.getLeasingId()+")";
	}
	
	@Override
	public String getUpdateQuery(LeasingResponsible object,int id) {
		return "UPDATE leasing_responsible SET lr_id='"+object.getLrId()+"',employee_id='"+object.getEmployeeId()+"',leasing_id='"+object.getLeasingId()+"' WHERE lr_id="+id;
	}
	
	
}
