package hello;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IfController {

	private Integer Idtam;

	@Autowired
	private UserRepository1 userRepository1;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/nhaptt/{id}")
	public String nhaptt(@PathVariable int id,ModelMap n) {
		Idtam = id;
		n.addAttribute("dk", new Ifuser());
		return ("nhaptt");
	}
	@GetMapping("/suatt/{id}")
	public String suatt(@PathVariable int id,ModelMap n) {
		Idtam=id;
		Ifuser user = userRepository1.findById(id);
		n.addAttribute("dk",user);
		return ("nhaptt");
	}
	@PostMapping("/xulyntt")
	public String xulyntt(@ModelAttribute(value = "dk") Ifuser dk, ModelMap m,BindingResult bindingResult,xulyloi Xulyloi) {
		Xulyloi.validate(dk,bindingResult);
		if (bindingResult.hasErrors()) {
            return "nhaptt";
        }
		dk.setId(Idtam);
		userRepository1.save(dk);
		dk = userRepository1.findById(Idtam);
		m.addAttribute("tt",dk);
		User user = new User();
		user = userRepository.findById(Idtam);
		m.addAttribute("td",user);
		return ("welcome");
		
	}

	@ModelAttribute("genderlist")
		public String[] genderlist() {
		return new String[] {
		        "Male", "Female"
		    };
	}

}
