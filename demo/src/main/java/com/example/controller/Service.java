package com.example.controller;

public class Service {
	private Algorism logic;
	public void setLogic (Algorism logic) {
		this.logic = logic;
	}
	public void doProcess(String name) {
		System.out.println("start");
		this.logic.perform(name);
		System.out.println("end");
		
	}
	

}
