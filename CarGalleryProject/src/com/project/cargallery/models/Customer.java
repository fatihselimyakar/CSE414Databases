package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * 
 * CREATE TABLE IF NOT EXISTS customer(
	    customer_id integer primary key autoincrement not null,
	    money integer not null,
	    gender varchar(20) not null,
	    
	    tc_id integer,
	    mc_id integer,
	    lc_id integer,
	    sc_id integer,
	    foreign key (tc_id) references test_customer(tc_id),
	    foreign key (mc_id) references maintanence_customer(mc_id),
	    foreign key (lc_id) references leasing_customer(lc_id),
	    foreign key (sc_id) references saling_customer(sc_id)
	);
 * 
 */

public class Customer implements ModelInterface<Customer>{
	
	private int customerId;
	private String name;
	private int money;
	private String gender;
	private String email;
	private int tcId;
	private int mcId;
	private int lcId;
	private int scId;
	
	public Customer() {}
	

	public Customer(int customerId, String name, int money, String gender, String email, int tcId, int mcId, int lcId, int scId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.money = money;
		this.gender = gender;
		this.email = email;
		this.tcId = tcId;
		this.mcId = mcId;
		this.lcId = lcId;
		this.scId = scId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTcId() {
		return tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public int getLcId() {
		return lcId;
	}

	public void setLcId(int lcId) {
		this.lcId = lcId;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", money=" + money + ", gender=" + gender
				+ ", email=" + email + ", tcId=" + tcId + ", mcId=" + mcId + ", lcId=" + lcId + ", scId=" + scId + "]";
	}


	@Override
	public Customer exportTableInstance(ResultSet rs) throws SQLException {
		return new Customer(rs.getInt("customer_id"),rs.getString("name"), rs.getInt("money"), rs.getString("gender"),rs.getString("email"),rs.getInt("tc_id"), rs.getInt("mc_id"), rs.getInt("lc_id"), rs.getInt("sc_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM customer WHERE customer_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM customer";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM customer WHERE customer_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM customer;"+"DELETE FROM sqlite_sequence WHERE name='customer';";
	}

	@Override
	public String getInsertQuery(Customer object) {
		return "INSERT INTO customer (name, money, gender, email, tc_id, mc_id,lc_id,sc_id) VALUES ("
		        +"'"+object.getName()+"'"+","+object.getMoney()+","+"'"+object.getGender()+"'"+","+"'"+object.getEmail()+"'"+","+object.getTcId()+","+object.getMcId()+","+object.getLcId()+","+object.getScId()+")";
	}
	
	@Override
	public String getUpdateQuery(Customer object,int id) {
		return "UPDATE customer SET customer_id='"+object.getCustomerId()+"',name='"+object.getName()+"', money='"+object.getMoney()+"', gender='"+object.getGender()+"', email='"+object.getEmail()+"',tc_id='"+object.getTcId()+"',mc_id='"+object.getMcId()+"',lc_id='"+object.getLcId()+"',sc_id='"+object.getScId()+"' WHERE customer_id="+id;
	}

	
}
