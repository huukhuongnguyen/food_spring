/*package hello.book;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hello.food.Food;

@Embeddable
public class BookFoodid implements Serializable {

	public Integer idu;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id")
	public Food food;
	 public BookFoodid(){
	    }
	    
	    public BookFoodid(Integer idu, Food food){
	    	this.idu = idu;
	    	this.food = food;
	    }
	public Integer getIdu() {
		return idu;
	}
	public void setIdu(Integer Idu) {
		idu = Idu;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	

}
*/