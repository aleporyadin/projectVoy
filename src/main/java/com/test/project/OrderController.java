package com.test.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private  OrderRepository orderRep;

    @GetMapping("/")
    public List<Order> index(){
        return (List<Order>) orderRep.findAll();
    }

    @GetMapping("/{id}")
    public Order show(@PathVariable int id){
        Optional<Order> orderId= orderRep.findById(id);
        Order order = orderId.get();
        return order;
    }

    @PostMapping("/search")
    public List<Order> search(@RequestBody Map<String, String> body){
        String searchItem = body.get("item");
        return orderRep.findByItem(searchItem);
    }

    @PostMapping("/")
    public Order create(@RequestBody Map<String, String> body){
        String item = body.get("item");
        int price = Integer.parseInt(body.get("price"));
        int quantity = Integer.parseInt(body.get("quantity"));

        return orderRep.save(new Order(item, price,quantity));
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable String id, @RequestBody Map<String, String> body){
        int orderId = Integer.parseInt(id);
        // getting blog
        Optional<Order> order = orderRep.findById(orderId);
        order.get().setItem(body.get("item"));
        order.get().setPrice(Integer.parseInt(body.get("price")));
        order.get().setQuantity(Integer.parseInt("quantity"));
        return orderRep.save(order.get());


    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        //int orderId = Integer.parseInt(id);
        orderRep.deleteById(id);
        return true;
    }


}