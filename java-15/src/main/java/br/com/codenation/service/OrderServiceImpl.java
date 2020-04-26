package br.com.codenation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();
	private final Double DISCOUNT_ON_SALE = 0.2;

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> orderItems) {
		return orderItems.stream()
			.mapToDouble(orderItem -> this.productRepository.findById(orderItem.getProductId())
				.map(product -> product.getIsSale() ? product.getValue() * (1 - DISCOUNT_ON_SALE) : product.getValue())
				.orElse(0.0D) * orderItem.getQuantity())
			.sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> productIds) {
		return productIds.stream()
			.map(productId -> this.productRepository.findById(productId))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
			.mapToDouble(order -> this.calculateOrderValue(order))
			.sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
			.map(productId -> this.productRepository.findById(productId))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.groupingByConcurrent(
				product -> product.getIsSale(),
				Collectors.toList()
			));
	}

}