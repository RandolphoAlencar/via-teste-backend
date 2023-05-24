package com.randolphoalencar.viatestebackend.cmdapi.views;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MainView {

	public static void printMainView() {

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\n\n       Digite o numero do serviço que deseja acessar: \n\n"
						+ "1 - Carrinho de Compra \n" + "2 - Posto de Combustivel \n");

				Integer index = sc.nextInt();

				System.out.println("");

				if (index == 1) {
					ShoppingCartViews.printURLView();
				} else if (index == 2) {
					GasStationViews.printGasView();
				} else {
					System.out.println("Digite uma opção válida!");
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Entre com numero entre as opções validas");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				;
			}
		}
	}
	
}
