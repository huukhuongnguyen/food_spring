package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	private Integer Idtam = 0;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRepository1 userRepository1;

	@GetMapping("/dangnhap")
	public String dangnhap(ModelMap n) {
		n.addAttribute("tk", new User());
		return ("dangnhap");
	}

	@RequestMapping("/xuly")
	public String xuly(@ModelAttribute(value = "tk") User tk, ModelMap m) {
		List<User> user = userRepository.findByUserAndPass(tk.getUser(), tk.getPass());
		if (user.size() != 0) {
			return "redirect:/user/"+user.get(0).getId();
		} else {
			m.put("tb", "khong hop le");
			return "dangnhap";
		}

	}

	@RequestMapping("/user/{id}")
	public String xuly(@PathVariable int id, ModelMap m) {
			m.addAttribute("td",userRepository.findById(id));
			Ifuser us = new Ifuser();
			us = userRepository1.findById(id);
			m.addAttribute("tt",us);
			return "welcome";
		

	}

	@RequestMapping("/doimk/{id}")
	public String updateCustomer(@PathVariable int id) {
		Idtam = id;
		return "doimk";
	}

	@RequestMapping("/xulydoimk")
	public String xulydoimk(@RequestParam String oldpass, @RequestParam String newpass, @RequestParam String newpass1,
			ModelMap m) {
		User user = userRepository.findById(Idtam);
		if (oldpass.equals(user.getPass())) {
			if (newpass.equals(newpass1)) {
				user.setPass(newpass);
				userRepository.save(user);
				
				return "redirect:/user/"+user.getId();
			} else {
				m.put("tb", "mat khau moi khong trung nhau");
				return ("doimk");
			}
		} else {
			m.put("tb", "mat khau cu khong dung");
			return ("doimk");
		}
	}

}
