package com.randolphoalencar.viatestebackend.cmdapi.models;

import java.util.Objects;

import com.randolphoalencar.viatestebackend.cmdapi.models.enums.OrderStatus;


public class Product {

	private Integer id;
	private String name;
	private OrderStatus orderStatus;

	public Product() {

	}

	public Product(Integer id, String name, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.name = name;
		this.orderStatus = orderStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Produto [id: " + id + ", nome: " + name + ", status:" + orderStatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
