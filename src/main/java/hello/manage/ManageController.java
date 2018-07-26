package hello.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.UserRepository1;
import hello.book.BfRepository;
import hello.book.Orders;

@Controller
public class ManageController {
	Integer idtam=0;
	@Autowired
	private BfRepository bfRepository;
	
	@Autowired
	private UserRepository1 userRepository1;
	
	@RequestMapping("/manage")
	public String manage() {
		return"manage"; 
	}
	
	@RequestMapping("/manageorder")
	public String manageorder(ModelMap m) {
		List<Integer> a = bfRepository.Listidorder();
		m.addAttribute("idod",a);
		return"manageorder"; 
	}
	
	@RequestMapping("/manageorder/{id}")
	public String manageorderid(@PathVariable int id,ModelMap m) {
		idtam=id;
		double tong=0;
		List<Orders> a = bfRepository.Listorder(id);
		for(Orders each:a) {
			tong=tong+each.getValue()*each.getFood_id().getPrice();
		}
		m.addAttribute("lod",a);
		m.addAttribute("tong",tong);
		List<Integer> idt = bfRepository.Listidorder();
		m.addAttribute("idod",idt);
		m.addAttribute("id",userRepository1.findById(id).getId());
		m.addAttribute("ns",userRepository1.findById(id).getBirthday());
		m.addAttribute("nm",userRepository1.findById(id).getName());
		m.addAttribute("ph",userRepository1.findById(id).getPhone());
		return"manageorder";
	}
	
	/*@RequestMapping("/pay/{id}")
	public String payid(@PathVariable int id) {
		List<Orders> order = bfRepository.Listorder(id);
		ModelAndView m= new ModelAndView(new exportbillpdf());
		m.addObject("orderlist",order);
		
		return "redirect:/manageorder/"+id;
	}*/
	
	@RequestMapping("/bill/{id}")
	public ModelAndView billid(@PathVariable int id) {
		List<Orders> order = bfRepository.Listorder(id);
		ModelAndView m= new ModelAndView(new exportbillpdf());
		m.addObject("orderlist",order);
		m.addObject("user",userRepository1.findById(id));	
		return m;
}
	@RequestMapping("/pay/{id}")
	public String payid(@PathVariable int id) {
		List<Orders> order = bfRepository.Listorder(id);
		for(Orders each:order) {
			each.setStat(1);
			bfRepository.save(each);
		}
	
		
		return"redirect:/manageorder/"+id;
	}

	
}
