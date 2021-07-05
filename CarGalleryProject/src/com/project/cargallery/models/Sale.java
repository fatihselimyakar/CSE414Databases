package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS sale(
    sale_id integer primary key autoincrement not null,
    
    sr_id integer not null,
    appointment_id integer not null,
    foreign key (sr_id) references sale_responsible(sr_id),
    foreign key (appointment_id) references appointment(appointment_id)
);
 */
public class Sale implements ModelInterface<Sale>{
	private int saleId;
	private int srId;
	private int appointmentId;
	
	public Sale() {}

	public Sale(int saleId, int srId, int appointmentId) {
		super();
		this.saleId = saleId;
		this.srId = srId;
		this.appointmentId = appointmentId;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getSrId() {
		return srId;
	}

	public void setSrId(int srId) {
		this.srId = srId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", srId=" + srId + ", appointmentId=" + appointmentId + "]";
	}
	
	@Override
	public Sale exportTableInstance(ResultSet rs) throws SQLException {
		return new Sale(rs.getInt("sale_id"),rs.getInt("sr_id"),rs.getInt("appointment_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM sale WHERE sale_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM sale";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM sale WHERE sale_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM sale;"+"DELETE FROM sqlite_sequence WHERE name='sale';";
	}

	@Override
	public String getInsertQuery(Sale object) {
		return "INSERT INTO sale (sr_id, appointment_id) VALUES ("
		        +object.getSrId()+","+object.getAppointmentId()+")";
	}
	
	@Override
	public String getUpdateQuery(Sale object,int id) {
		return "UPDATE sale SET sale_id='"+object.getSaleId()+"',sr_id='"+object.getSrId()+"',appointment_id='"+object.getAppointmentId()+"' WHERE sale_id="+id;
	}
	
}
