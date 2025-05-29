//package com.data.demo14.controller;
//
//import com.data.demo14.model.Product;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.*;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.util.*;
//
//@Controller
//public class ProductController02 {
//
//    @GetMapping("/product")
//    public String showForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "addProduct";
//    }
//
//    @PostMapping("/product")
//    public String addProduct(@ModelAttribute("product") Product product, HttpServletResponse response, @CookieValue(value = "products", defaultValue = "") String productCookie) {
//        String newProduct = product.getName() + "-" + product.getPrice();
//        String updatedCookie = productCookie.isEmpty() ? newProduct : productCookie + ";" + newProduct;
//
//        try {
//            String encoded = URLEncoder.encode(updatedCookie, "UTF-8");
//            Cookie cookie = new Cookie("products", encoded);
//            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
//            cookie.setPath("/");
//            response.addCookie(cookie);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/products";
//    }
//
//    @GetMapping("/products")
//    public String listProducts(@CookieValue(value = "products", defaultValue = "") String productCookie, Model model) {
//        List<Product> productList = new ArrayList<>();
//        try {
//            String decoded = URLDecoder.decode(productCookie, "UTF-8");
//            if (!decoded.isEmpty()) {
//                String[] items = decoded.split(";");
//                for (String item : items) {
//                    String[] parts = item.split("-");
//                    if (parts.length == 2) {
//                        productList.add(new Product(parts[0], Double.parseDouble(parts[1])));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        model.addAttribute("products", productList);
//        return "productList";
//    }
//
//    @GetMapping("/product/delete")
//    public String deleteProduct(@RequestParam("name") String name, @CookieValue(value = "products", defaultValue = "") String productCookie, HttpServletResponse response) {
//        List<String> updatedList = new ArrayList<>();
//
//        try {
//            String decoded = URLDecoder.decode(productCookie, "UTF-8");
//            String[] items = decoded.split(";");
//            for (String item : items) {
//                if (!item.startsWith(name + "-")) {
//                    updatedList.add(item);
//                }
//            }
//
//            String updatedCookie = String.join(";", updatedList);
//            String encoded = URLEncoder.encode(updatedCookie, "UTF-8");
//            Cookie cookie = new Cookie("products", encoded);
//            cookie.setMaxAge(7 * 24 * 60 * 60);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/products";
//    }
//}
