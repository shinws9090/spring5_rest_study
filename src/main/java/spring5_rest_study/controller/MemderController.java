package spring5_rest_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemderController {
	
	@GetMapping("/read")
	public ModelAndView getMember(@RequestParam(value = "id")long id) {
		return new ModelAndView("member/get","id",id);
	}
	
	@GetMapping("/update")
	public ModelAndView updateMember(@RequestParam(value = "id")long id) {
		return new ModelAndView("member/update","id",id);
	}
	
}
