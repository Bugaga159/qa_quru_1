package ru.example.homeWork4.model;

import java.util.Arrays;

public class Car {
	private String name;
	private String color;
	private Engine engine;
	private boolean frontWheelDrive;
	private int numberCar;
	private PersonCar[] crew;

	public Car(String name, String color, Engine engine,
			   boolean frontWheelDrive, int numberCar, PersonCar[] crew) {
		this.name = name;
		this.color = color;
		this.engine = engine;
		this.frontWheelDrive = frontWheelDrive;
		this.numberCar = numberCar;
		this.crew = crew;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Engine getEngine() {
		return engine;
	}

	public boolean isFrontWheelDrive() {
		return frontWheelDrive;
	}

	public int getNumberCar() {
		return numberCar;
	}

	public PersonCar[] getCrew() {
		return crew;
	}

	@Override
	public String toString() {
		return "Car{"
				+ "name='" + name + '\''
				+ ", color='" + color + '\''
				+ ", engine=" + engine
				+ ", frontWheelDrive=" + frontWheelDrive
				+ ", numberCar=" + numberCar
				+ ", crew=" + Arrays.toString(crew)
				+ '}';
	}
}
