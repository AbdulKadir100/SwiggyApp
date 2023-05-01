package food;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food") 
public class FoodController {
	
	@Autowired
	private final FoodService foodService;

	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@PostMapping("/add")
	public String addFood(Food food) {
		foodService.saveFood(food);
		return "New Food Added..!";
	}
	
	@GetMapping("/getAll")
	public List<Food> getAllFood(){
		System.out.println("In get All method");
		return foodService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Food> getSingleFood(@PathVariable Integer id){
		try {
			Food f = foodService.getSingleFood(id);
			return new ResponseEntity<Food>(f,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateFood(@RequestBody Food food,@PathVariable Integer id){
		try {
			Food f = foodService.getSingleFood(id);
			foodService.saveFood(food);
			return new ResponseEntity<Food>(f,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteFood(@PathVariable Integer id) {
		foodService.delete(id);
	}
	

}
