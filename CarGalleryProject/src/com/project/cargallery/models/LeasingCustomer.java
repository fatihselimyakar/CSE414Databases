package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS leasing_customer(
    lc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);
 */
public class LeasingCustomer implements ModelInterface<LeasingCustomer> {
	private int lcId;
	private int customerId;
	
	public LeasingCustomer() {}

	public LeasingCustomer(int lcId, int customerId) {
		super();
		this.lcId = lcId;
		this.customerId = customerId;
	}

	public int getLcId() {
		return lcId;
	}

	public void setLcId(int lcId) {
		this.lcId = lcId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "LeasingCustomer [lcId=" + lcId + ", customerId=" + customerId + "]";
	}
	
	@Override
	public LeasingCustomer exportTableInstance(ResultSet rs) throws SQLException {
		return new LeasingCustomer(rs.getInt("lc_id"),rs.getInt("customer_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM leasing_customer WHERE lc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM leasing_customer";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM leasing_customer WHERE lc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM leasing_customer;"+"DELETE FROM sqlite_sequence WHERE name='leasing_customer';";
	}

	@Override
	public String getInsertQuery(LeasingCustomer object) {
		return "INSERT INTO leasing_customer (customer_id) VALUES ("
		        +object.getCustomerId()+")";
	}
	
	@Override
	public String getUpdateQuery(LeasingCustomer object,int id) {
		return "UPDATE leasing_customer SET lc_id='"+object.getLcId()+"',customer_id='"+object.getCustomerId()+"' WHERE lc_id="+id;
	}


}
