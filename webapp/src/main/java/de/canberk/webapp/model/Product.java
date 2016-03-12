package de.canberk.webapp.model;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String type;
	private String name;
	private BigDecimal price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getId() + "\n");
		sb.append(getType() + "\n");
		sb.append(getName() + "\n");
		sb.append(getPrice() + ",00 €");
		return sb.toString();
	}

}
