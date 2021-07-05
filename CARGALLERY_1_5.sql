--DROP VIEW [Leasing Customer View];

CREATE TABLE IF NOT EXISTS technician(
    tech_id integer primary key autoincrement not null,
    mastery varchar(50) not null,
    
    employee_id integer not null,
    m_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (m_id) references maintanence(m_id)
);
CREATE INDEX IF NOT EXISTS index_technician ON technician(mastery);

CREATE TABLE IF NOT EXISTS manager(
    mng_id integer primary key autoincrement not null,
    graduated_unv varchar(50) not null,
    
    employee_id integer not null,
    h_name varchar(50) not null,
    foreign key (employee_id) references employee(employee_id),
    foreign key (h_name) references headquarter(h_name)
);
CREATE INDEX IF NOT EXISTS index_manager ON manager(graduated_unv);

CREATE TABLE IF NOT EXISTS sales_responsible(
    sr_id integer primary key autoincrement not null,
    car_type varchar(50) not null,
    
    employee_id integer not null,
    sale_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (sale_id) references sale(sale_id)
);
CREATE INDEX IF NOT EXISTS index_sales_reponsible ON sales_responsible(car_type);

CREATE TABLE IF NOT EXISTS reception(
    rec_id integer primary key autoincrement not null,
    phone_number varchar(50) not null,
    
    employee_id integer not null,
    appointment_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (appointment_id) references appointment(appointment_id)
);
CREATE UNIQUE INDEX index_reception ON reception(phone_number);

CREATE TABLE IF NOT EXISTS leasing_responsible(
    lr_id integer primary key autoincrement not null,
    
    employee_id integer not null,
    leasing_id integer,
    foreign key (employee_id) references employee(employee_id),
    foreign key (leasing_id) references leasing(leasing_id)
);


CREATE TABLE IF NOT EXISTS showroom(
    showroom_id integer primary key autoincrement not null,
    building varchar(50) not null,
    room_number integer not null,
    capacity integer not null,
    
    dept_name varchar(50) not null,
    foreign key (dept_name) references department(dept_name)
);

CREATE TABLE IF NOT EXISTS employee(
    employee_id integer primary key autoincrement not null,
    name varchar(50) not null,
    address varchar(100) not null,
    salary integer not null,
    gender varchar(50) not null,
    
    tech_id integer,
    mng_id integer,
    sr_id integer,
    rec_id integer,
    lr_id integer,
    dept_name varchar(50) not null,
    
    foreign key (tech_id) references technician(tech_id),
    foreign key (mng_id) references manager(mng_id),
    foreign key (sr_id) references sales_responsible(sr_id),
    foreign key (rec_id) references reception(rec_id),
    foreign key (lr_id) references leasing_responsible(lr_id),
    foreign key (dept_name) references department(dept_name)
    --check (gender in ("Male","Female"))
);
CREATE INDEX IF NOT EXISTS index_employee ON employee(name,address,salary,gender);

CREATE TABLE IF NOT EXISTS department(
    dept_name varchar(50) primary key not null,
    building varchar(50) not null,
    budget integer not null,
    
    --showroom_id integer,
    --employee_id integer,
    h_name varchar(50) not null,
    --foreign key (showroom_id) references showroom(showroom_id),
    --foreign key (employee_id) references employee(employee_id),
    foreign key (h_name) references headquarter(h_name)
);
CREATE INDEX IF NOT EXISTS index_department ON department(building,budget,dept_name);

CREATE TABLE IF NOT EXISTS headquarter(
    h_name varchar(50) primary key not null,
    
    mng_id integer not null,
    foreign key (mng_id) references manager(mng_id)
);

CREATE TABLE IF NOT EXISTS equipment(
    equipment_id integer primary key autoincrement not null,
    equipment_level varchar(50) not null,
    equipment_options varchar(200)
);
CREATE INDEX IF NOT EXISTS index_equipment ON equipment(equipment_level,equipment_options);

CREATE TABLE IF NOT EXISTS tyre(
    tyre_id integer primary key autoincrement not null,
    tyre_mark varchar(50) not null,
    season varchar(50) not null
    check( season in ("Summer","Winter"))
);
CREATE INDEX IF NOT EXISTS index_tyre ON tyre(tyre_mark,season);

CREATE TABLE IF NOT EXISTS motor(
    motor_id integer primary key autoincrement not null,
    engine_capacity double not null,
    engine_power integer not null
);
CREATE INDEX IF NOT EXISTS index_motor ON motor(engine_capacity,engine_power);

