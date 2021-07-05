package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS saling_customer(
    sc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);
 */
public class SalingCustomer implements ModelInterface<SalingCustomer> {
	private int scId;
	private int customerId;
	
	public SalingCustomer() {}

	public SalingCustomer(int scId, int customerId) {
		super();
		this.scId = scId;
		this.customerId = customerId;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "SalingCustomer [scId=" + scId + ", customerId=" + customerId + "]";
	}
	
	@Override
	public SalingCustomer exportTableInstance(ResultSet rs) throws SQLException {
		return new SalingCustomer(rs.getInt("sc_id"),rs.getInt("customer_id"));
	}
	
	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM saling_customer WHERE sc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM saling_customer";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM saling_customer WHERE sc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM saling_customer;"+"DELETE FROM sqlite_sequence WHERE name='saling_customer';";
	}

	@Override
	public String getInsertQuery(SalingCustomer object) {
		return "INSERT INTO saling_customer (customer_id) VALUES ("
		        +object.getCustomerId()+")";
	}
	
	@Override
	public String getUpdateQuery(SalingCustomer object,int id) {
		return "UPDATE saling_customer SET sc_id='"+object.getScId()+"',customer_id='"+object.getCustomerId()+"' WHERE sc_id="+id;
	}
}
