package com.project.cargallery.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS leasing(
    leasing_id integer primary key autoincrement not null,
    delivery_date date not null,
    
    lr_id integer not null,
    appointment_id integer not null,
    foreign key (lr_id) references leasing_responsible(lr_id),
    foreign key (appointment_id) references appointment(appointment_id)
);
 */
public class Leasing implements ModelInterface<Leasing>{
	private int leasingId;
	private Date deliveryDate;
	private int lrId;
	private int appointmentId;
	
	public Leasing() {}

	public Leasing(int leasingId, Date deliveryDate, int lrId, int appointmentId) {
		super();
		this.leasingId = leasingId;
		this.deliveryDate = deliveryDate;
		this.lrId = lrId;
		this.appointmentId = appointmentId;
	}

	public int getLeasingId() {
		return leasingId;
	}

	public void setLeasingId(int leasingId) {
		this.leasingId = leasingId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getLrId() {
		return lrId;
	}

	public void setLrId(int lrId) {
		this.lrId = lrId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Leasing [leasingId=" + leasingId + ", deliveryDate=" + deliveryDate + ", lrId=" + lrId
				+ ", appointmentId=" + appointmentId + "]";
	}
	
	@Override
	public Leasing exportTableInstance(ResultSet rs) throws SQLException {
		return new Leasing(rs.getInt("leasing_id"),rs.getDate("delivery_date"),rs.getInt("lr_id"),rs.getInt("appointment_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM leasing WHERE leasing_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM leasing";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM leasing WHERE leasing_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM leasing;"+"DELETE FROM sqlite_sequence WHERE name='leasing';";
	}

	@Override
	public String getInsertQuery(Leasing object) {
		return "INSERT INTO leasing (delivery_date,lr_id, appointment_id) VALUES ("
		        +"'"+object.getDeliveryDate()+"'"+","+object.getLrId()+","+object.getAppointmentId()+")";
	}
	
	@Override
	public String getUpdateQuery(Leasing object,int id) {
		return "UPDATE leasing SET leasing_id='"+object.getLeasingId()+"',delivery_date='"+object.getDeliveryDate()+"', lr_id='"+object.getLrId()+"', appointment_id='"+object.getAppointmentId()+"' WHERE leasing_id="+id;
	}
}
