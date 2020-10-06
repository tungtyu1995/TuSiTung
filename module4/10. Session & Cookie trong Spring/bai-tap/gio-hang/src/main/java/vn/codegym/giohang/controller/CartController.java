package vn.codegym.giohang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.giohang.model.Cart;
import vn.codegym.giohang.model.Product;
import vn.codegym.giohang.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView getCartPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("cart/list");
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        modelAndView.addObject("editItem", new Cart());
        return modelAndView;
    }

    @PostMapping("add")
    public String getCartPage(@RequestParam("id") long productId, HttpSession session) {
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "cart/list";
    }

    public double totalPrice(Map<Long, Cart> cartItems) {
        long count = 0;
        for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * (100 - list.getValue().getProduct().getDiscount())
                    / 100 * list.getValue().getQuantity();
        }
        return count;
    }

//    public double totalAmount(HashMap<Integer, Cart> cartItems) {
//        double sum = 0;
//        int count = 0;
//        double price = 0;
//        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
//            price = Long.parseLong(entry.getValue().getProduct().getPrice());
//            count = entry.getValue().getQuantity();
//            sum += price * count;
//        }
//        return sum;
//    }

    @GetMapping(value = "remove/{id}")
    public String viewRemove(ModelMap modelMap, HttpSession session, @PathVariable("id") long productId) {
        Map<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productId)) {
            cartItems.remove(productId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return "cart/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCart(@PathVariable("id") Long id, @ModelAttribute("editItem") Cart editItem, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cart");
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (cartItems.containsKey(id)) {
            Cart item = cartItems.get(id);
            item.setProduct(product);
            item.setQuantity(editItem.getQuantity());
            cartItems.put(id, item);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotalAmount", totalPrice(cartItems));
        session.setAttribute("myCartNumber", cartItems.size());

        return modelAndView;

    }
}
