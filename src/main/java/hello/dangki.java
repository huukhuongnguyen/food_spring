package hello;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dangki {

	String key = "";
	String passt="";
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRepository1 userRepository1;
	@Autowired
	public static String random(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	@Autowired
    private JavaMailSender sender;

	@GetMapping("/dangki")
	public String Dangki(ModelMap n) {
		n.addAttribute("dk", new User());
		return ("dangki");
	}

	@PostMapping("/xulidk")
	public String xulidk(@ModelAttribute(value = "dk") User dk, ModelMap m) throws Exception {
		List<User> user = userRepository.findByUser(dk.getUser());
		if (user.size() != 0) {
			m.put("tb", "user da ton tai");
			return ("dangki");
		} else {
			key=random(5);
			MimeMessage message = sender.createMimeMessage();
		    MimeMessageHelper send = new MimeMessageHelper(message);
		    send.setTo(dk.getUser());
	        send.setText(key);
	        send.setSubject("Code active");
	        sender.send(message);
	        passt=dk.getPass();
	        dk.setPass("********");
			m.addAttribute("dk",dk);
			
			return("xacthuc");
		}
	}

	@PostMapping("/xulidk1")
	public String xulidk1(@ModelAttribute(value = "dk") User dk,@RequestParam String code, ModelMap m) {
		if (code.equals(key)) {
			dk.setPass(passt);
			userRepository.save(dk);
			List<User> user1 = userRepository.findByUser(dk.getUser());
			Ifuser us = new Ifuser();
			us.setId(user1.get(0).getId());
			userRepository1.save(us);
			return "redirect:/user/"+user1.get(0).getId();
		} else {
			m.put("tb", "ma xac thuc khong dung");
			m.addAttribute("dk",dk);
			return ("xacthuc");
		}
	}

}
