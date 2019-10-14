package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.sun.org.apache.xalan.internal.xslt.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String home(){
        return "index";
    }


    @GetMapping("/product")
    public ModelAndView showListProduct(){
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView= new ModelAndView("/product/list");
        modelAndView.addObject("product",products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveCreate(@ModelAttribute("product")Product product){
        productService.save(product);
        ModelAndView modelAndView= new ModelAndView("/product/create");
        modelAndView.addObject("product",product);
        return modelAndView;
    }







}
