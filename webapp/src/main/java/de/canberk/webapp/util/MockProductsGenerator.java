package de.canberk.webapp.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.canberk.webapp.model.Product;

public class MockProductsGenerator {

	public enum ProductType {
		BOOK, CD, DVD, BLUERAY;
	}

	public static List<Product> getProducts(int amount) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			Product product = new Product();
			product.setId(i);
			ProductType randomType = randomEnum(ProductType.class);
			product.setType(randomType.name());
			product.setName("Product_" + product.getId());
			product.setPrice(getRandomPrice());
			products.add(product);
		}
		return products;
	}

	private static BigDecimal getRandomPrice() {
		int randomNumber = ThreadLocalRandom.current().nextInt(20, 300 + 1);
		return new BigDecimal(randomNumber);
	}

	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		int x = ThreadLocalRandom.current().nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

	public static void productsToString(List<Product> products) {
		for (Product product : products) {
			System.out.println(product.toString());
		}
	}

}
