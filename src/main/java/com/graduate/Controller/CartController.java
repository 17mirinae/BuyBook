package com.graduate.Controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.graduate.DTO.*;
import com.graduate.Service.*;

@Controller
@RequestMapping(value = "/cart/*")
public class CartController {
	
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	OrderService orderService;

	// 장바구니
	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public String bookCart(@RequestParam String userEmail, Model model) {
		UserDTO userDTO = userService.findOneUser(userEmail);

		List<CartDTO> cartList = cartService.showUserCart(userDTO.getUserEmail());
		// System.out.println(userDTO.toString());
		model.addAttribute("cartList", cartList);

		return "Cart";
	}
	
	// 장바구니
//	@PostMapping(value = "/Cart")
//	public void bookCart(@RequestParam String userEmail, HttpServletRequest request) {
//		UserDTO userDTO = userService.findOneUser(userEmail);
//		
//		// OrderDTO orderDTO = new OrderDTO(userEmail, );
//		
//		// orderService.addOrder(orderDTO);
//		
//	}

	@RequestMapping(value = "/paySuccess")
	public String payment() {
		return "paySuccess";
	}

	@RequestMapping(value = "/payFail")
	public String payFail() {
		return "payFail";
	}
}
