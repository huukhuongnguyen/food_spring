package hello;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class xulyloi implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(Ifuser.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ifuser user = (Ifuser) target;
		if(user.getName().length()<1){
			errors.rejectValue("name","NotNull");
		}
		if(user.getPhone().length()<1){
			errors.rejectValue("phone","NotNull");
		}
	}
}
