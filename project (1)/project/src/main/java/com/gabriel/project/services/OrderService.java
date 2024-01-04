package com.gabriel.project.services;

import com.gabriel.project.entities.Order;
import com.gabriel.project.entities.RequestOrder;
import com.gabriel.project.entities.RequestPerson;
import com.gabriel.project.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository; // Component registration


    public Order registerOrder(RequestOrder dataOrder) {
        Order order = new Order();
        BeanUtils.copyProperties(dataOrder, order);
        return (Order) repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Optional<Order> findById(UUID id) {
        return repository.findById(id);
    }
}
