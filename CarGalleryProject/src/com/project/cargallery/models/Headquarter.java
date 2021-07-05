package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS headquarter(
    h_name varchar(50) primary key not null,
    
    mng_id integer not null,
    foreign key (mng_id) references manager(mng_id)
);
 */

public class Headquarter implements ModelInterface<Headquarter> {
	private String hName;
	private int mngId;
	
	public Headquarter() {}

	public Headquarter(String hName, int mngId) {
		super();
		this.hName = hName;
		this.mngId = mngId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public int getMngId() {
		return mngId;
	}

	public void setMngId(int mngId) {
		this.mngId = mngId;
	}

	@Override
	public String toString() {
		return "Headquarter [hName=" + hName + ", mngId=" + mngId + "]";
	}
	
	@Override
	public Headquarter exportTableInstance(ResultSet rs) throws SQLException {
		return new Headquarter(rs.getString("h_name"),rs.getInt("mng_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM headquarter WHERE h_name=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM headquarter";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM headquarter WHERE h_name=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM headquarter;"+"DELETE FROM sqlite_sequence WHERE name='headquarter';";
	}

	@Override
	public String getInsertQuery(Headquarter object) {
		return "INSERT INTO headquarter (h_name, mng_id) VALUES ("
		        +"'"+object.gethName()+"'"+","+object.getMngId()+")";
	}
	
	@Override
	public String getUpdateQuery(Headquarter object,int id) {
		return "UPDATE headquarter SET h_name='"+object.gethName()+"',mng_id='"+object.getMngId()+"' WHERE h_name='"+object.gethName()+"'";
	}

}
