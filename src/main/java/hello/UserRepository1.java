package hello;


import org.springframework.data.repository.CrudRepository;

import hello.User;

public interface UserRepository1 extends CrudRepository<Ifuser, Long> {
	
	public Ifuser findById(Integer id);

}
