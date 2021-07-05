package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS tyre(
    tyre_id integer primary key autoincrement not null,
    tyre_mark varchar(50) not null,
    season varchar(50) not null
);
 */
public class Tyre implements ModelInterface<Tyre> {
	private int tyreId;
	private String tyreMark;
	private String season;
	
	public Tyre() {}

	public Tyre(int tyreId, String tyreMark, String season) {
		super();
		this.tyreId = tyreId;
		this.tyreMark = tyreMark;
		this.season = season;
	}

	public int getTyreId() {
		return tyreId;
	}

	public void setTyreId(int tyreId) {
		this.tyreId = tyreId;
	}

	public String getTyreMark() {
		return tyreMark;
	}

	public void setTyreMark(String tyreMark) {
		this.tyreMark = tyreMark;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Tyre [tyreId=" + tyreId + ", tyreMark=" + tyreMark + ", season=" + season + "]";
	}
	
	@Override
	public Tyre exportTableInstance(ResultSet rs) throws SQLException {
		return new Tyre(rs.getInt("tyre_id"),rs.getString("tyre_mark"),rs.getString("season"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM tyre WHERE tyre_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM tyre";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM tyre WHERE tyre_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return  "DELETE FROM tyre;"+"DELETE FROM sqlite_sequence WHERE name='tyre';";
	}

	@Override
	public String getInsertQuery(Tyre object) {
		return "INSERT INTO tyre (tyre_mark, season) VALUES ("
		        +"'"+object.getTyreMark()+"'"+","+"'"+object.getSeason()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Tyre object,int id) {
		return "UPDATE tyre SET tyre_id='"+object.getTyreId()+"',tyre_mark='"+object.getTyreMark()+"',season='"+object.getSeason()+"' WHERE tyre_id="+id;
	}
}
