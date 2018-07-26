package hello.book;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hello.User;
import hello.food.Food;

@Entity
public class Orders {

	public Orders() {
		super();
	}
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	@ManyToOne
    @JoinColumn(name = "food_id")
	public Food food_id;
	@ManyToOne
    @JoinColumn(name = "user_id")
	public User user_id;
	public Integer value;
	public Integer stat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Food getFood_id() {
		return food_id;
	}
	public void setFood_id(Food food_id) {
		this.food_id = food_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	public Orders(Food food_id, User user_id, Integer value,Integer stat) {
		this.food_id = food_id;
		this.user_id = user_id;
		this.value = value;
		this.stat = stat;
	}
	
	
}
