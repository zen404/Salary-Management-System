package com.zensar.sps;

public class Employee {
	int id = 0;
	String first_name = null;
	String last_name = null;
	String band = null;
	int attendance = 0;
	float salary = 0.0f;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", band=" + band
				+ ", attendance=" + attendance + ", salary=" + salary + "]";
	}


	public Employee() {
		super();
	}


	public Employee(int id, String first_name, String last_name,  int attendance,String band) {
		
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.attendance = attendance;
		this.band = band;
		
	}
	
	
	
}
