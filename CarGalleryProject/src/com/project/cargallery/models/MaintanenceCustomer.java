package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS maintanence_customer(
    mc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);
 */
public class MaintanenceCustomer implements ModelInterface<MaintanenceCustomer> {
	private int mcId;
	private int customerId;
	
	public MaintanenceCustomer() {}

	public MaintanenceCustomer(int mcId, int customerId) {
		super();
		this.mcId = mcId;
		this.customerId = customerId;
	}

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "MaintanenceCustomer [mcId=" + mcId + ", customerId=" + customerId + "]";
	}
	
	@Override
	public MaintanenceCustomer exportTableInstance(ResultSet rs) throws SQLException {
		return new MaintanenceCustomer(rs.getInt("mc_id"),rs.getInt("customer_id"));
	}
	
	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM maintanence_customer WHERE mc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM maintanence_customer";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM maintanence_customer WHERE mc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM maintanence_customer;"+"DELETE FROM sqlite_sequence WHERE name='maintanence_customer';";
	}

	@Override
	public String getInsertQuery(MaintanenceCustomer object) {
		return "INSERT INTO maintanence_customer (customer_id) VALUES ("
		        +object.getCustomerId()+")";
	}
	
	@Override
	public String getUpdateQuery(MaintanenceCustomer object,int id) {
		return "UPDATE maintanence_customer SET mc_id='"+object.getMcId()+"',customer_id='"+object.getCustomerId()+"' WHERE mc_id="+id;
	}

}