CREATE TABLE IF NOT EXISTS truck(
    truck_id integer primary key autoincrement not null,
    towing_capacity integer not null,
    loading_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_truck ON truck(towing_capacity,loading_capacity);

CREATE TABLE IF NOT EXISTS sportscar(
    sc_id integer primary key autoincrement not null,
    max_speed integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_sportscar ON sportscar(max_speed);

CREATE TABLE IF NOT EXISTS normalcar(
    nc_id integer primary key autoincrement not null,
    person_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_normalcar ON normalcar(person_capacity);

CREATE TABLE IF NOT EXISTS suv(
    suv_id integer primary key autoincrement not null,
    is_awd boolean not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_suv ON suv(is_awd);

CREATE TABLE IF NOT EXISTS electricvehicle(
    ev_id integer primary key autoincrement not null,
    battery_capacity integer not null,
    
    car_id integer not null,
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_ev ON electricvehicle(battery_capacity);

CREATE TABLE IF NOT EXISTS maintanence(
    m_id integer primary key autoincrement not null,
    delivery_time time not null,
    
    tech_id integer not null,
    appointment_id integer not null,
    foreign key (tech_id) references technician(tech_id),
    foreign key (appointment_id) references appointment(appointment_id)
    
);
CREATE INDEX IF NOT EXISTS index_maintanence ON maintanence(delivery_time);

CREATE TABLE IF NOT EXISTS sale(
    sale_id integer primary key autoincrement not null,
    
    sr_id integer not null,
    appointment_id integer not null,
    foreign key (sr_id) references sale_responsible(sr_id),
    foreign key (appointment_id) references appointment(appointment_id)
);

CREATE TABLE IF NOT EXISTS leasing(
    leasing_id integer primary key autoincrement not null,
    delivery_date date not null,
    
    lr_id integer not null,
    appointment_id integer not null,
    foreign key (lr_id) references leasing_responsible(lr_id),
    foreign key (appointment_id) references appointment(appointment_id)
);
CREATE INDEX IF NOT EXISTS index_leasing ON leasing(delivery_date);

CREATE TABLE IF NOT EXISTS test(
    test_id integer primary key autoincrement not null,
    test_interval integer not null,
    
    appointment_id integer not null,
    foreign key (appointment_id) references appointment(appointment_id)
);
CREATE INDEX IF NOT EXISTS index_test ON test(test_interval);

CREATE TABLE IF NOT EXISTS appointment(
    appointment_id integer primary key autoincrement not null,
    date_detail date not null,
    
    bill_id integer not null,
    customer_id integer not null,
    m_id integer,
    sale_id integer,
    leasing_id integer,
    test_id integer,
    rec_id integer,
    car_id integer,
    foreign key (bill_id) references bill(bill_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (m_id) references maintanence(m_id),
    foreign key (sale_id) references sale(sale_id),
    foreign key (leasing_id) references leasing(leasing_id),
    foreign key (test_id) references test(test_id),
    foreign key (rec_id) references reception(rec_id),
    foreign key (car_id) references car(car_id)
);
CREATE INDEX IF NOT EXISTS index_appointment ON appointment(date_detail);

CREATE TABLE IF NOT EXISTS bill(
    bill_id integer primary key autoincrement not null,
    bill_date date not null,
    cost integer not null,
    
    appointment_id integer not null,
    customer_id integer not null,
    foreign key (appointment_id) references appointment(appointment_id)
    foreign key (customer_id) references customer(customer_id)
);
CREATE INDEX IF NOT EXISTS index_bill ON bill(bill_date,cost);

CREATE TABLE IF NOT EXISTS test_customer(
    tc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);

CREATE TABLE IF NOT EXISTS maintanence_customer(
    mc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);

CREATE TABLE IF NOT EXISTS leasing_customer(
    lc_id integer primary key autoincrement not null,
    
    customer_id integer,
    foreign key (customer_id) references customer(customer_id) on delete cascade
);

CREATE TABLE IF NOT EXISTS saling_customer(
    sc_id integer primary key autoincrement not null,
    
    customer_id integer not null,
    foreign key (customer_id) references customer(customer_id)
);

CREATE TABLE IF NOT EXISTS customer(
    customer_id integer primary key autoincrement not null,
    name varchar(50) not null,
    money integer not null,
    gender varchar(20) not null,
    email varchar(50) not null,
    
    tc_id integer,
    mc_id integer,
    lc_id integer,
    sc_id integer,
    foreign key (tc_id) references test_customer(tc_id),
    foreign key (mc_id) references maintanence_customer(mc_id),
    foreign key (lc_id) references leasing_customer(lc_id) on delete cascade,
    foreign key (sc_id) references saling_customer(sc_id)
);
CREATE INDEX IF NOT EXISTS index_customer ON customer(name,money,gender,email);


CREATE TABLE IF NOT EXISTS car(
    car_id integer primary key autoincrement not null,
    mark varchar(50) not null,
    weight integer not null,
    size integer not null,
    consumption integer not null,
    
    equipment_id integer not null,
    appointment_id integer,
    tyre_id integer not null,
    motor_id integer not null,
    showroom_id integer not null,
    truck_id integer,
    sc_id integer,
    nc_id integer,
    suv_id integer,
    ev_id integer,
    
    foreign key (equipment_id) references equipment(equipment_id),
    foreign key (appointment_id) references appointment(appointment_id),
    foreign key (tyre_id) references tyre(tyre_id),
    foreign key (motor_id) references motor(motor_id),
    foreign key (showroom_id) references showroom(showroom_id),
    foreign key (truck_id) references truck(truck_id),
    foreign key (sc_id) references sportscar(sc_id),
    foreign key (nc_id) references normalcar(nc_id),
    foreign key (suv_id) references suv(suv_id),
    foreign key (ev_id) references electricvehicle(ev_id)

);
CREATE INDEX IF NOT EXISTS index_car ON car(mark,weight,size,consumption);

--TRIGGER IMPLEMENTATIONS

--Creates trigger for validating attribute range
CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_bill
   BEFORE INSERT ON bill
BEGIN
   SELECT
      CASE
          WHEN NEW.cost<0 THEN RAISE (ABORT,'Invalid cost amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_car
   BEFORE INSERT ON car
BEGIN
   SELECT
      CASE
          WHEN NEW.weight<0 THEN RAISE (ABORT,'Invalid weight amount')
          WHEN NEW.size<0 THEN RAISE (ABORT,'Invalid size amount')
          WHEN NEW.consumption<0 THEN RAISE (ABORT,'Invalid consumption amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_customer
   BEFORE INSERT ON customer
BEGIN
   SELECT
      CASE
          WHEN NEW.email NOT LIKE '%_@__%.__%' THEN RAISE (ABORT,'Invalid email address')
          WHEN NEW.money<0 THEN RAISE (ABORT,'Invalid money amount')
          WHEN (NEW.gender not in ("Female","Male")) THEN RAISE (ABORT,'Invalid gender type')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_department
   BEFORE INSERT ON department
BEGIN
   SELECT
      CASE
          WHEN NEW.budget<0 THEN RAISE (ABORT,'Invalid budget amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_electricvehicle
   BEFORE INSERT ON electricvehicle
BEGIN
   SELECT
      CASE
          WHEN NEW.battery_capacity<0 THEN RAISE (ABORT,'Invalid battery capacity amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_employee
   BEFORE INSERT ON employee
BEGIN
   SELECT
      CASE
          WHEN NEW.salary<0 THEN RAISE (ABORT,'Invalid salary amount')
          WHEN (NEW.gender not in ("Female","Male")) THEN RAISE (ABORT,'Invalid gender type')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_equipment
   BEFORE INSERT ON equipment
BEGIN
   SELECT
      CASE
          WHEN (NEW.equipment_level not in ("High","Medium","Low")) THEN RAISE (ABORT,'Invalid equipment type')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_motor
   BEFORE INSERT ON motor
BEGIN
   SELECT
      CASE
          WHEN NEW.engine_capacity<0 THEN RAISE (ABORT,'Invalid engine capacity amount')
          WHEN NEW.engine_power<0 THEN RAISE (ABORT,'Invalid engine power amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_normalcar
   BEFORE INSERT ON normalcar
BEGIN
   SELECT
      CASE
          WHEN NEW.person_capacity<0 THEN RAISE (ABORT,'Invalid person capacity amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_showroom
   BEFORE INSERT ON showroom
BEGIN
   SELECT
      CASE
          WHEN NEW.capacity<0 THEN RAISE (ABORT,'Invalid showroom capacity amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_sportscar
   BEFORE INSERT ON sportscar
BEGIN
   SELECT
      CASE
          WHEN NEW.max_speed<0 OR NEW.max_speed>400 THEN RAISE (ABORT,'Invalid max speed amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_test
   BEFORE INSERT ON test
BEGIN
   SELECT
      CASE
          WHEN NEW.test_interval<0 THEN RAISE (ABORT,'Invalid test interval amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_truck
   BEFORE INSERT ON truck
BEGIN
   SELECT
      CASE
          WHEN NEW.towing_capacity<0 THEN RAISE (ABORT,'Invalid towing capacity amount')
          WHEN NEW.loading_capacity<0 THEN RAISE (ABORT,'Invalid loading capacity amount')
       END;
END;

CREATE TRIGGER IF NOT EXISTS validate_attribute_range_before_insert_tyre
   BEFORE INSERT ON tyre
BEGIN
   SELECT
      CASE
          WHEN (NEW.season not in ("Summer","Winter")) THEN RAISE (ABORT,'Invalid season type')
       END;
END;


--leasing customer add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_customer_after_add_leasing_customer
   AFTER INSERT ON leasing_customer
BEGIN
    INSERT INTO customer (name, money, gender, email, tc_id, mc_id,lc_id,sc_id) VALUES ("",0,"Female","none@none.com",null,null,NEW.lc_id,null);
    UPDATE leasing_customer SET 
     
    customer_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="customer")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="customer")+1
         ELSE 1
    END  
    
    WHERE lc_id=NEW.lc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_customer_after_delete_leasing_customer
   AFTER DELETE ON leasing_customer
BEGIN
    Delete from customer where customer_id=OLD.customer_id;
END;

--saling customer add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_customer_after_add_saling_customer
   AFTER INSERT ON saling_customer
BEGIN
    INSERT INTO customer (name, money, gender, email, tc_id, mc_id,lc_id,sc_id) VALUES ("",0,"Female","none@none.com",null,null,null,NEW.sc_id);
    UPDATE saling_customer SET 
     
    customer_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="customer")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="customer")+1
         ELSE 1
    END  
    
    WHERE sc_id=NEW.sc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_customer_after_delete_saling_customer
   AFTER DELETE ON saling_customer
BEGIN
    Delete from customer where customer_id=OLD.customer_id;
END;

--maintanence customer add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_customer_after_add_maintanence_customer
   AFTER INSERT ON maintanence_customer
BEGIN
    INSERT INTO customer (name, money, gender, email, tc_id, mc_id,lc_id,sc_id) VALUES ("",0,"Female","none@none.com",null,NEW.mc_id,null,null);
    UPDATE maintanence_customer SET 
     
    customer_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="customer")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="customer")+1
         ELSE 1
    END  
    
    WHERE mc_id=NEW.mc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_customer_after_delete_maintanence_customer
   AFTER DELETE ON maintanence_customer
BEGIN
    Delete from customer where customer_id=OLD.customer_id;
END;

--test customer add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_customer_after_add_test_customer
   AFTER INSERT ON test_customer
BEGIN
    INSERT INTO customer (name, money, gender, email, tc_id, mc_id,lc_id,sc_id) VALUES ("",0,"Female","none@none.com",NEW.tc_id,null,null,null);
    UPDATE test_customer SET 
     
    customer_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="customer")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="customer")+1
         ELSE 1
    END  
    
    WHERE tc_id=NEW.tc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_customer_after_delete_test_customer
   AFTER DELETE ON test_customer
BEGIN
    Delete from customer where customer_id=OLD.customer_id;
END;

--bill update trigger
CREATE TRIGGER IF NOT EXISTS update_customer_id_after_update_bill AFTER 
    UPDATE OF customer_id ON bill
BEGIN
   UPDATE appointment
   SET customer_id=NEW.customer_id
   WHERE bill_id=NEW.bill_id;
END;

--appointment add-delete-update trigger
CREATE TRIGGER IF NOT EXISTS add_bill_after_add_appointment
   AFTER INSERT ON appointment
BEGIN
    INSERT INTO bill (bill_date, cost, appointment_id, customer_id) VALUES ("2012-12-12 00:00:00.000",0,NEW.appointment_id,NEW.customer_id);
    
    UPDATE appointment 
    
    SET bill_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="bill")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="bill")+1
         ELSE 1
    END  
    
    WHERE appointment_id=NEW.appointment_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_bill_after_delete_appointment
   AFTER DELETE ON appointment
BEGIN
    Delete from bill where bill_id=OLD.bill_id;
END;


CREATE TRIGGER IF NOT EXISTS update_customer_id_after_update_appointment AFTER 
    UPDATE OF customer_id ON appointment
BEGIN
   UPDATE bill
   SET customer_id=NEW.customer_id
   WHERE appointment_id=NEW.appointment_id;
END;

CREATE TRIGGER IF NOT EXISTS update_appointment_id_after_update_car_id AFTER 
    UPDATE OF car_id ON appointment
BEGIN
   UPDATE car
   SET appointment_id=NEW.appointment_id
   WHERE car_id=NEW.car_id;
   
   UPDATE car
   SET appointment_id=null
   WHERE car_id=OLD.car_id AND OLD.appointment_id<>NEW.appointment_id;
END;

--maintanence add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_appointment_after_add_maintanence
   AFTER INSERT ON maintanence
BEGIN
    INSERT INTO appointment (date_detail, bill_id, customer_id, m_id, sale_id, leasing_id,test_id,rec_id,car_id) VALUES ("2012-12-12 00:00:00.000",0,0,NEW.m_id,null,null,null,null,null);
    UPDATE maintanence SET 
     
    appointment_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")+1
         ELSE 1
    END  
    
    WHERE m_id=NEW.m_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_appointment_after_delete_maintanence
   AFTER DELETE ON maintanence
BEGIN
    Delete from appointment where appointment_id=OLD.appointment_id;
END;

--leasing add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_appointment_after_add_leasing
   AFTER INSERT ON leasing
BEGIN
    INSERT INTO appointment (date_detail, bill_id, customer_id, m_id, sale_id, leasing_id,test_id,rec_id,car_id) VALUES ("2012-12-12 00:00:00.000",0,0,null,null,NEW.leasing_id,null,null,null);
    UPDATE leasing SET 
     
    appointment_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")+1
         ELSE 1
    END  
    
    WHERE leasing_id=NEW.leasing_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_appointment_after_delete_leasing
   AFTER DELETE ON leasing
BEGIN
    Delete from appointment where appointment_id=OLD.appointment_id;
END;

--sale add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_appointment_after_add_sale
   AFTER INSERT ON sale
BEGIN
    INSERT INTO appointment (date_detail, bill_id, customer_id, m_id, sale_id, leasing_id,test_id,rec_id,car_id) VALUES ("2012-12-12 00:00:00.000",0,0,null,NEW.sale_id,null,null,null,null);
    UPDATE sale SET 
     
    appointment_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")+1
         ELSE 1
    END  
    
    WHERE sale_id=NEW.sale_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_appointment_after_delete_sale
   AFTER DELETE ON sale
BEGIN
    Delete from appointment where appointment_id=OLD.appointment_id;
END;

--test add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_appointment_after_add_test
   AFTER INSERT ON test
BEGIN
    INSERT INTO appointment (date_detail, bill_id, customer_id, m_id, sale_id, leasing_id,test_id,rec_id,car_id) VALUES ("2012-12-12 00:00:00.000",0,0,null,null,null,NEW.test_id,null,null);
    UPDATE test SET 
     
    appointment_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="appointment")+1
         ELSE 1
    END  
    
    WHERE test_id=NEW.test_id;
END;

CREATE TRIGGER IF NOT EXISTS delete_appointment_after_delete_test
   AFTER DELETE ON test
BEGIN
    Delete from appointment where appointment_id=OLD.appointment_id;
END;

--truck add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_car_after_add_truck
   AFTER INSERT ON truck
BEGIN
    INSERT INTO car (mark, weight, size, consumption, equipment_id, appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) 
    VALUES ("",0,0,0,0,null,0,0,0,NEW.truck_id,null,null,null,null);
    UPDATE truck SET 
     
    car_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="car")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="car")+1
         ELSE 1
    END  
    
    WHERE truck_id=NEW.truck_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_car_after_delete_truck
   AFTER DELETE ON truck
BEGIN
    Delete from car where car_id=OLD.car_id;
END;


--sports-car add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_car_after_add_sportscar
   AFTER INSERT ON sportscar
BEGIN
    INSERT INTO car (mark, weight, size, consumption, equipment_id, appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) 
    VALUES ("",0,0,0,0,null,0,0,0,null,NEW.sc_id,null,null,null);
    UPDATE sportscar SET 
     
    car_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="car")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="car")+1
         ELSE 1
    END  
    
    WHERE sc_id=NEW.sc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_car_after_delete_sportscar
   AFTER DELETE ON sportscar
