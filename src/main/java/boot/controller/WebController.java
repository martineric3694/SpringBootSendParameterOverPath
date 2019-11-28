package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.controller.model.User;

@Controller
public class WebController {

	@GetMapping("")
	public String showPage(Model model) {
		model.addAttribute("model", new User());
		return "show";
	}
	
	@PostMapping("post")
	public String post(@ModelAttribute User user,Model model) {
		model.addAttribute("model", user);
		return "next";
	}
	
	@PostMapping("postNext")
	public String postNext(@ModelAttribute User user,@RequestParam(name = "value")String value,Model model) {
		model.addAttribute("model", user);
		model.addAttribute("value", value);
		return "result";
	}
}
