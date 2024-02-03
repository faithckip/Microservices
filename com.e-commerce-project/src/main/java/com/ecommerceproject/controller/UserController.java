package com.ecommerceproject.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerceproject.models.Product;
import com.ecommerceproject.models.User;
import com.ecommerceproject.services.ProductService;
import com.ecommerceproject.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/register")
	public String registerUser()
	{
		return "register";
	}
	
	@GetMapping("/buy")
	public String buy() {
		
		return "buy";
	}
	
	@GetMapping("/")
	public String userlogin(Model model) {
		
		return "userlogin";
	}
	
	@RequestMapping(value = "userloginvalidate", method = RequestMethod.POST)
	public ModelAndView userlogin(@RequestParam("username") String username, @RequestParam("password") String pass, Model model, HttpServletResponse res) {
		System.out.println(pass);
		
		User u = this.userService.checkLogin(username, pass);
		System.out.println(u.getUsername());
		if(u.getUsername().equals(username)) {
			
			res.addCookie(new Cookie("username", u.getUsername()));
			ModelAndView mView = new ModelAndView( "index");
			mView.addObject( "user", u);
			
			List<Product> products = this.productService.getProducts();
			
			if (products.isEmpty()) {
				
				mView.addObject("msg", "No products are available");
			}
			else {
				mView.addObject("products", products);
			}
			
			return mView;
		}
		else {
			ModelAndView mView = new ModelAndView("userLogin");
			mView.addObject("msg", "Please enter correct email and password");
			return mView;
		}
	}
	@GetMapping("/user/products")
	public ModelAndView getProducts() {
		ModelAndView mView = new ModelAndView("uproduct");
		
		List<Product> products = this.productService.getProducts();
		if(products.isEmpty()) {
			mView.addObject("msg", "No products are available");
			
		}
		else {
			
			mView.addObject("products", products);
		}
		
		return mView;
	}
	
	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public String newUseRegister(@ModelAttribute User user) {
		
		System.out.println(user.getEmail());
		user.setRole("ROLE_NORMAL");
		this.userService.addUser(user);
		
		return "redirect:/";
	}
	
	//for Learning purpose of model
	@GetMapping("/test")
	public String Test(Model model) {
		
		System.out.println("test page");
		model.addAttribute("author", "faith Kip");
		model.addAttribute("id", 40);
		
		List<String> friends = new ArrayList<String>();
		model.addAttribute("f", friends);
		friends.add("xyz");
		friends.add("abc");
		
		return "test";
	}
	
	//for learning purpose of model and view (how data is pass to view)
	
	@GetMapping("/ test2")
	public ModelAndView Test2() {
		
		System.out.println("test page");
		//create modelandView object
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("name", "faith Kiprono 17");
		mv.addObject("id", 40);
		mv.setViewName("test2");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(25);
		mv.addObject("marks", list);
		return mv;
	}
	
//	@GetMapping("carts")
//	public ModelAndView getCartDetail() {
//		
//		ModelAndView mv= new ModelAndView();
//		List<Cart>carts = cartService.getCarts();}
	}
