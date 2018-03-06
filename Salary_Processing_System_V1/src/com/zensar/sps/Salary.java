package com.zensar.sps;

public class Salary {
	private int hra;
	private int pf;
	private int basic;
	
	
	public int getHra() {
		return hra;
	}

	public int getPf() {
		return pf;
	}

	public int getBasic() {
		return basic;
	}


	//Constructor
	public Salary(int hra, int pf, int basic) {
		super();
		this.hra = hra;
		this.pf = pf;
		this.basic = basic;
	}

	//Calculate pf
	public int calculatePf(int basic) {
		return (12/100)*basic;
	}
}
