package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS test_customer(
    tc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);
 */
public class TestCustomer implements ModelInterface<TestCustomer> {

	private int tcId;
	private int customerId;
	
	public TestCustomer() {}

	public TestCustomer(int tcId, int customerId) {
		super();
		this.tcId = tcId;
		this.customerId = customerId;
	}

	public int getTcId() {
		return tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "TestCustomer [tcId=" + tcId + ", customerId=" + customerId + "]";
	}
	
	@Override
	public TestCustomer exportTableInstance(ResultSet rs) throws SQLException {
		return new TestCustomer(rs.getInt("tc_id"),rs.getInt("customer_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM test_customer WHERE tc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM test_customer";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM test_customer WHERE tc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM test_customer;"+"DELETE FROM sqlite_sequence WHERE name='test_customer';";
	}

	@Override
	public String getInsertQuery(TestCustomer object) {
		return "INSERT INTO test_customer (customer_id) VALUES ("
		        +object.getCustomerId()+")";
	}
	
	@Override
	public String getUpdateQuery(TestCustomer object,int id) {
		return "UPDATE test_customer SET tc_id='"+object.getTcId()+"',customer_id='"+object.getCustomerId()+"' WHERE tc_id="+id;
	}

}
