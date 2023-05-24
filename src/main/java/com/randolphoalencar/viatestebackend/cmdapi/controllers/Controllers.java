package com.randolphoalencar.viatestebackend.cmdapi.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public final class Controllers implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	public static String createProduct(String url, String productName, Integer status)
			throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.POST(BodyPublishers.ofString("{\"name\": " + "\"" + productName + "\"" + " ,\"orderStatus\": " + status + "}"))
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.timeout(Duration.ofSeconds(5))
				.build();

		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))
				.build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		return response.body();

	}
	
	

	public static String getProduct(String url) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(url))
				.timeout(Duration.ofSeconds(5))
				.build();

		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))
				.build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		return response.body();

	}
	
	
	
	public static Integer updateProduct(String url, String productName, Integer status)
			throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.PUT(BodyPublishers.ofString("{\"name\": " 
						+ "\"" 
						+ productName 
						+ "\"" 
						+ " ,\"orderStatus\": " 
						+ status 
						+ "}"))
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.timeout(Duration.ofSeconds(5))
				.build();

		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))
				.build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		return response.statusCode();

	}

	
	
	public static Integer deleteProduct(String url) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder()
				.DELETE()
				.uri(URI.create(url))
				.timeout(Duration.ofSeconds(5))
				.build();

		HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		return response.statusCode();

	}

}
