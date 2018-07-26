package hello.book;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.food.*;
import hello.*;

@Controller
public class bookfoodController {
	Integer idtam;
	@Autowired
	private UserRepositoryF userRepositoryF;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BfRepository bfRepository;
	
	@RequestMapping("/bookfood/{id}")
	public String bookfood(@PathVariable int id,ModelMap m) {
		idtam=id;
		m.addAttribute("abf",userRepositoryF.findAll());
		/*m.addAttribute("adbf",new Orders());*/
		m.addAttribute("lf",userRepositoryF.listnamefood());
		
		List<Orders> a = bfRepository.Listorder(id);
		double tong=0;
		for(Orders each:a) {
			tong=tong+each.getValue()*each.getFood_id().getPrice();
		}
		m.addAttribute("lod",a);
		m.addAttribute("tong",tong);
		return"bookfood";
	}
	
	@RequestMapping("xulybfood")
	public String xulybfood(@RequestParam String nf,@RequestParam Integer value,ModelMap m) {	
		Food food = userRepositoryF.findByName(nf);
		User user = userRepository.findById(idtam);
		Orders order = new Orders(food,user,value,0);
		bfRepository.save(order);
		return"redirect:/bookfood/"+idtam;
	}
	
	@RequestMapping("/deleteorder/{id}")
	public String deleteorder(@PathVariable int id,ModelMap m) {
		bfRepository.deleteById(id);
		return"redirect:/bookfood/"+idtam;
	}
	
	@RequestMapping("odquaylai")
	public String xulybfood() {
		return"redirect:/user/"+idtam;
	}
	
}
