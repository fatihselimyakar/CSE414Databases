package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS showroom(
    showroom_id integer primary key autoincrement not null,
    building varchar(50) not null,
    room_number integer not null,
    capacity integer not null,
    
    dept_name varchar(50) not null,
    foreign key (dept_name) references department(dept_name)
);
 */

public class Showroom implements ModelInterface<Showroom> {

	private int showroomId;
	private String building;
	private int roomNumber;
	private int capacity;
	private String deptName;
	
	public Showroom() {}


	public Showroom(int showroomId, String building, int roomNumber, int capacity, String deptName) {
		super();
		this.showroomId = showroomId;
		this.building = building;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.deptName = deptName;
	}


	public int getShowroomId() {
		return showroomId;
	}


	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
	}


	public String getBuilding() {
		return building;
	}


	public void setBuilding(String building) {
		this.building = building;
	}


	public int getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	@Override
	public String toString() {
		return "Showroom [showroomId=" + showroomId + ", building=" + building + ", roomNumber=" + roomNumber
				+ ", capacity=" + capacity + ", deptName=" + deptName + "]";
	}	
	
	@Override
	public Showroom exportTableInstance(ResultSet rs) throws SQLException {
		return new Showroom(rs.getInt("showroom_id"),rs.getString("building"),rs.getInt("room_number"),rs.getInt("capacity"),rs.getString("dept_name"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM showroom WHERE showroom_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM showroom";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM showroom WHERE showroom_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM showroom;"+"DELETE FROM sqlite_sequence WHERE name='showroom';";
	}

	@Override
	public String getInsertQuery(Showroom object) {
		return "INSERT INTO showroom (building, room_number, capacity, dept_name) VALUES ("
		        +"'"+object.getBuilding()+"'"+","+object.getRoomNumber()+","+object.getCapacity()+","+"'"+object.getDeptName()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Showroom object,int id) {
		return "UPDATE showroom SET showroom_id='"+object.getShowroomId()+"',building='"+object.getBuilding()+"',room_number='"+object.getRoomNumber()+"',capacity='"+object.getCapacity()+"',dept_name='"+object.getDeptName()+"' WHERE showroom_id="+id;
	}
}
