package com.randolphoalencar.viatestebackend.cmdapi.views;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.randolphoalencar.viatestebackend.cmdapi.controllers.Controllers;

public final class Views {

	public static void printMainView() {

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\n\n       Digite o numero do serviço que deseja acessar: \n\n"
						+ "1 - Carrinho de Compra \n" + "2 - Posto de Combustivel \n");

				Integer index = sc.nextInt();

				System.out.println("");

				if (index == 1) {
					printURLView();
				} else if (index == 2) {
					System.out.println("Posto de Gasolina Selecionado");
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
	

	public static void printURLView() {

		boolean exit = false;

		while (exit != true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\n\n       Digite a opção de entrada da URL para requisição:  \n\n"
						+ "1 - http://localhost:8080/products \n" + "2 - Manualmente \n" + "3 - Voltar \n");

				Integer index = sc.nextInt();
				String URL = "http://localhost:8080/products";
				;

				System.out.println("\n");

				if (index == 1 || index == 2) {
					if (index == 2) {
						System.out.print("Digite a URL: ");
						URL = sc.next();
						sc.nextLine();
					}

					requestView(URL);

				} else if (index == 3) {
					exit = true;
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

	private static void requestView(String baseUrl) {

		String url = "";
		boolean exit = false;

		while (exit != true) {
			try {
				Scanner sc = new Scanner(System.in);

				url = baseUrl;
				String id;
				Integer status;
				String name;

				System.out.println(
						"\n\n\n       Digite a opção a ser realizada no carrinho de compra:  \n\n" + "1 - Inserir \n"
								+ "2 - Visualizar \n" + "3 - Atualizar \n" + "4 - Deletar \n" + "5 - Voltar \n");

				Integer index = sc.nextInt();
				System.out.println("\n");

				switch (index) {
				case 1:

					System.out.print("      Digite o Nome do Produto que deseja Inserir: ");

					name = sc.next();
					sc.nextLine();

					System.out.println("\n\n\n       Digite a opção de status do Produto:  \n\n" + "1 - VENDIDO \n"
							+ "2 - NÃO VENDIDO \n");

					status = (sc.nextInt() - 1);
					sc.nextLine();

					if (status == 0 || status == 1) {
						System.out.println(Controllers.createProduct(url, name, status));
					} else {
						System.out.println("\n Digite uma opção válida!");
					}

					break;

				case 2:

					System.out.println("       Digite a opção para visualização dos produtos:  \n\n" + "1 - Todos \n"
							+ "2 - Por Id \n" + "3 - Voltar\n");

					index = sc.nextInt();
					System.out.println("\n");

					if (index == 1 || index == 2) {
						if (index == 2) {
							System.out.print("       Digite o Id do Produto: ");
							id = sc.next();
							sc.nextLine();
							url = baseUrl.concat("/" + id);

						}

						System.out.println("\n" + Controllers.getProduct(url));

					} else if (index == 3) {
						exit = true;
					} else {
						System.out.println("Digite uma opção válida!");
					}

					break;

				case 3:

					System.out.print("      Digite o Id do Produto que deseja Atualizar: ");

					id = sc.next();
					sc.nextLine();
					url = baseUrl.concat("/" + id);

					System.out.print("      Digite o novo Nome do Produto: ");

					name = sc.next();
					sc.nextLine();

					System.out.println("\n\n\n       Digite a opção de status do Produto:  \n\n" + "1 - VENDIDO \n"
							+ "2 - NÃO VENDIDO \n");

					status = (sc.nextInt() - 1);
					sc.nextLine();

					if (status == 0 || status == 1) {
						if (Controllers.updateProduct(url, name, status) == 200) {
							System.out.println("\n Produto " + id + " atualizado com Sucesso!");
						} else {
							System.out.println("\n Não foi possível atualizar o Produto " + id );
						}

					} else {
						System.out.println("\n Digite uma opção válida!");
					}

					break;

				case 4:

					System.out.print("      Digite o Id do Produto que deseja Deletar: ");

					id = sc.next();
					sc.nextLine();
					url = baseUrl.concat("/" + id);

					if (Controllers.deleteProduct(url) == 200) {
						System.out.println("\n Produto " + id + " deletado com Sucesso!");
					} else {
						System.out.println("\n Não foi possível deletar o Produto " + id);
					}

					break;

				case 5:
					exit = true;

					break;

				default:
					System.out.println("Digite uma opção válida! \n\n\n");
					break;
				}

			}

			catch (InputMismatchException e) {
				System.out.println("Entre com numero entre as opção valida");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				;
			}
		}

	}

}