BEGIN
    Delete from car where car_id=OLD.car_id;
END;

--normal-car add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_car_after_add_normalcar
   AFTER INSERT ON normalcar
BEGIN
    INSERT INTO car (mark, weight, size, consumption, equipment_id, appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) 
    VALUES ("",0,0,0,0,null,0,0,0,null,null,NEW.nc_id,null,null);
    UPDATE normalcar SET 
     
    car_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="car")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="car")+1
         ELSE 1
    END  
    
    WHERE nc_id=NEW.nc_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_car_after_delete_normalcar
   AFTER DELETE ON normalcar
BEGIN
    Delete from car where car_id=OLD.car_id;
END;


CREATE TRIGGER IF NOT EXISTS add_car_after_add_ev
   AFTER INSERT ON electricvehicle
BEGIN
    INSERT INTO car (mark, weight, size, consumption, equipment_id, appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) 
    VALUES ("",0,0,0,0,null,0,0,0,null,null,null,null,NEW.ev_id);
    UPDATE electricvehicle SET 
     
    car_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="car")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="car")+1
         ELSE 1
    END  
    
    WHERE ev_id=NEW.ev_id;
END;



CREATE TRIGGER IF NOT EXISTS delete_car_after_delete_ev
   AFTER DELETE ON electricvehicle
