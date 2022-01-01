package ru.example.homeWork4;

import ru.example.homeWork4.model.Car;
import ru.example.homeWork4.model.Engine;
import ru.example.homeWork4.model.PersonCar;

import java.util.Arrays;

public class BuildCar {
	public static void main(String[] args) {
		final Car carTeam = new Car("Happy", "black",
				new Engine(4, 2.0, 200),
				true, 36,
				new PersonCar[]{
						new PersonCar("Mike", "driver", 28),
						new PersonCar("Oleg", "navigator", 23)}
		);
		System.out.println("Name car: " + carTeam.getName());
		System.out.println("Color car: " + carTeam.getColor());
		System.out.println("Number car: " + carTeam.getNumberCar());
		System.out.println("Engine: " + carTeam.getEngine());
		Arrays.stream(carTeam.getCrew()).forEach(r -> {
			System.out.println("person: " + r.getName()
					+ " / position: " + r.getPosition()
					+ " / age: " + r.getAge());
		});
	}
}
