package cn.com.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexAction {
	
	@RequestMapping("index")
	public String index(){
		System.out.println(1);
		return "index";
	}

}
