package hello.book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface BfRepository extends CrudRepository<Orders, Long> {
	@Query("SELECT o FROM Orders o INNER JOIN o.food_id f on o.food_id=f.id and o.user_id.id=:idu and o.stat=0")
	public List<Orders> Listorder(@Param("idu") Integer user);
	
	@Transactional
	public void deleteById(Integer id);
	
	@Query("SELECT DISTINCT o.user_id.id FROM Orders o WhERE o.stat=0")
	public List<Integer> Listidorder();
	
	
}