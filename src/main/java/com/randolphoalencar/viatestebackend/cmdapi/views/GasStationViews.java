package com.randolphoalencar.viatestebackend.cmdapi.views;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.randolphoalencar.viatestebackend.cmdapi.controllers.GasStationControllers;
import com.randolphoalencar.viatestebackend.cmdapi.models.Car;

public final class GasStationViews {

	public static void printGasView() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("\n\n\n       Digite a quantidade de carros para abastecer: ");

			Integer index = sc.nextInt();
			String name;
			Integer fillTime;
			Integer pumps;
			System.out.println("\n");

			System.out.println(index);

			Car[] car = new Car[index];

			for (int i = 0; i < car.length; i++) {

				System.out.print("\n\n\n       Digite o nome de carro " + (i + 1) + ": ");
				name = sc.next();
				sc.nextLine();
				System.out.print("\n      Digite o tempo deabastecimento do carro " + (i + 1) + ": ");
				fillTime = sc.nextInt();

				car[i] = new Car(name, fillTime);

			}

			System.out.print("\n      Digite a quantidade de bombas do posto: ");
			pumps = sc.nextInt();

			GasStationControllers.gasStation(pumps, car);
			
		}

		catch (InputMismatchException e) {
			System.out.println("Entre com numero entre as opções validas");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
		}
	}
}
