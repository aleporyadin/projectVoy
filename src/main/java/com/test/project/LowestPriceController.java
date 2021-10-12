package com.test.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class LowestPriceController {

    @Autowired
    private  OrderRepository orderRep;
    // get search page
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        return new ModelAndView("search");
    }
    // get search item where price lowest
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam  Map<String, String> body, Model model){
        String searchItem = body.get("item");
        List<Order> ItemsList=  orderRep.findByItem(searchItem);
        if(!ItemsList.isEmpty()) {
            Order LowestOrder = ItemsList.get(0);
            for (Order o : ItemsList) {
                if (o.getPrice() < LowestOrder.getPrice()){
                    LowestOrder = o;
                }
            }
            LowestOrder.setQuantity(LowestOrder.getQuantity()-1);
            model.addAttribute("orders",LowestOrder);
            return new ModelAndView("result");
        }else{
            model.addAttribute("orders",orderRep.findAll());
            return new ModelAndView("result");
        }
    }
}
