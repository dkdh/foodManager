package foodmanager.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodmanager.domain.model.Food;
import foodmanager.domain.service.food.FoodService;

@Controller
public class FirstpageController{
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	String firstPage(Model model) {
		List<Food> foodsEx = foodService.findExpiredFoods();
		model.addAttribute("foodsEx", foodsEx);
		return "firstPage";
	}
}