BEGIN
    Delete from car where car_id=OLD.car_id;
END;

--suv-car add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_car_after_add_suv
   AFTER INSERT ON suv
BEGIN
    INSERT INTO car (mark, weight, size, consumption, equipment_id, appointment_id,tyre_id,motor_id,showroom_id,truck_id,sc_id,nc_id,suv_id,ev_id) 
    VALUES ("",0,0,0,0,null,0,0,0,null,null,null,NEW.suv_id,null);
    UPDATE suv SET 
     
    car_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="car")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="car")+1
         ELSE 1
    END  
    
    WHERE suv_id=NEW.suv_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_car_after_delete_suv
   AFTER DELETE ON suv
BEGIN
    Delete from car where car_id=OLD.car_id;
END;

--technician add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_employee_after_add_technician
   AFTER INSERT ON technician
BEGIN
    INSERT INTO employee (name, address, salary, gender, tech_id, mng_id,sr_id,rec_id,lr_id,dept_name) 
    VALUES ("","",0,"Female",NEW.tech_id,null,null,null,null,"");
    UPDATE technician SET 
     
    employee_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="employee")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="employee")+1
         ELSE 1
    END  
    
    WHERE tech_id=NEW.tech_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_employee_after_delete_technician
   AFTER DELETE ON technician
