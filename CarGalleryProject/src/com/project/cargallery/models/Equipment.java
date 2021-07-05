package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS equipment(
    equipment_id integer primary key autoincrement not null,
    eqıipment_level varchar(50) not null
);
 */
public class Equipment implements ModelInterface<Equipment> {
	private int equipmentId;
	private String equipmentLevel;
	private String equipmentOptions;
	
	public Equipment() {}

	public Equipment(int equipmentId, String equipmentLevel, String equipmentOptions) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentLevel = equipmentLevel;
		this.equipmentOptions = equipmentOptions;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentLevel() {
		return equipmentLevel;
	}

	public void setEquipmentLevel(String equipmentLevel) {
		this.equipmentLevel = equipmentLevel;
	}
	
	public String getEquipmentOptions() {
		return equipmentOptions;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentLevel=" + equipmentLevel + ", equipmentOptions="
				+ equipmentOptions + "]";
	}

	public void setEquipmentOptions(String equipmentOptions) {
		this.equipmentOptions = equipmentOptions;
	}
	
	@Override
	public Equipment exportTableInstance(ResultSet rs) throws SQLException {
		return new Equipment(rs.getInt("equipment_id"),rs.getString("equipment_level"),rs.getString("equipment_options"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM equipment WHERE equipment_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM equipment";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM equipment WHERE equipment_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM equipment;"+"DELETE FROM sqlite_sequence WHERE name='equipment';";
	}

	@Override
	public String getInsertQuery(Equipment object) {
		return "INSERT INTO equipment (equipment_level,equipment_options) VALUES ("
		        +"'"+object.getEquipmentLevel()+"'"+","+"'"+object.getEquipmentOptions()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Equipment object,int id) {
		return "UPDATE equipment SET equipment_id='"+object.getEquipmentId()+"',equipment_level='"+object.getEquipmentLevel()+"', equipment_options='"+object.getEquipmentOptions()+"' WHERE car_id="+id;
	}

}
