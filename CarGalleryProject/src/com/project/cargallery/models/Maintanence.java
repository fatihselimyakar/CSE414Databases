package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS maintanence(
    m_id integer primary key autoincrement not null,
    delivery_time time not null,
    
    tech_id integer not null,
    appointment_id integer not null,
    foreign key (tech_id) references technician(tech_id),
    foreign key (appointment_id) references appointment(appointment_id)
    
);
 */
public class Maintanence implements ModelInterface<Maintanence> {
	private int mId;
	private Time deliveryTime;
	private int techId;
	private int appointmentId;
	
	public Maintanence() {}
	
	

	public Maintanence(int mId, Time time, int techId, int appointmentId) {
		super();
		this.mId = mId;
		this.deliveryTime = time;
		this.techId = techId;
		this.appointmentId = appointmentId;
	}



	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public Time getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Time time) {
		this.deliveryTime = time;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Maintanence [mId=" + mId + ", deliveryTime=" + deliveryTime + ", techId=" + techId + ", appointmentId=" + appointmentId
				+ "]";
	}
	
	@Override
	public Maintanence exportTableInstance(ResultSet rs) throws SQLException {
		return new Maintanence(rs.getInt("m_id"),rs.getTime("delivery_time"),rs.getInt("tech_id"),rs.getInt("appointment_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM maintanence WHERE m_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM maintanence";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM maintanence WHERE m_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM maintanence;"+"DELETE FROM sqlite_sequence WHERE name='maintanence';";
	}

	@Override
	public String getInsertQuery(Maintanence object) {
		return "INSERT INTO maintanence (delivery_time, tech_id, appointment_id) VALUES ("
		        +"'"+object.getDeliveryTime()+"'"+","+object.getTechId()+","+object.getAppointmentId()+")";
	}
	
	@Override
	public String getUpdateQuery(Maintanence object,int id) {
		return "UPDATE maintanence SET m_id='"+object.getmId()+"',delivery_time='"+object.getDeliveryTime()+"',tech_id='"+object.getTechId()+"',appointment_id='"+object.getAppointmentId()+"' WHERE m_id="+id;
	}
	
	
}
