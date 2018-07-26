package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {
	public List<User> findByUserAndPass(String user,String pass);
	public List<User> findByUser(String user);
	public User findById(Integer Id);

}