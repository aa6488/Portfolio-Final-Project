package kr.co.coco.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class mainController {

	@GetMapping("")
	public String meinForm() {
		return "redirect:/member/mainForm.do";
	}
}
