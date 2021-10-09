package com.graduate.Controller;

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

	// 장바구니
	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public String bookCart(@RequestParam String userEmail, Model model) {
		UserDTO userDTO = userService.findOneUser(userEmail);

		CartDTO userCart;
		System.out.println(userDTO.toString());
		// model.addAttribute("userCart", userCart);

		return "Cart";
	}

	@RequestMapping(value = "/paySuccess")
	public String payment() {
		return "paySuccess";
	}

	@RequestMapping(value = "/payFail")
	public String payFail() {
		return "payFail";
	}
}
