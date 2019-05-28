package foodmanager.app.food;

//import java.time.LocalDateTime;
import java.util.List;

import foodmanager.domain.service.food.FoodService;
import foodmanager.domain.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("foods")
public class FoodsController{
	@Autowired
	FoodService foodService;
	
	@RequestMapping(method = RequestMethod.GET)
	String listFoods(Model model) {
		
		List<Food> foods = foodService.findAllFoods();
		int size = foods.size()+1;
		
		model.addAttribute("foods", foods);
		model.addAttribute("foodId",size);
		return "food/listFoods";
	}
	
}