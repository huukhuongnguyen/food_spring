package hello;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import hello.book.Orders;


@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String user;
    private String pass;
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private Set<Orders> order;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<Orders> getOrder() {
		return order;
	}
	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	

	


}