BEGIN
    Delete from employee where employee_id=OLD.employee_id;
END;

--manager add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_employee_after_add_manager
   AFTER INSERT ON manager
BEGIN
    INSERT INTO employee (name, address, salary, gender, tech_id, mng_id,sr_id,rec_id,lr_id,dept_name) 
    VALUES ("","",0,"Female",null,NEW.mng_id,null,null,null,"");
    UPDATE manager SET 
     
    employee_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="employee")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="employee")+1
         ELSE 1
    END  
    
    WHERE mng_id=NEW.mng_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_employee_after_delete_manager
   AFTER DELETE ON manager
BEGIN
    Delete from employee where employee_id=OLD.employee_id;
END;

--sales_responsible add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_employee_after_add_sales_responsible
   AFTER INSERT ON sales_responsible
BEGIN
    INSERT INTO employee (name, address, salary, gender, tech_id, mng_id,sr_id,rec_id,lr_id,dept_name) 
    VALUES ("","",0,"Female",null,null,NEW.sr_id,null,null,"");
    UPDATE sales_responsible SET 
     
    employee_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="employee")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="employee")+1
         ELSE 1
    END  
    
    WHERE sr_id=NEW.sr_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_employee_after_delete_sales_responsible
   AFTER DELETE ON sales_responsible
