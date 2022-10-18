package com.service.impl;

import com.model.Customer;
import com.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SimpleCustomerServiceImpl implements CustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;

    static {
        customers = asList(
                new Customer(autoIncreaseId++, "Hoang Hieu", "xuanhieuvn@codegym.vn", "Hai Duong"),
                new Customer(autoIncreaseId++, "Phan Han", "phan@codegym.vn", "Thai Binh"),
                new Customer(autoIncreaseId++, "Van Thuong", "bathuong@codegym.vn", "Quang Dong"),
                new Customer(autoIncreaseId++, "Huy Trung", "trungtashi@codegym.vn", "Bac Giang"),
                new Customer(autoIncreaseId++, "Thanh Vinh", "vinh@codegym.vn", "Tu Xuyen"),
                new Customer(autoIncreaseId++, "Minh Tuan", "tuan@codegym.vn", "Ho Nam")
        );
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer findOne(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customer.getId() == null ? persist(customer) : merge(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customers.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return ids.stream()
                .map(this::findOne)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customers.size();
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void delete(Customer customer) {
        delete(customer.getId());
    }

    @Override
    public void delete(List<Customer> customers) {
        customers.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        customers = new ArrayList<>();
    }

    private Customer persist(Customer customer) {
        Customer clone = customer.clone();
        clone.setId(autoIncreaseId++);
        customers.add(clone);
        return clone;
    }

    private Customer merge(Customer customer) {
        Customer origin = findOne(customer.getId());
        origin.setName(customer.getName());
        origin.setEmail(customer.getEmail());
        origin.setAddress(customer.getAddress());
        return origin;
    }
}
