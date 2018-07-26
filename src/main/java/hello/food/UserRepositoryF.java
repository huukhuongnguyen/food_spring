package hello.food;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface UserRepositoryF extends CrudRepository<Food, Long> {
	public List<Food> findAll();
	public Food findById(Integer id);
	public Food findByName(String name);
	
	@Query("Select DISTINCT o.name from Food o Where o.status='selling'")
	public List <String> listnamefood();
	
	@Transactional
	public void deleteById(Integer id);
}
