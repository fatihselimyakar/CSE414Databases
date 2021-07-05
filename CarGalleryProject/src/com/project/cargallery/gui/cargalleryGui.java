package com.project.cargallery.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.util.List;
import com.project.cargallery.db.CarGalleryDbMethods;
import com.project.cargallery.interfaces.ModelInterface;
import com.project.cargallery.models.*;
import javax.swing.SwingConstants;

import org.sqlite.SQLiteException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Date;

public class cargalleryGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cargalleryGui window = new cargalleryGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel, JLayeredPane layeredPane) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the application.
	 */
	public cargalleryGui() {
		initialize();
	}

	String tables[] = {
			"Appointment",
			"Bill",
			"Car",
			"Customer",
			"Department",
			"ElectricVehicle",
			"Employee",
			"Equipment",
			"Headquarter",
			"Leasing",
			"LeasingCustomer",
			"LeasingResponsible",
			"Maintanence",
			"MaintanenceCustomer",
			"Manager",
			"Motor",
			"NormalCar",
			"Reception",
			"Sale",
			"SalesResponsible",
			"SalingCustomer",
			"Showroom",
			"SportsCar",
			"Suv",
			"Technician",
			"Test",
			"TestCustomer",
			"Truck",
			"Tyre"
	};
	
	String views[] = {
			"[Leasing Customer View]",
			"[Saling Customer View]",
			"[Maintanence Customer View]",
			"[Test Customer View]",
			"[Maintanence Appointment View]",
			"[Leasing Appointment View]",
			"[Sale Appointment View]",
			"[Test Appointment View]",
			"[Truck Car View]",
			"[Sports Car View]",
			"[Normal Car View]",
			"[Suv Car View]",
			"[Electric Car View]",
			"[Technician Employee View]",
			"[Manager Employee View]",
			"[Sales Responsible Employee View]",
			"[Reception Employee View]",
			"[Leasing Responsible Employee View]",
			"[Appointments with Customer and Bill View]",
			"[Cars with Motor,Tyre and Equipment View]"
			
	};
	
	String addableTables[] = {
			"Department",
			"ElectricVehicle",
			"Equipment",
			"Headquarter",
			"Leasing",
			"LeasingCustomer",
			"LeasingResponsible",
			"Maintanence",
			"MaintanenceCustomer",
			"Manager",
			"Motor",
			"NormalCar",
			"Reception",
			"Sale",
			"SalesResponsible",
			"SalingCustomer",
			"Showroom",
			"SportsCar",
			"Suv",
			"Technician",
			"Test",
			"TestCustomer",
			"Truck",
			"Tyre"
	};
	
	String joinStrings[]= {
			"motor LEFT OUTER JOIN equipment with Primary Keys",
			"motor RIGHT OUTER JOIN equipment with Primary Keys",
			"motor FULL OUTER JOIN equipment with Primary Keys"
	};
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	static <T> String getPrintableString(List<T> a) {
		
		StringBuilder stringBuilder=new StringBuilder();
	    for (T o : a) {
	    	stringBuilder.append(o.toString());
	    	stringBuilder.append("\n");
	    }
	    return stringBuilder.toString();
	}
	
	public void viewPageSelectMethod(JComboBox comboBox,JTextArea label) {
		CarGalleryDbMethods<GenericView> view = new CarGalleryDbMethods<GenericView>(new GenericView(comboBox.getSelectedItem().toString()));
		//System.out.print(comboBox.getSelectedItem().toString());
		label.setText(view.getAllIntancesForViews());
	}
	
	public void selectPageSelectMethod(JComboBox comboBox,JTextArea label) {
		if(comboBox.getSelectedItem().toString().equals("Car")) {
			CarGalleryDbMethods<Car> table = new CarGalleryDbMethods<Car>(new Car());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Appointment")) {
			CarGalleryDbMethods<Appointment> table = new CarGalleryDbMethods<Appointment>(new Appointment());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Bill")) {
			CarGalleryDbMethods<Bill> table = new CarGalleryDbMethods<Bill>(new Bill());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Customer")) {
			CarGalleryDbMethods<Customer> table = new CarGalleryDbMethods<Customer>(new Customer());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Department")) {
			CarGalleryDbMethods<Department> table = new CarGalleryDbMethods<Department>(new Department());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("ElectricVehicle")) {
			CarGalleryDbMethods<ElectricVehicle> table = new CarGalleryDbMethods<ElectricVehicle>(new ElectricVehicle());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Employee")) {
			CarGalleryDbMethods<Employee> table = new CarGalleryDbMethods<Employee>(new Employee());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Equipment")) {
			CarGalleryDbMethods<Equipment> table = new CarGalleryDbMethods<Equipment>(new Equipment());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Headquarter")) {
			CarGalleryDbMethods<Headquarter> table = new CarGalleryDbMethods<Headquarter>(new Headquarter());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Leasing")) {
			CarGalleryDbMethods<Leasing> table = new CarGalleryDbMethods<Leasing>(new Leasing());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingCustomer")) {
			CarGalleryDbMethods<LeasingCustomer> table = new CarGalleryDbMethods<LeasingCustomer>(new LeasingCustomer());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingResponsible")) {
			CarGalleryDbMethods<LeasingResponsible> table = new CarGalleryDbMethods<LeasingResponsible>(new LeasingResponsible());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Maintanence")) {
			CarGalleryDbMethods<Maintanence> table = new CarGalleryDbMethods<Maintanence>(new Maintanence());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("MaintanenceCustomer")) {
			CarGalleryDbMethods<MaintanenceCustomer> table = new CarGalleryDbMethods<MaintanenceCustomer>(new MaintanenceCustomer());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Manager")) {
			CarGalleryDbMethods<Manager> table = new CarGalleryDbMethods<Manager>(new Manager());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Motor")) {
			CarGalleryDbMethods<Motor> table = new CarGalleryDbMethods<Motor>(new Motor());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("NormalCar")) {
			CarGalleryDbMethods<NormalCar> table = new CarGalleryDbMethods<NormalCar>(new NormalCar());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Reception")) {
			CarGalleryDbMethods<Reception> table = new CarGalleryDbMethods<Reception>(new Reception());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Sale")) {
			CarGalleryDbMethods<Sale> table = new CarGalleryDbMethods<Sale>(new Sale());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SalesResponsible")) {
			CarGalleryDbMethods<SalesResponsible> table = new CarGalleryDbMethods<SalesResponsible>(new SalesResponsible());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SalingCustomer")) {
			CarGalleryDbMethods<SalingCustomer> table = new CarGalleryDbMethods<SalingCustomer>(new SalingCustomer());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Showroom")) {
			CarGalleryDbMethods<Showroom> table = new CarGalleryDbMethods<Showroom>(new Showroom());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SportsCar")) {
			CarGalleryDbMethods<SportsCar> table = new CarGalleryDbMethods<SportsCar>(new SportsCar());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Suv")) {
			CarGalleryDbMethods<Suv> table = new CarGalleryDbMethods<Suv>(new Suv());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Technician")) {
			CarGalleryDbMethods<Technician> table = new CarGalleryDbMethods<Technician>(new Technician());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Test")) {
			CarGalleryDbMethods<Test> table = new CarGalleryDbMethods<Test>(new Test());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("TestCustomer")) {
			CarGalleryDbMethods<TestCustomer> table = new CarGalleryDbMethods<TestCustomer>(new TestCustomer());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Truck")) {
			CarGalleryDbMethods<Truck> table = new CarGalleryDbMethods<Truck>(new Truck());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Tyre")) {
			CarGalleryDbMethods<Tyre> table = new CarGalleryDbMethods<Tyre>(new Tyre());
			label.setText(getPrintableString(table.getAllIntances()));
		}
		
		
		
		//label.setText(comboBox.getSelectedItem() + " selected");
	}
	
	public void selectWithIdPageSelectMethod(JComboBox comboBox,JTextArea label,JTextField tf) {
		if(comboBox.getSelectedItem().toString().equals("Car")) {
			CarGalleryDbMethods<Car> table = new CarGalleryDbMethods<Car>(new Car());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Appointment")) {
			CarGalleryDbMethods<Appointment> table = new CarGalleryDbMethods<Appointment>(new Appointment());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Bill")) {
			CarGalleryDbMethods<Bill> table = new CarGalleryDbMethods<Bill>(new Bill());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Customer")) {
			CarGalleryDbMethods<Customer> table = new CarGalleryDbMethods<Customer>(new Customer());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Department")) {
			CarGalleryDbMethods<Department> table = new CarGalleryDbMethods<Department>(new Department());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("ElectricVehicle")) {
			CarGalleryDbMethods<ElectricVehicle> table = new CarGalleryDbMethods<ElectricVehicle>(new ElectricVehicle());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Employee")) {
			CarGalleryDbMethods<Employee> table = new CarGalleryDbMethods<Employee>(new Employee());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Equipment")) {
			CarGalleryDbMethods<Equipment> table = new CarGalleryDbMethods<Equipment>(new Equipment());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Headquarter")) {
			CarGalleryDbMethods<Headquarter> table = new CarGalleryDbMethods<Headquarter>(new Headquarter());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Leasing")) {
			CarGalleryDbMethods<Leasing> table = new CarGalleryDbMethods<Leasing>(new Leasing());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingCustomer")) {
			CarGalleryDbMethods<LeasingCustomer> table = new CarGalleryDbMethods<LeasingCustomer>(new LeasingCustomer());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingResponsible")) {
			CarGalleryDbMethods<LeasingResponsible> table = new CarGalleryDbMethods<LeasingResponsible>(new LeasingResponsible());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Maintanence")) {
			CarGalleryDbMethods<Maintanence> table = new CarGalleryDbMethods<Maintanence>(new Maintanence());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("MaintanenceCustomer")) {
			CarGalleryDbMethods<MaintanenceCustomer> table = new CarGalleryDbMethods<MaintanenceCustomer>(new MaintanenceCustomer());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Manager")) {
			CarGalleryDbMethods<Manager> table = new CarGalleryDbMethods<Manager>(new Manager());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Motor")) {
			CarGalleryDbMethods<Motor> table = new CarGalleryDbMethods<Motor>(new Motor());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("NormalCar")) {
			CarGalleryDbMethods<NormalCar> table = new CarGalleryDbMethods<NormalCar>(new NormalCar());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Reception")) {
			CarGalleryDbMethods<Reception> table = new CarGalleryDbMethods<Reception>(new Reception());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Sale")) {
			CarGalleryDbMethods<Sale> table = new CarGalleryDbMethods<Sale>(new Sale());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("SalesResponsible")) {
			CarGalleryDbMethods<SalesResponsible> table = new CarGalleryDbMethods<SalesResponsible>(new SalesResponsible());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("SalingCustomer")) {
			CarGalleryDbMethods<SalingCustomer> table = new CarGalleryDbMethods<SalingCustomer>(new SalingCustomer());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Showroom")) {
			CarGalleryDbMethods<Showroom> table = new CarGalleryDbMethods<Showroom>(new Showroom());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("SportsCar")) {
			CarGalleryDbMethods<SportsCar> table = new CarGalleryDbMethods<SportsCar>(new SportsCar());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Suv")) {
			CarGalleryDbMethods<Suv> table = new CarGalleryDbMethods<Suv>(new Suv());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Technician")) {
			CarGalleryDbMethods<Technician> table = new CarGalleryDbMethods<Technician>(new Technician());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Test")) {
			CarGalleryDbMethods<Test> table = new CarGalleryDbMethods<Test>(new Test());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("TestCustomer")) {
			CarGalleryDbMethods<TestCustomer> table = new CarGalleryDbMethods<TestCustomer>(new TestCustomer());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Truck")) {
			CarGalleryDbMethods<Truck> table = new CarGalleryDbMethods<Truck>(new Truck());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		else if(comboBox.getSelectedItem().toString().equals("Tyre")) {
			CarGalleryDbMethods<Tyre> table = new CarGalleryDbMethods<Tyre>(new Tyre());
			label.setText(table.getInstance(Integer.parseInt(tf.getText())).toString());
		}
		
		
		//label.setText(comboBox.getSelectedItem() + " selected");
	}
	
	private void manualQueryPageExecuteQuery(JTextField tf, JTextArea ta) {
		CarGalleryDbMethods<GenericView> object = new CarGalleryDbMethods<GenericView>(new GenericView(""));
		ta.setText(object.getAllIntancesManually(tf.getText()));
	}
	
	private void manualQueryPageExecuteUpdate(JTextField tf) {
		CarGalleryDbMethods<GenericView> object = new CarGalleryDbMethods<GenericView>(new GenericView(""));
		object.updateManually(tf.getText());
	}
	
	private void joinsPageExecuteQuery(JComboBox cb, JTextArea ta) {
		CarGalleryDbMethods<GenericView> object = new CarGalleryDbMethods<GenericView>(new GenericView(""));
		if(cb.getSelectedItem().toString().equals("motor LEFT OUTER JOIN equipment with Primary Keys")) {
			ta.setText(object.getAllIntancesManually("SELECT * FROM motor LEFT OUTER JOIN equipment ON motor.motor_id=equipment.equipment_id"));
		}
		else if(cb.getSelectedItem().toString().equals("motor RIGHT OUTER JOIN equipment with Primary Keys")) {
			ta.setText(object.getAllIntancesManually("SELECT * FROM motor RIGHT OUTER JOIN equipment ON motor.motor_id=equipment.equipment_id"));
		}
		else if(cb.getSelectedItem().toString().equals("motor FULL OUTER JOIN equipment with Primary Keys")) {
			ta.setText(object.getAllIntancesManually("SELECT * FROM motor FULL OUTER JOIN equipment ON motor.motor_id=equipment.equipment_id"));
		}
		
	}
	
	private void deletePageDeleteAllMethod(JComboBox comboBox) {
		if(comboBox.getSelectedItem().toString().equals("Car")) {
			CarGalleryDbMethods<Car> table = new CarGalleryDbMethods<Car>(new Car());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Appointment")) {
			CarGalleryDbMethods<Appointment> table = new CarGalleryDbMethods<Appointment>(new Appointment());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Bill")) {
			CarGalleryDbMethods<Bill> table = new CarGalleryDbMethods<Bill>(new Bill());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Customer")) {
			CarGalleryDbMethods<Customer> table = new CarGalleryDbMethods<Customer>(new Customer());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Department")) {
			CarGalleryDbMethods<Department> table = new CarGalleryDbMethods<Department>(new Department());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("ElectricVehicle")) {
			CarGalleryDbMethods<ElectricVehicle> table = new CarGalleryDbMethods<ElectricVehicle>(new ElectricVehicle());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Employee")) {
			CarGalleryDbMethods<Employee> table = new CarGalleryDbMethods<Employee>(new Employee());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Equipment")) {
			CarGalleryDbMethods<Equipment> table = new CarGalleryDbMethods<Equipment>(new Equipment());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Headquarter")) {
			CarGalleryDbMethods<Headquarter> table = new CarGalleryDbMethods<Headquarter>(new Headquarter());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Leasing")) {
			CarGalleryDbMethods<Leasing> table = new CarGalleryDbMethods<Leasing>(new Leasing());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingCustomer")) {
			CarGalleryDbMethods<LeasingCustomer> table = new CarGalleryDbMethods<LeasingCustomer>(new LeasingCustomer());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingResponsible")) {
			CarGalleryDbMethods<LeasingResponsible> table = new CarGalleryDbMethods<LeasingResponsible>(new LeasingResponsible());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Maintanence")) {
			CarGalleryDbMethods<Maintanence> table = new CarGalleryDbMethods<Maintanence>(new Maintanence());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("MaintanenceCustomer")) {
			CarGalleryDbMethods<MaintanenceCustomer> table = new CarGalleryDbMethods<MaintanenceCustomer>(new MaintanenceCustomer());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Manager")) {
			CarGalleryDbMethods<Manager> table = new CarGalleryDbMethods<Manager>(new Manager());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Motor")) {
			CarGalleryDbMethods<Motor> table = new CarGalleryDbMethods<Motor>(new Motor());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("NormalCar")) {
			CarGalleryDbMethods<NormalCar> table = new CarGalleryDbMethods<NormalCar>(new NormalCar());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Reception")) {
			CarGalleryDbMethods<Reception> table = new CarGalleryDbMethods<Reception>(new Reception());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Sale")) {
			CarGalleryDbMethods<Sale> table = new CarGalleryDbMethods<Sale>(new Sale());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("SalesResponsible")) {
			CarGalleryDbMethods<SalesResponsible> table = new CarGalleryDbMethods<SalesResponsible>(new SalesResponsible());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("SalingCustomer")) {
			CarGalleryDbMethods<SalingCustomer> table = new CarGalleryDbMethods<SalingCustomer>(new SalingCustomer());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Showroom")) {
			CarGalleryDbMethods<Showroom> table = new CarGalleryDbMethods<Showroom>(new Showroom());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("SportsCar")) {
			CarGalleryDbMethods<SportsCar> table = new CarGalleryDbMethods<SportsCar>(new SportsCar());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Suv")) {
			CarGalleryDbMethods<Suv> table = new CarGalleryDbMethods<Suv>(new Suv());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Technician")) {
			CarGalleryDbMethods<Technician> table = new CarGalleryDbMethods<Technician>(new Technician());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Test")) {
			CarGalleryDbMethods<Test> table = new CarGalleryDbMethods<Test>(new Test());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("TestCustomer")) {
			CarGalleryDbMethods<TestCustomer> table = new CarGalleryDbMethods<TestCustomer>(new TestCustomer());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Truck")) {
			CarGalleryDbMethods<Truck> table = new CarGalleryDbMethods<Truck>(new Truck());
			table.deleteAlLInstances();
		}
		else if(comboBox.getSelectedItem().toString().equals("Tyre")) {
			CarGalleryDbMethods<Tyre> table = new CarGalleryDbMethods<Tyre>(new Tyre());
			table.deleteAlLInstances();
		}
	}
	
	
	private void deleteWithIdPageDeleteIdMethod(JComboBox comboBox,JTextField tf) {
		if(comboBox.getSelectedItem().toString().equals("Car")) {
			CarGalleryDbMethods<Car> table = new CarGalleryDbMethods<Car>(new Car());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Appointment")) {
			CarGalleryDbMethods<Appointment> table = new CarGalleryDbMethods<Appointment>(new Appointment());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Bill")) {
			CarGalleryDbMethods<Bill> table = new CarGalleryDbMethods<Bill>(new Bill());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Customer")) {
			CarGalleryDbMethods<Customer> table = new CarGalleryDbMethods<Customer>(new Customer());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Department")) {
			CarGalleryDbMethods<Department> table = new CarGalleryDbMethods<Department>(new Department());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("ElectricVehicle")) {
			CarGalleryDbMethods<ElectricVehicle> table = new CarGalleryDbMethods<ElectricVehicle>(new ElectricVehicle());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Employee")) {
			CarGalleryDbMethods<Employee> table = new CarGalleryDbMethods<Employee>(new Employee());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Equipment")) {
			CarGalleryDbMethods<Equipment> table = new CarGalleryDbMethods<Equipment>(new Equipment());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Headquarter")) {
			CarGalleryDbMethods<Headquarter> table = new CarGalleryDbMethods<Headquarter>(new Headquarter());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Leasing")) {
			CarGalleryDbMethods<Leasing> table = new CarGalleryDbMethods<Leasing>(new Leasing());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingCustomer")) {
			CarGalleryDbMethods<LeasingCustomer> table = new CarGalleryDbMethods<LeasingCustomer>(new LeasingCustomer());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("LeasingResponsible")) {
			CarGalleryDbMethods<LeasingResponsible> table = new CarGalleryDbMethods<LeasingResponsible>(new LeasingResponsible());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Maintanence")) {
			CarGalleryDbMethods<Maintanence> table = new CarGalleryDbMethods<Maintanence>(new Maintanence());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("MaintanenceCustomer")) {
			CarGalleryDbMethods<MaintanenceCustomer> table = new CarGalleryDbMethods<MaintanenceCustomer>(new MaintanenceCustomer());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Manager")) {
			CarGalleryDbMethods<Manager> table = new CarGalleryDbMethods<Manager>(new Manager());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Motor")) {
			CarGalleryDbMethods<Motor> table = new CarGalleryDbMethods<Motor>(new Motor());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("NormalCar")) {
			CarGalleryDbMethods<NormalCar> table = new CarGalleryDbMethods<NormalCar>(new NormalCar());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Reception")) {
			CarGalleryDbMethods<Reception> table = new CarGalleryDbMethods<Reception>(new Reception());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Sale")) {
			CarGalleryDbMethods<Sale> table = new CarGalleryDbMethods<Sale>(new Sale());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SalesResponsible")) {
			CarGalleryDbMethods<SalesResponsible> table = new CarGalleryDbMethods<SalesResponsible>(new SalesResponsible());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SalingCustomer")) {
			CarGalleryDbMethods<SalingCustomer> table = new CarGalleryDbMethods<SalingCustomer>(new SalingCustomer());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Showroom")) {
			CarGalleryDbMethods<Showroom> table = new CarGalleryDbMethods<Showroom>(new Showroom());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("SportsCar")) {
			CarGalleryDbMethods<SportsCar> table = new CarGalleryDbMethods<SportsCar>(new SportsCar());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Suv")) {
			CarGalleryDbMethods<Suv> table = new CarGalleryDbMethods<Suv>(new Suv());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Technician")) {
			CarGalleryDbMethods<Technician> table = new CarGalleryDbMethods<Technician>(new Technician());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Test")) {
			CarGalleryDbMethods<Test> table = new CarGalleryDbMethods<Test>(new Test());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("TestCustomer")) {
			CarGalleryDbMethods<TestCustomer> table = new CarGalleryDbMethods<TestCustomer>(new TestCustomer());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Truck")) {
			CarGalleryDbMethods<Truck> table = new CarGalleryDbMethods<Truck>(new Truck());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		else if(comboBox.getSelectedItem().toString().equals("Tyre")) {
			CarGalleryDbMethods<Tyre> table = new CarGalleryDbMethods<Tyre>(new Tyre());
			table.deleteInstance(Integer.parseInt(tf.getText()));
		}
		
		
		//label.setText(comboBox.getSelectedItem() + " selected");
	}
	
	
	void addPageShowFormat(JComboBox comboBox, JTextField textField) {
		if(comboBox.getSelectedItem().equals("Department")) {
			textField.setText("Format: \"dept_name\",\"building\",\"budget\",\"headquarter_name\"");
		}
		else if(comboBox.getSelectedItem().equals("ElectricVehicle")) {
			textField.setText("Format: \"mark\",\"weight\",\"size\",\"consumption\",\"battery_capacity\"");
		}
		else if(comboBox.getSelectedItem().equals("Equipment")) {
			textField.setText("Format: \"equipment_level\",\"equipment_options\"");
		}
		else if(comboBox.getSelectedItem().equals("Headquarter")) {
			textField.setText("Format: \"headquarter_name\"");
		}
		else if(comboBox.getSelectedItem().equals("Leasing")) {
			textField.setText("Format: \"appointment_date_detail\",\"delivery_date\"");
		}
		else if(comboBox.getSelectedItem().equals("LeasingCustomer") || comboBox.getSelectedItem().equals("TestCustomer") || comboBox.getSelectedItem().equals("MaintanenceCustomer") || comboBox.getSelectedItem().equals("SalingCustomer")) {
			textField.setText("Format: \"name\",\"money\",\"gender\",\"e-mail\"");
		}
		else if(comboBox.getSelectedItem().equals("LeasingResponsible")) {
			textField.setText("Format: \"name\",\"address\",\"salary\",\"gender\"");
		}
		else if(comboBox.getSelectedItem().equals("Maintanence")) {
			textField.setText("Format: \"appointment_date_detail\",\"delivery_time\"");
		}
		else if(comboBox.getSelectedItem().equals("Manager")) {
			textField.setText("Format: \"name\",\"address\",\"salary\",\"gender\",\"graduated_university\"");
		}
		else if(comboBox.getSelectedItem().equals("Motor")) {
			textField.setText("Format: \"engine_capacity\",\"engine_power\"");
		}
		else if(comboBox.getSelectedItem().equals("NormalCar")) {
			textField.setText("Format: \"mark\",\"weight\",\"size\",\"consumption\",\"person_capacity\"");
		}
		else if(comboBox.getSelectedItem().equals("Reception")) {
			textField.setText("Format: \"name\",\"address\",\"salary\",\"gender\"");
		}
		else if(comboBox.getSelectedItem().equals("Sale")) {
			textField.setText("Format: \"appointment_date_detail\"");
		}
		else if(comboBox.getSelectedItem().equals("SalesResponsible")) {
			textField.setText("Format: \"name\",\"address\",\"salary\",\"gender\",\"car_type\"");
		}
		else if(comboBox.getSelectedItem().equals("Showroom")) {
			textField.setText("Format: \"building\",\"room_number\",\"capacity\"");
		}
		else if(comboBox.getSelectedItem().equals("SportsCar")) {
			textField.setText("Format: \"mark\",\"weight\",\"size\",\"consumption\",\"max_speed\"");
		}
		else if(comboBox.getSelectedItem().equals("Suv")) {
			textField.setText("Format: \"mark\",\"weight\",\"size\",\"consumption\",\"is_all_wheel_drive\"");
		}
		else if(comboBox.getSelectedItem().equals("Technician")) {
			textField.setText("Format: \"name\",\"address\",\"salary\",\"gender\",\"mastery\"");
		}
		else if(comboBox.getSelectedItem().equals("Test")) {
			textField.setText("Format: \"appointment_date_detail\",\"test_interval\"");
		}
		else if(comboBox.getSelectedItem().equals("Truck")) {
			textField.setText("Format: \"mark\",\"weight\",\"size\",\"consumption\",\"towing_capacity\",\"loading_capacity\"");
		}
		else if(comboBox.getSelectedItem().equals("Tyre")) {
			textField.setText("Format: \"tyre_mark\",\"tyre_season\"");
		}
	}
	
	void addPageAddInstance(JComboBox comboBox,JTextField textField) {
		String willParse=textField.getText();
		String[] parsed= willParse.split(", ");
		for(String i : parsed) {
			System.out.println(i);
		}
		if(comboBox.getSelectedItem().equals("Department")) {
			CarGalleryDbMethods<Department> table = new CarGalleryDbMethods<Department>(new Department());
			table.addInstance(new Department(parsed[0],parsed[1],Integer.parseInt(parsed[2]),parsed[3]));
		}
		else if(comboBox.getSelectedItem().equals("ElectricVehicle")) {
			CarGalleryDbMethods<ElectricVehicle> table = new CarGalleryDbMethods<ElectricVehicle>(new ElectricVehicle());
			table.addInstance(new ElectricVehicle(1, Integer.parseInt(parsed[4]),1));
			CarGalleryDbMethods<Car> table2 = new CarGalleryDbMethods<Car>(new Car());
			List<Car> instances = table2.getAllIntances();
			int last_id=instances.size();
			if(instances.get(last_id-1).getMark().equals("")) {
				table2.updateInstance(new Car(instances.get(last_id-1).getCarId(), parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]),instances.get(last_id-1).getEquipmentId(), instances.get(last_id-1).getAppointmentId(),
					instances.get(last_id-1).getTyreId(), instances.get(last_id-1).getMotorId(), instances.get(last_id-1).getshowroomId(), instances.get(last_id-1).getTruckId(),instances.get(last_id-1).getScId(), instances.get(last_id-1).getNcId(), instances.get(last_id-1).getSuvId(), instances.get(last_id-1).getEvId()), instances.get(last_id-1).getCarId());
			}
		}
		else if(comboBox.getSelectedItem().equals("Equipment")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Headquarter")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Leasing")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("LeasingCustomer") || comboBox.getSelectedItem().equals("TestCustomer") || comboBox.getSelectedItem().equals("MaintanenceCustomer") || comboBox.getSelectedItem().equals("SalingCustomer")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("LeasingResponsible")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Maintanence")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Manager")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Motor")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("NormalCar")) {
			CarGalleryDbMethods<NormalCar> table = new CarGalleryDbMethods<NormalCar>(new NormalCar());
			table.addInstance(new NormalCar(1, Integer.parseInt(parsed[4]),1));
			CarGalleryDbMethods<Car> table2 = new CarGalleryDbMethods<Car>(new Car());
			List<Car> instances = table2.getAllIntances();
			int last_id=instances.size();
			if(instances.get(last_id-1).getMark().equals("")) {
				table2.updateInstance(new Car(instances.get(last_id-1).getCarId(), parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]),instances.get(last_id-1).getEquipmentId(), instances.get(last_id-1).getAppointmentId(),
					instances.get(last_id-1).getTyreId(), instances.get(last_id-1).getMotorId(), instances.get(last_id-1).getshowroomId(), instances.get(last_id-1).getTruckId(),instances.get(last_id-1).getScId(), instances.get(last_id-1).getNcId(), instances.get(last_id-1).getSuvId(), instances.get(last_id-1).getEvId()), instances.get(last_id-1).getCarId());
			}
		}
		else if(comboBox.getSelectedItem().equals("Reception")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Sale")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("SalesResponsible")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Showroom")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("SportsCar")) {
			CarGalleryDbMethods<SportsCar> table = new CarGalleryDbMethods<SportsCar>(new SportsCar());
			table.addInstance(new SportsCar(1, Integer.parseInt(parsed[4]),1));
			CarGalleryDbMethods<Car> table2 = new CarGalleryDbMethods<Car>(new Car());
			List<Car> instances = table2.getAllIntances();
			int last_id=instances.size();
			if(instances.get(last_id-1).getMark().equals("")) {
				table2.updateInstance(new Car(instances.get(last_id-1).getCarId(), parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]),instances.get(last_id-1).getEquipmentId(), instances.get(last_id-1).getAppointmentId(),
						instances.get(last_id-1).getTyreId(), instances.get(last_id-1).getMotorId(), instances.get(last_id-1).getshowroomId(), instances.get(last_id-1).getTruckId(),instances.get(last_id-1).getScId(), instances.get(last_id-1).getNcId(), instances.get(last_id-1).getSuvId(), instances.get(last_id-1).getEvId()), instances.get(last_id-1).getCarId());

			}	
		}
		else if(comboBox.getSelectedItem().equals("Suv")) {
			CarGalleryDbMethods<Suv> table = new CarGalleryDbMethods<Suv>(new Suv());
			table.addInstance(new Suv(1, Boolean.getBoolean(parsed[4]),1));
			CarGalleryDbMethods<Car> table2 = new CarGalleryDbMethods<Car>(new Car());
			List<Car> instances = table2.getAllIntances();
			int last_id=instances.size();
			if(instances.get(last_id-1).getMark().equals("")) {
				table2.updateInstance(new Car(instances.get(last_id-1).getCarId(), parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]),instances.get(last_id-1).getEquipmentId(), instances.get(last_id-1).getAppointmentId(),
					instances.get(last_id-1).getTyreId(), instances.get(last_id-1).getMotorId(), instances.get(last_id-1).getshowroomId(), instances.get(last_id-1).getTruckId(),instances.get(last_id-1).getScId(), instances.get(last_id-1).getNcId(), instances.get(last_id-1).getSuvId(), instances.get(last_id-1).getEvId()), instances.get(last_id-1).getCarId());
			}
		}
		else if(comboBox.getSelectedItem().equals("Technician")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Test")) {
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Truck")) {
			/*CarGalleryDbMethods<Truck> table = new CarGalleryDbMethods<Truck>(new Truck());
			table.addInstance(new Truck(1, Integer.getInteger(parsed[4]),Integer.getInteger(parsed[5]),1));
			CarGalleryDbMethods<Car> table2 = new CarGalleryDbMethods<Car>(new Car());
			List<Car> instances = table2.getAllIntances();
			int last_id=instances.size();
			table2.updateInstance(new Car(instances.get(last_id-1).getCarId(), parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]),instances.get(last_id-1).getEquipmentId(), instances.get(last_id-1).getAppointmentId(),
					instances.get(last_id-1).getTyreId(), instances.get(last_id-1).getMotorId(), instances.get(last_id-1).getshowroomId(), instances.get(last_id-1).getTruckId(),instances.get(last_id-1).getScId(), instances.get(last_id-1).getNcId(), instances.get(last_id-1).getSuvId(), instances.get(last_id-1).getEvId()), instances.get(last_id-1).getCarId());
			*/
			textField.setText("NOT IMPLEMENTED");
		}
		else if(comboBox.getSelectedItem().equals("Tyre")) {
			textField.setText("NOT IMPLEMENTED");
		}
		
	}
	
	
	void updatePageShowFormat(JComboBox comboBox, JTextField textField) {
		if(comboBox.getSelectedItem().equals("Appointment")) {
			textField.setText("Format: \"appointmentId\",\"dateDetail\",\"billId\",\"customerId\",\"maintanenceId\",\"saleId\",\"leasingId\",\"testId\",\"receptionId\",\"carId\"");
		}
		else {
			textField.setText("NOT IMPLEMENTED");
		}
	}
	
	void updatePageUpdateInstance(JComboBox comboBox,JTextField textField) {
		String willParse=textField.getText();
		String[] parsed= willParse.split(", ");
		for(String i : parsed) {
			System.out.println(i);
		}
		if(comboBox.getSelectedItem().equals("Appointment")) {
			CarGalleryDbMethods<Appointment> table = new CarGalleryDbMethods<Appointment>(new Appointment());
			table.updateInstance(new Appointment(Integer.parseInt(parsed[0]),parsed[1],Integer.parseInt(parsed[2]),Integer.parseInt(parsed[3]),Integer.parseInt(parsed[4]),Integer.parseInt(parsed[5]),Integer.parseInt(parsed[6]),Integer.parseInt(parsed[7]),Integer.parseInt(parsed[8]),Integer.parseInt(parsed[9])), Integer.parseInt(parsed[0]));
		}
		else {
			textField.setText("NOT IMPLEMENTED");
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 47, 1088, 597);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel select = new JPanel();
		layeredPane.add(select, "name_38541326577083");
		select.setLayout(null);
		
		JLabel lblSelect = new JLabel("SELECT PAGE");
		lblSelect.setBounds(513, 7, 81, 16);
		select.add(lblSelect);
		
		JComboBox comboBox = new JComboBox(tables);
		comboBox.setBounds(476, 81, 158, 27);
		select.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Please select the table listed below");
		lblNewLabel_4.setBounds(446, 53, 251, 16);
		select.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 158, 1076, 433);
		select.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton btnNewButton_5 = new JButton("Show the table!");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectPageSelectMethod(comboBox,textArea);
			}
		});
		btnNewButton_5.setBounds(457, 117, 193, 29);
		select.add(btnNewButton_5);
		
		
		JPanel add = new JPanel();
		layeredPane.add(add, "name_39231361191125");
		add.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PAGE");
		lblNewLabel.setBounds(511, 5, 65, 16);
		add.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(70, 124, 938, 26);
		add.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox(addableTables);
		comboBox_5.setBounds(481, 85, 127, 27);
		comboBox_5.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	addPageShowFormat(comboBox_5, textField_3);
		    }
		});
		add.add(comboBox_5);
		
		JLabel lblNewLabel_11 = new JLabel("Please select the table that you will add:");
		lblNewLabel_11.setBounds(414, 57, 252, 16);
		add.add(lblNewLabel_11);
		
		
		JButton btnNewButton_12 = new JButton("Add Instance");
		btnNewButton_12.setBounds(481, 162, 117, 29);
		btnNewButton_12.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	addPageAddInstance(comboBox_5,textField_3);
		    }
		});
		add.add(btnNewButton_12);
		
		JPanel delete = new JPanel();
		layeredPane.add(delete, "name_38654355264125");
		delete.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DELETE PAGE");
		lblNewLabel_1.setBounds(495, 6, 82, 16);
		delete.add(lblNewLabel_1);
		
		JComboBox comboBox_4 = new JComboBox(tables);
		comboBox_4.setBounds(460, 73, 158, 27);
		delete.add(comboBox_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("Select the table listed below");
		lblNewLabel_4_2.setBounds(450, 46, 193, 16);
		delete.add(lblNewLabel_4_2);
		
		JButton btnNewButton_5_2 = new JButton("Delete!");
		btnNewButton_5_2.setBounds(439, 112, 193, 29);
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePageDeleteAllMethod(comboBox_4);
			}
		});
		delete.add(btnNewButton_5_2);
		
		JPanel update = new JPanel();
		layeredPane.add(update, "name_38713762371833");
		update.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("UPDATE PAGE");
		lblNewLabel_2.setBounds(501, 5, 86, 16);
		update.add(lblNewLabel_2);
		
		JLabel lblNewLabel_12 = new JLabel("Please select the table below:");
		lblNewLabel_12.setBounds(446, 55, 201, 16);
		update.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 153, 736, 26);
		update.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_6 = new JComboBox(tables);
		comboBox_6.setBounds(477, 93, 135, 27);
		comboBox_6.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	updatePageShowFormat(comboBox_6, textField_4);
		    }
		});
		update.add(comboBox_6);
		
		
		JButton btnNewButton_13 = new JButton("Update!");
		btnNewButton_13.setBounds(488, 209, 117, 29);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePageUpdateInstance(comboBox_6,textField_4);
			}
		});
		update.add(btnNewButton_13);
		
		JPanel view = new JPanel();
		layeredPane.add(view, "name_38718758206041");
		view.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("VIEW PAGE");
		lblNewLabel_3.setBounds(510, 6, 66, 16);
		view.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox(views);
		comboBox_2.setBounds(440, 105, 219, 27);
		view.add(comboBox_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Please select the view listed below");
		lblNewLabel_4_1.setBounds(440, 70, 219, 16);
		view.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 188, 1076, 403);
		view.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnNewButton_5_1 = new JButton("Show the view!");
		btnNewButton_5_1.setBounds(472, 147, 140, 29);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPageSelectMethod(comboBox_2,textArea_2);
			}
		});
		
		view.add(btnNewButton_5_1);
		
		JPanel selectWithId = new JPanel();
		layeredPane.add(selectWithId, "name_56233281293209");
		selectWithId.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("SELECT WITH ID PAGE");
		lblNewLabel_5.setBounds(480, 6, 136, 16);
		selectWithId.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox(tables);
		comboBox_1.setBounds(471, 76, 158, 27);
		selectWithId.add(comboBox_1);
		
		JLabel lblNewLabel_7 = new JLabel("Please select the table listed below");
		lblNewLabel_7.setBounds(446, 44, 236, 16);
		selectWithId.add(lblNewLabel_7);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 200, 1076, 391);
		selectWithId.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		textField = new JTextField();
		textField.setBounds(486, 140, 130, 26);
		selectWithId.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Show the item!");
		btnNewButton_9.setBounds(496, 169, 117, 29);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectWithIdPageSelectMethod(comboBox_1,textArea_1,textField);
			}
		});
		selectWithId.add(btnNewButton_9);
		
		JLabel lblNewLabel_7_1 = new JLabel("Please enter the id");
		lblNewLabel_7_1.setBounds(490, 115, 124, 16);
		selectWithId.add(lblNewLabel_7_1);
		
		
		JPanel deleteWithId = new JPanel();
		layeredPane.add(deleteWithId, "name_56244702026125");
		deleteWithId.setLayout(null);
		
		JLabel lblDeleteWithId = new JLabel("DELETE WITH ID PAGE");
		lblDeleteWithId.setBounds(475, 5, 137, 16);
		deleteWithId.add(lblDeleteWithId);
		
		JComboBox comboBox_1_1 = new JComboBox(tables);
		comboBox_1_1.setBounds(471, 76, 158, 27);
		deleteWithId.add(comboBox_1_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Please select the table listed below");
		lblNewLabel_7_2.setBounds(446, 44, 236, 16);
		deleteWithId.add(lblNewLabel_7_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(486, 140, 130, 26);
		deleteWithId.add(textField_2);
		
		JButton btnNewButton_9_1 = new JButton("Delete the item!");
		btnNewButton_9_1.setBounds(475, 169, 154, 29);
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteWithIdPageDeleteIdMethod(comboBox_1_1,textField_2);
			}
		});
		deleteWithId.add(btnNewButton_9_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Please enter the id");
		lblNewLabel_7_1_1.setBounds(490, 115, 124, 16);
		deleteWithId.add(lblNewLabel_7_1_1);
		
		JPanel manualQuery = new JPanel();
		layeredPane.add(manualQuery, "name_56254636934000");
		manualQuery.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("MANUAL QUERY PAGE");
		lblNewLabel_6.setBounds(461, 6, 137, 16);
		manualQuery.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(408, 81, 257, 26);
		manualQuery.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Enter the query:");
		lblNewLabel_9.setBounds(478, 66, 115, 16);
		manualQuery.add(lblNewLabel_9);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(6, 189, 1076, 408);
		manualQuery.add(scrollPane_3);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		
		JButton btnNewButton_5_2_1 = new JButton("Execute Update!");
		btnNewButton_5_2_1.setBounds(408, 130, 137, 29);
		btnNewButton_5_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manualQueryPageExecuteUpdate(textField_1);
			}
		});
		manualQuery.add(btnNewButton_5_2_1);
		
		JButton btnNewButton_5_2_1_1 = new JButton("Execute Query!");
		btnNewButton_5_2_1_1.setBounds(536, 130, 130, 29);
		btnNewButton_5_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manualQueryPageExecuteQuery(textField_1,textArea_3);
			}
		});
		manualQuery.add(btnNewButton_5_2_1_1);
		
		JPanel joins = new JPanel();
		layeredPane.add(joins, "name_239685073666875");
		joins.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("JOINS PAGE");
		lblNewLabel_8.setBounds(508, 5, 71, 16);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		joins.add(lblNewLabel_8);
		
		JComboBox comboBox_3 = new JComboBox(joinStrings);
		comboBox_3.setBounds(461, 72, 170, 27);
		joins.add(comboBox_3);
		
		JLabel lblNewLabel_10 = new JLabel("Select Join:");
		lblNewLabel_10.setBounds(508, 44, 71, 16);
		joins.add(lblNewLabel_10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(6, 155, 1076, 436);
		joins.add(scrollPane_4);
		
		JTextArea textArea_4 = new JTextArea();
		scrollPane_4.setViewportView(textArea_4);
		
		JButton btnNewButton_11 = new JButton("Run!");
		btnNewButton_11.setBounds(489, 114, 117, 29);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinsPageExecuteQuery(comboBox_3, textArea_4);
			}
		});
		joins.add(btnNewButton_11);
		
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBounds(6, 6, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(select,layeredPane);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(102, 205, 170));
		btnNewButton_1.setBounds(239, 6, 117, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(add,layeredPane);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.setForeground(new Color(221, 160, 221));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(delete,layeredPane);
			}
		});
		btnNewButton_2.setBounds(353, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBackground(new Color(255, 215, 0));
		btnNewButton_3.setForeground(new Color(100, 149, 237));
		btnNewButton_3.setBounds(584, 6, 117, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(update,layeredPane);
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View");
		btnNewButton_4.setBackground(new Color(153, 50, 204));
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(view,layeredPane);
			}
		});
		btnNewButton_4.setBounds(698, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Select with ID");
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(selectWithId,layeredPane);
			}
		});
		btnNewButton_6.setBounds(123, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete with ID");
		btnNewButton_7.setForeground(new Color(135, 206, 235));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(deleteWithId,layeredPane);
			}
		});
		btnNewButton_7.setBounds(467, 6, 117, 29);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Manual Query");
		btnNewButton_8.setBounds(815, 6, 117, 29);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(manualQuery,layeredPane);
			}
		});
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("Joins");
		btnNewButton_10.setForeground(Color.RED);
		btnNewButton_10.setBounds(935, 6, 117, 29);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(joins,layeredPane);
			}
		});
		frame.getContentPane().add(btnNewButton_10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open DB file");
		mnNewMenu.add(mntmNewMenuItem);
	}
}
