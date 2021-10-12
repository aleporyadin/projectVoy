package com.test.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private  OrderRepository orderRep;

    @GetMapping("/")
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping (value = "/result",method = RequestMethod.POST)
    public ModelAndView listItem(@RequestParam(required=false,name="item") String _item,
                                 @RequestParam(required=false,name="price") Integer _price,
                                 @RequestParam(required=false,name="quantity") Integer _quantity
            ,Model model) {
        for (Order o : orderRep.findAll()) {
            Date now = new Date();
            if ((now.getTime()/1000 - o.getLive_Timer()) >= 600)
                orderRep.deleteById(o.getId());
        }
        try{
            orderRep.save(new Order(_item,_price,_quantity));

        }catch (Exception e){
            System.out.println("err");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("orders", orderRep.findAll());
        return modelAndView;
    }
    @RequestMapping (value = "/result",method = RequestMethod.GET)
    public ModelAndView listItem(Model model) {
        for (Order o : orderRep.findAll()) {
            Date now = new Date();
            if ((now.getTime()/1000 - o.getLive_Timer()) >= 600)
                orderRep.deleteById(o.getId());
        }
        Iterable<Order>orders = orderRep.findAll();
        model.addAttribute("orders",orders);

        return new ModelAndView("result");
    }


    @PutMapping("/{id}")
    public Order update(@PathVariable String id, @RequestBody Map<String, String> body){
        int orderId = Integer.parseInt(id);
        // geting order
        Order order = orderRep.findById(orderId);
        order.setItem(body.get("item"));
        order.setPrice(Integer.parseInt(body.get("price")));
        order.setQuantity(Integer.parseInt("quantity"));
        return orderRep.save(order);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        //int orderId = Integer.parseInt(id);
        orderRep.deleteById(id);
        return true;
    }
}