BEGIN
    Delete from employee where employee_id=OLD.employee_id;
END;

--reception add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_employee_after_add_reception
   AFTER INSERT ON reception
BEGIN
    INSERT INTO employee (name, address, salary, gender, tech_id, mng_id,sr_id,rec_id,lr_id,dept_name) 
    VALUES ("","",0,"Female",null,null,null,NEW.rec_id,null,"");
    UPDATE reception SET 
     
    employee_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="employee")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="employee")+1
         ELSE 1
    END  
    
    WHERE rec_id=NEW.rec_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_employee_after_delete_reception
   AFTER DELETE ON reception
BEGIN
    Delete from employee where employee_id=OLD.employee_id;
END;

--leasing_responsible add-delete trigger
CREATE TRIGGER IF NOT EXISTS add_employee_after_add_leasing_responsible
   AFTER INSERT ON leasing_responsible
BEGIN
    INSERT INTO employee (name, address, salary, gender, tech_id, mng_id,sr_id,rec_id,lr_id,dept_name) 
    VALUES ("","",0,"Female",null,null,null,null,NEW.lr_id,"");
    UPDATE leasing_responsible SET 
     
    employee_id = CASE
         WHEN (SELECT seq FROM sqlite_sequence WHERE name="employee")>0 THEN (SELECT seq FROM sqlite_sequence WHERE name="employee")+1
         ELSE 1
    END  
    
    WHERE lr_id=NEW.lr_id;
END;


CREATE TRIGGER IF NOT EXISTS delete_employee_after_delete_leasing_responsible
   AFTER DELETE ON leasing_responsible
BEGIN
    Delete from employee where employee_id=OLD.employee_id;
END;

--car update trigger
CREATE TRIGGER update_car_id_after_update_appointment_id AFTER 
    UPDATE OF appointment_id ON car
BEGIN
   UPDATE appointment
   SET car_id=NEW.car_id
   WHERE appointment_id=NEW.appointment_id;
   
   UPDATE appointment
   SET car_id=null
   WHERE appointment_id=OLD.appointment_id AND OLD.car_id<>NEW.car_id;
