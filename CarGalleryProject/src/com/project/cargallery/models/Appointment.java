package com.project.cargallery.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.cargallery.interfaces.ModelInterface;

/*
 * CREATE TABLE IF NOT EXISTS appointment(
    appointment_id integer primary key autoincrement not null,
    date_detail date not null,
    
    bill_id integer not null,
    customer_id integer not null,
    m_id integer,
    sale_id integer,
    leasing_id integer,
    test_id integer,
    rc_id integer not null,
    car_id integer not null,
    foreign key (bill_id) references bill(bill_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (m_id) references maintanence(m_id),
    foreign key (sale_id) references sale(sale_id),
    foreign key (leasing_id) references leasing(leasing_id),
    foreign key (test_id) references test(test_id),
    foreign key (rc_id) references reception(rc_id),
    foreign key (car_id) references car(car_id)
);
 */
public class Appointment implements ModelInterface<Appointment> {
	private int appointmentId;
	private String dateDetail;
	private int billId;
	private int customerId;
	private int mId;
	private int saleId;
	private int leasingId;
	private int testId;
	private int recId;
	private int carId;
	
	public Appointment() {}

	public Appointment(int appointmentId, String dateDetail, int billId, int customerId, int mId, int saleId,
			int leasingId, int testId, int recId, int carId) {
		super();
		this.appointmentId = appointmentId;
		this.dateDetail = dateDetail;
		this.billId = billId;
		this.customerId = customerId;
		this.mId = mId;
		this.saleId = saleId;
		this.leasingId = leasingId;
		this.testId = testId;
		this.recId = recId;
		this.carId = carId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDateDetail() {
		return dateDetail;
	}

	public void setDateDetail(String dateDetail) {
		this.dateDetail = dateDetail;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getLeasingId() {
		return leasingId;
	}

	public void setLeasingId(int leasingId) {
		this.leasingId = leasingId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateDetail=" + dateDetail + ", billId=" + billId
				+ ", customerId=" + customerId + ", mId=" + mId + ", saleId=" + saleId + ", leasingId=" + leasingId
				+ ", testId=" + testId + ", recId=" + recId + ", carId=" + carId + "]";
	}
	
	@Override
	public Appointment exportTableInstance(ResultSet rs) throws SQLException {
		return new Appointment(rs.getInt("appointment_id"),rs.getString("date_detail"),rs.getInt("bill_id"),
				rs.getInt("customer_id"),rs.getInt("m_id"),rs.getInt("sale_id"),rs.getInt("leasing_id"),
				rs.getInt("test_id"),rs.getInt("rec_id"),rs.getInt("car_id"));
	}

	@Override
	public String getSelectQuery(int id) {
		return "SELECT * FROM appointment WHERE appointment_id=" + id;
	}

	@Override
	public String getSelectAllQuery() {
		return "SELECT * FROM appointment";
	}

	@Override
	public String getDeleteQuery(int id) {
		return "DELETE FROM appointment WHERE appointment_id=" + id;
	}

	@Override
	public String getDeleteAllQuery() {
		return "DELETE FROM appointment;"+"DELETE FROM sqlite_sequence WHERE name='appointment';";
	}

	@Override
	public String getInsertQuery(Appointment object) {
		return "INSERT INTO appointment (date_detail, bill_id, customer_id,m_id,sale_id,leasing_id,test_id,rec_id,car_id) VALUES ("
		        +"'"+object.getDateDetail()+"'"+","+object.getBillId()+","+object.getCustomerId()+","+object.getmId()+","+object.getSaleId()+","+object.getLeasingId()+","+object.getTestId()+","+object.getRecId()+","+object.getCarId()+")";
	}

	@Override
	public String getUpdateQuery(Appointment object,int id) {
		return "UPDATE appointment SET appointment_id='"+object.getAppointmentId()+"',date_detail='"+object.getDateDetail()+"', bill_id='"+object.getBillId()+"', customer_id='"+object.getCustomerId()+"', m_id='"+object.getmId()+"',sale_id='"+object.getSaleId()+"',leasing_id='"+object.getLeasingId()+"',test_id='"+object.getTestId()+"',rec_id='"+object.getRecId()+"',car_id='"+object.getCarId()+"' WHERE appointment_id="+id;
	}

	
	
}
