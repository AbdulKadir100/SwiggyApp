package food;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //It will auto increment id
	private int foodId;
	private String foodType;
	private String catogery;
	
	public Food() {
		
	}
	public Food(int id, String foodType, String catogery) {
		this.foodId = id;
		this.foodType = foodType;
		this.catogery = catogery;
	}
	public int getId() {
		return foodId;
	}
	public void setId(int id) {
		this.foodId = id;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getCatogery() {
		return catogery;
	}
	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}
	
	
	
	

}
