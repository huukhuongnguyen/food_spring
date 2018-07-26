package hello.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
	
	@Autowired
	private UserRepositoryF userRepositoryF;
	@RequestMapping("/food")
	public String listfood(ModelMap m) {
		List<Food> food = userRepositoryF.findAll();
		m.addAttribute("fd",food);
		return "listfood";
	}
	
	@RequestMapping("/addfood")
	public String addfood(ModelMap m) {
		m.addAttribute("af", new Food());
		return"addfood";
	}
	
	@RequestMapping("/editfood/{id}")
	public String editfood(@PathVariable int id,ModelMap m) {
		Food food=userRepositoryF.findById(id);
		m.addAttribute("ef",food);
		return"editfood";
	}
	
	@RequestMapping("/xulyfood")
	public String xulyfood(@ModelAttribute("af") Food food,ModelMap m) {
		userRepositoryF.save(food);
		m.addAttribute("fd",userRepositoryF.findAll());
		return"listfood";
	}
	
	@RequestMapping("/xulyedfood")
	public String xulyedfood(@ModelAttribute("ef") Food food,ModelMap m) {
		userRepositoryF.save(food);
		m.addAttribute("fd",userRepositoryF.findAll());
		return"listfood";
	}
	
	@RequestMapping("/deletefood/{id}")
	public String deletefood(@PathVariable int id,ModelMap m) {
		userRepositoryF.deleteById(id);
		m.addAttribute("fd",userRepositoryF.findAll());
		return "listfood";
	}
	
	@ModelAttribute("statuslist")
	public String[] statuslist() {
	return new String[] {
	        "selling", "stop sell"
	    };
}

}