END;


--CREATED VIEWS


--CUSTOMER VIEWS
CREATE VIEW IF NOT EXISTS [Leasing Customer View] AS 
    SELECT 
        customer.customer_id,name,money,gender,email,customer.lc_id 
    FROM 
        customer INNER JOIN leasing_customer ON leasing_customer.customer_id = customer.customer_id;


CREATE VIEW IF NOT EXISTS [Saling Customer View] AS 
    SELECT 
        customer.customer_id,name,money,gender,email,customer.sc_id 
    FROM 
        customer INNER JOIN saling_customer ON saling_customer.customer_id = customer.customer_id;
        
CREATE VIEW IF NOT EXISTS [Maintanence Customer View] AS 
    SELECT 
        customer.customer_id,name,money,gender,email,customer.mc_id 
    FROM 
        customer INNER JOIN maintanence_customer ON maintanence_customer.customer_id = customer.customer_id;
        
CREATE VIEW IF NOT EXISTS [Test Customer View] AS 
    SELECT 
        customer.customer_id,name,money,gender,email,customer.tc_id 
    FROM 
        customer INNER JOIN test_customer ON test_customer.customer_id = customer.customer_id;
        

--APPOINTMENT VIEWS
CREATE VIEW IF NOT EXISTS [Maintanence Appointment View] AS 
    SELECT 
        appointment.appointment_id,appointment.date_detail,maintanence.m_id,maintanence.delivery_time,car.car_id,car.mark 
    FROM 
        (maintanence INNER JOIN appointment INNER JOIN car 
        ON maintanence.m_id = appointment.m_id  AND appointment.car_id = car.car_id);
        
        
CREATE VIEW IF NOT EXISTS [Leasing Appointment View] AS 
    SELECT 
        appointment.appointment_id,appointment.date_detail,leasing.leasing_id,leasing.delivery_date,car.car_id,car.mark 
    FROM 
        (leasing INNER JOIN appointment INNER JOIN car 
        ON leasing.leasing_id = appointment.leasing_id  AND appointment.car_id = car.car_id);

CREATE VIEW IF NOT EXISTS [Sale Appointment View] AS 
    SELECT 
        appointment.appointment_id,appointment.date_detail,sale.sale_id,car.car_id,car.mark 
    FROM 
        (sale INNER JOIN appointment INNER JOIN car 
        ON sale.sale_id = appointment.sale_id  AND appointment.car_id = car.car_id);
        
CREATE VIEW IF NOT EXISTS [Test Appointment View] AS 
    SELECT 
        appointment.appointment_id,appointment.date_detail,test.test_id,test.test_interval,car.car_id,car.mark 
    FROM 
        (test INNER JOIN appointment INNER JOIN car 
        ON test.test_id = appointment.test_id  AND appointment.car_id = car.car_id);
        
--CAR VIEWS
CREATE VIEW IF NOT EXISTS [Truck Car View] AS 
    SELECT 
        car.car_id,car.mark,car.weight,car.size,car.consumption,truck.towing_capacity,truck.loading_capacity,motor.engine_capacity,motor.engine_power,tyre.tyre_mark,tyre.season,equipment.equipment_level,equipment.equipment_options
    FROM 
        car 
        INNER JOIN truck ON car.car_id = truck.car_id
        INNER JOIN motor ON motor.motor_id = car.motor_id
        INNER JOIN tyre ON tyre.tyre_id = car.tyre_id
        INNER JOIN equipment ON equipment.equipment_id = car.equipment_id;
        

CREATE VIEW IF NOT EXISTS [Sports Car View] AS 
    SELECT 
        car.car_id,car.mark,car.weight,car.size,car.consumption,sportscar.max_speed,motor.engine_capacity,motor.engine_power,tyre.tyre_mark,tyre.season,equipment.equipment_level,equipment.equipment_options
    FROM 
        car 
        INNER JOIN sportscar ON car.car_id = sportscar.car_id
        INNER JOIN motor ON motor.motor_id = car.motor_id
        INNER JOIN tyre ON tyre.tyre_id = car.tyre_id
        INNER JOIN equipment ON equipment.equipment_id = car.equipment_id;
        
CREATE VIEW IF NOT EXISTS [Normal Car View] AS 
    SELECT 
        car.car_id,car.mark,car.weight,car.size,car.consumption,normalcar.person_capacity,motor.engine_capacity,motor.engine_power,tyre.tyre_mark,tyre.season,equipment.equipment_level,equipment.equipment_options
    FROM 
        car 
        INNER JOIN normalcar ON car.car_id = normalcar.car_id
        INNER JOIN motor ON motor.motor_id = car.motor_id
        INNER JOIN tyre ON tyre.tyre_id = car.tyre_id
        INNER JOIN equipment ON equipment.equipment_id = car.equipment_id;
        
