package com.project.cargallery.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS employee(
    employee_id integer primary key autoincrement not null,
    name varchar(50) not null,
    address varchar(100) not null,
    salary integer not null,
    gender varchar(50) not null,
    
    tech_id integer not null,
    mng_id integer not null,
    sr_id integer not null,
    rec_id integer not null,
    lr_id integer not null,
    dept_name varchar(50) not null,
    
    foreign key (tech_id) references technician(tech_id),
    foreign key (mng_id) references manager(mng_id),
    foreign key (sr_id) references sales_responsible(sr_id),
    foreign key (rec_id) references reception(rec_id),
    foreign key (lr_id) references leasing_responsible(lr_id),
    foreign key (dept_name) references department(dept_name)
);
 */

public class Employee implements ModelInterface<Employee> {
	private int employeeId;
	private String name;
	private String address;
	private int salary;
	private String gender;
	
	private int techId;
	private int mngId;
	private int srId;
	private int recId;
	private int lrId;
	private String deptName;
	
	public Employee() {}

	public Employee(int employeeId, String name, String address, int salary, String gender, int techId, int mngId,
			int srId, int recId, int lrId, String deptName) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.gender = gender;
		this.techId = techId;
		this.mngId = mngId;
		this.srId = srId;
		this.recId = recId;
		this.lrId = lrId;
		this.deptName = deptName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public int getMngId() {
		return mngId;
	}

	public void setMngId(int mngId) {
		this.mngId = mngId;
	}

	public int getSrId() {
		return srId;
	}

	public void setSrId(int srId) {
		this.srId = srId;
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getLrId() {
		return lrId;
	}

	public void setLrId(int lrId) {
		this.lrId = lrId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", gender=" + gender + ", techId=" + techId + ", mngId=" + mngId + ", srId=" + srId + ", recId="
				+ recId + ", lrId=" + lrId + ", deptName=" + deptName + "]";
	}
	
	@Override
	public Employee exportTableInstance(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("employee_id"),rs.getString("name"),rs.getString("address"),rs.getInt("salary"),rs.getString("gender"),rs.getInt("tech_id"),rs.getInt("mng_id"),rs.getInt("sr_id"),rs.getInt("rec_id"),rs.getInt("lr_id"),rs.getString("dept_name"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM employee WHERE employee_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM employee";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM employee WHERE employee_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM employee;"+"DELETE FROM sqlite_sequence WHERE name='employee';";
	}

	@Override
	public String getInsertQuery(Employee object) {
		return "INSERT INTO employee (name, address, salary, gender, tech_id, mng_id, sr_id, rec_id, lr_id, dept_name) VALUES ("
		        +"'"+object.getName()+"'"+","+"'"+object.getAddress()+"'"+","+object.getSalary()+","+"'"+object.getGender()+"'"+","+object.getTechId()+","+object.getMngId()+","+object.getSrId()+","+object.getRecId()+","+object.getLrId()+","+"'"+object.getDeptName()+"'"+")";
	}
	
	@Override
	public String getUpdateQuery(Employee object,int id) {
		return "UPDATE employee SET employee_id='"+object.getEmployeeId()+"',name='"+object.getName()+"', address='"+object.getAddress()+"', salary='"+object.getSalary()+"', gender='"+object.getGender()+"',tech_id='"+object.getTechId()+"',mng_id='"+object.getTechId()+"',sr_id='"+object.getSrId()+"',rec_id='"+object.getRecId()+"',lr_id='"+object.getLrId()+"',dept_name='"+object.getDeptName()+"' WHERE employee_id="+id;
	}

	
	
}
