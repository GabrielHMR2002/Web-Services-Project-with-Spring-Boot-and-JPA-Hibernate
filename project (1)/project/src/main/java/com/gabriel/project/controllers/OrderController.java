package com.gabriel.project.controllers;

import com.gabriel.project.entities.Order;
import com.gabriel.project.entities.RequestOrder;
import com.gabriel.project.repositories.OrderRepository;
import com.gabriel.project.services.OrderService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<Order> registerOrder(@RequestBody @Valid RequestOrder dataOrder) {
        Order order = orderService.registerOrder(dataOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrder(@PathVariable(value = "id") UUID id) {
        Optional<Order> optionalOrder = orderService.findById(id);

        if (optionalOrder.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            Order order = optionalOrder.get();
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }
}
