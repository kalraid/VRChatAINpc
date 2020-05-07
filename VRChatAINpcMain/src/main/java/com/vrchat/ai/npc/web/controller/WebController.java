package com.vrchat.ai.npc.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vrchat.ai.npc.web.vo.dataVo;
import com.vrchat.ai.npc.web.vo.testVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("web")
@Slf4j
public class WebController {

	@RequestMapping("/viewTest")
	public String viewTest(Model model) {
		model.addAttribute("message", "Hello Spring Boot thymeleaf");
		ArrayList<testVo> list = new ArrayList<testVo>();
		list.add(new testVo("kim","rie"));
		list.add(new testVo("kim","rie2"));
		list.add(new testVo("kim","rie3"));
		list.add(new testVo("kim","rie4"));
		
		dataVo data = new dataVo();
		data.setPassword("1234");
		
		model.addAttribute("list", list);
		model.addAttribute("bool1", true);
		model.addAttribute("bool2", false);
		model.addAttribute("data", data);
		return "main";
	}

}
