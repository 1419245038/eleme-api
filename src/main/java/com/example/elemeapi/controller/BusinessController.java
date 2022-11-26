package com.example.elemeapi.controller;


import com.example.elemeapi.entity.Business;
import com.example.elemeapi.entity.Food;
import com.example.elemeapi.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Business> getAll(){
        return businessService.getAllBusiness();
    }

    @RequestMapping("/getFood/{id}")
    @ResponseBody
    public List<Food> getFoodByBusinessId(@PathVariable("id") Long id){
        return businessService.getFoodByBusinessId(id);
    }

    @RequestMapping("/getBusiness/{id}")
    @ResponseBody
    public Business getBusinessById(@PathVariable("id") Long id){
        return businessService.findBusinessById(id);
    }
}
