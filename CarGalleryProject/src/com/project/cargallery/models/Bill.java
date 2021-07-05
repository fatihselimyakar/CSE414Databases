package com.project.cargallery.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

public class Bill implements ModelInterface<Bill>{
	private int billId;
	private Date billDate;
	private int cost;
	private int appointmentId;
	private int customerId;
	
	public Bill() {}

	public Bill(int billId, Date billDate, int cost, int appointmentId, int customerId) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.cost = cost;
		this.appointmentId = appointmentId;
		this.customerId = customerId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", cost=" + cost + ", appointmentId="
				+ appointmentId + ", customerId=" + customerId + "]";
	}
	
	@Override
	public Bill exportTableInstance(ResultSet rs) throws SQLException {
		return new Bill(rs.getInt("bill_id"),rs.getDate("bill_date"), rs.getInt("cost"), rs.getInt("appointment_id"),rs.getInt("customer_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM bill WHERE bill_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM bill";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM bill WHERE bill_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM bill;"+"DELETE FROM sqlite_sequence WHERE name='bill';";
	}

	@Override
	public String getInsertQuery(Bill object) {
		return "INSERT INTO bill (bill_date, cost, appointment_id, customer_id) VALUES ("
		        +"'"+object.getBillDate()+"'"+","+object.getCost()+","+object.getAppointmentId()+","+object.getCustomerId()+")";
	}

	@Override
	public String getUpdateQuery(Bill object,int id) {
		return "UPDATE bill SET bill_id='"+object.getBillId()+"',bill_date='"+object.getBillId()+"', cost='"+object.getCost()+"', appointment_id='"+object.getAppointmentId()+"', customer_id='"+object.getCustomerId()+"' WHERE bill_id="+id;
	}

	
}
