package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS normalcar(
    nc_id integer primary key autoincrement not null,
    person_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
 */
public class NormalCar implements ModelInterface<NormalCar> {
	private int ncId;
	private int personCapacity;
	private int carId;
	
	public NormalCar() {}

	public NormalCar(int ncId, int personCapacity, int carId) {
		super();
		this.ncId = ncId;
		this.personCapacity = personCapacity;
		this.carId = carId;
	}

	public int getNcId() {
		return ncId;
	}

	public void setNcId(int ncId) {
		this.ncId = ncId;
	}

	public int getPersonCapacity() {
		return personCapacity;
	}

	public void setPersonCapacity(int personCapacity) {
		this.personCapacity = personCapacity;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "NormalCar [ncId=" + ncId + ", personCapacity=" + personCapacity + ", carId=" + carId + "]";
	}
	
	@Override
	public NormalCar exportTableInstance(ResultSet rs) throws SQLException {
		return new NormalCar(rs.getInt("nc_id"),rs.getInt("person_capacity"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM normalcar WHERE nc_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM normalcar";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM normalcar WHERE nc_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM normalcar;"+"DELETE FROM sqlite_sequence WHERE name='normalcar';";
	}

	@Override
	public String getInsertQuery(NormalCar object) {
		return "INSERT INTO normalcar (person_capacity, car_id) VALUES ("
		        +object.getPersonCapacity()+","+object.getCarId()+")";
	}
	
	@Override
	public String getUpdateQuery(NormalCar object,int id) {
		return "UPDATE normalcar SET nc_id='"+object.getNcId()+"',person_capacity='"+object.getPersonCapacity()+"',car_id='"+object.getCarId()+"' WHERE nc_id="+id;
	}
}
