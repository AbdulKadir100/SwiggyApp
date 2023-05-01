package food;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepo foodRepo;
	
	//Adding a food
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	 
	//Get all the list of food
	public List<Food> getAll(){
		return foodRepo.findAll();
	}
	
	//Get list of pizza in the db.
	public List<Food> getAllListOfPizza(){
			List<Food> list = foodRepo.findAll();
			return list.stream()
					.filter(food -> food.getFoodType()
							.equalsIgnoreCase("Pizza"))
					.collect(Collectors.toList());
	
	}
	
	//Get single food 
	public Food getSingleFood(Integer id) {
		return foodRepo.findById(id).get();
	}
	
	//Delete single food
	public void delete(Integer id) {
		foodRepo.deleteById(id);
	}
	
	
	

}