CREATE VIEW IF NOT EXISTS [Suv Car View] AS 
    SELECT 
        car.car_id,car.mark,car.weight,car.size,car.consumption,suv.is_awd,motor.engine_capacity,motor.engine_power,tyre.tyre_mark,tyre.season,equipment.equipment_level,equipment.equipment_options
    FROM 
        car 
        INNER JOIN suv ON car.car_id = suv.car_id
        INNER JOIN motor ON motor.motor_id = car.motor_id
        INNER JOIN tyre ON tyre.tyre_id = car.tyre_id
        INNER JOIN equipment ON equipment.equipment_id = car.equipment_id;
        
        
CREATE VIEW IF NOT EXISTS [Electric Car View] AS 
    SELECT 
        car.car_id,car.mark,car.weight,car.size,car.consumption,electricvehicle.battery_capacity,motor.engine_capacity,motor.engine_power,tyre.tyre_mark,tyre.season,equipment.equipment_level,equipment.equipment_options
    FROM 
        car 
        INNER JOIN electricvehicle ON car.car_id = electricvehicle.car_id
        INNER JOIN motor ON motor.motor_id = car.motor_id
        INNER JOIN tyre ON tyre.tyre_id = car.tyre_id
        INNER JOIN equipment ON equipment.equipment_id = car.equipment_id;
        

--EMPLOYEE VIEWS
CREATE VIEW IF NOT EXISTS [Technician Employee View] AS 
    SELECT 
        employee.employee_id,employee.name,employee.address,employee.salary,employee.gender,technician.mastery,employee.dept_name
    FROM 
        employee 
        INNER JOIN technician ON employee.tech_id = technician.tech_id;
        
CREATE VIEW IF NOT EXISTS [Manager Employee View] AS 
    SELECT 
        employee.employee_id,employee.name,employee.address,employee.salary,employee.gender,manager.graduated_unv,manager.h_name,employee.dept_name
    FROM 
        employee 
        INNER JOIN manager ON employee.mng_id = manager.mng_id;
        
CREATE VIEW IF NOT EXISTS [Sales Responsible Employee View] AS 
    SELECT 
        employee.employee_id,employee.name,employee.address,employee.salary,employee.gender,sales_responsible.car_type,employee.dept_name
    FROM 
        employee 
        INNER JOIN sales_responsible ON employee.sr_id = sales_responsible.sr_id;
        
CREATE VIEW IF NOT EXISTS [Reception Employee View] AS 
    SELECT 
        employee.employee_id,employee.name,employee.address,employee.salary,employee.gender,reception.phone_number,employee.dept_name
    FROM 
        employee 
        INNER JOIN reception ON employee.rec_id = reception.rec_id;
        
CREATE VIEW IF NOT EXISTS [Leasing Responsible Employee View] AS 
    SELECT 
        employee.employee_id,employee.name,employee.address,employee.salary,employee.gender,leasing_responsible.lr_id,employee.dept_name
    FROM 
        employee 
        INNER JOIN leasing_responsible ON employee.lr_id = leasing_responsible.lr_id;
        

--SPECIAL VIEWS
CREATE VIEW IF NOT EXISTS [Appointments with Customer and Bill View] AS 
    SELECT 
        customer.customer_id,name,money,gender,email,appointment.appointment_id,appointment.date_detail,bill.bill_date,bill.cost
    FROM 
        (customer INNER JOIN appointment INNER JOIN bill 
        ON appointment.customer_id = customer.customer_id  AND appointment.appointment_id = bill.appointment_id);
        
        
CREATE VIEW IF NOT EXISTS [Cars with Motor,Tyre and Equipment View] AS 
    SELECT 
        car.car_id,mark,weight,size,consumption,motor.motor_id,motor.engine_capacity,motor.engine_power,tyre.tyre_id,tyre.tyre_mark,tyre.season,equipment.equipment_id,equipment.equipment_level,equipment.equipment_options
    FROM 
        ((car INNER JOIN motor ON car.motor_id = motor.motor_id) 
        INNER JOIN tyre ON car.tyre_id = tyre.tyre_id)
        INNER JOIN equipment ON car.equipment_id = equipment.equipment_id;
        




/*Select * from [Leasing Customer View];

UPDATE customer
SET name = "fatih selim yakar",
    money = 1004,
    gender="Female",
    email="fsyakar@havelsan.com.tr"
WHERE
    customer_id=2; */
    

