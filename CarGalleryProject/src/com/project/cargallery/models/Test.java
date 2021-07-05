package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS test(
    test_id integer primary key autoincrement not null,
    test_interval integer not null,
    
    appointment_id integer not null,
    foreign key (appointment_id) references appointment(appointment_id)
);
 */
public class Test implements ModelInterface<Test>{
	private int testId;
	private int testInterval;
	private int appointmentId;
	
	public Test() {}

	public Test(int testId, int testInterval, int appointmentId) {
		super();
		this.testId = testId;
		this.testInterval = testInterval;
		this.appointmentId = appointmentId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getTestInterval() {
		return testInterval;
	}

	public void setTestInterval(int testInterval) {
		this.testInterval = testInterval;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testInterval=" + testInterval + ", appointmentId=" + appointmentId + "]";
	}
	
	@Override
	public Test exportTableInstance(ResultSet rs) throws SQLException {
		return new Test(rs.getInt("test_id"),rs.getInt("test_interval"),rs.getInt("appointment_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM test WHERE test_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM test";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM test WHERE test_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM test;"+"DELETE FROM sqlite_sequence WHERE name='test';";
	}

	@Override
	public String getInsertQuery(Test object) {
		return "INSERT INTO test (test_interval, appointment_id) VALUES ("
		        +object.getTestInterval()+","+object.getAppointmentId()+")";
	}
	
	@Override
	public String getUpdateQuery(Test object,int id) {
		return "UPDATE test SET test_id='"+object.getTestId()+"',test_interval='"+object.getTestInterval()+"',appointment_id='"+object.getAppointmentId()+"' WHERE test_id="+id;
	}
}
