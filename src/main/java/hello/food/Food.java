package hello.food;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import hello.book.*;

@Entity
public class Food {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public String name;
	public double price;
	public String status;
	@OneToMany(mappedBy = "food_id", cascade = CascadeType.ALL)
    public Set<Orders> order ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Orders> getOrder() {
		return order;
	}
	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	
	
	
}
