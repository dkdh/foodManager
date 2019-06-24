package foodmanager.app.updateFood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodmanager.domain.model.Food;
import foodmanager.domain.service.food.FoodService;
import foodmanager.domain.service.recipe.RecipeService;

@Controller
@RequestMapping("foods/updateFood")
public class UpdateFoodController{
	@Autowired
	FoodService foodService;
	@Autowired
	RecipeService recipeService;
	
	@ModelAttribute
	UpdateFoodForm setUpForm() {
		UpdateFoodForm form = new UpdateFoodForm();
		//기본 값
		/*form.setFoodName("소금");
		form.setCategory("기타");
		form.setNum(200);
		form.setExpirationDate("2010-12-11");
		*/
		return form;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String updateFoodList(Model model) {
		List<Food> foods = foodService.findAllFoods();
		List<String> categories=recipeService.makeSelectableCategory();
		
		model.addAttribute("foods", foods);
		model.addAttribute("categories",categories);
		return "food/updateFood";
	}
		
	@RequestMapping(method = RequestMethod.POST, params="add")
	public String addFoodtoList(@Validated UpdateFoodForm form, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return updateFoodList(model);
		}
		
		Food food = new Food();
		//System.out.println(foodId);
		//food.setUserName("dkdm");
		food.setFoodName(form.getFoodName());
		food.setCategory(form.getCategory());
		food.setNum(form.getNum());
		food.setExpirationDate(form.getExpirationDate());
		
		//DB에 음식 추가
		foodService.saveFood(food);
		
		model.addAttribute("food", food);
		
		return "redirect:/foods/updateFood";
	}

	@RequestMapping(method = RequestMethod.POST, params="edit")
	public String editFoodList(@Validated UpdateFoodForm form, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return updateFoodList(model);
		}
		
		Food food = new Food();
		food.setFoodId(form.getFoodId());
		food.setUserName(form.getUserName());
		food.setFoodName(form.getFoodName());
		food.setCategory(form.getCategory());
		food.setNum(form.getNum());
		food.setExpirationDate(form.getExpirationDate().plusDays(1));
		
		foodService.editFood(food);
		
		model.addAttribute("food", food);
		
		return "redirect:/foods/updateFood";
	}	
	
	@RequestMapping(method = RequestMethod.POST, params="delete")
	public String deleteFoodfromList(@Validated UpdateFoodForm form, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return updateFoodList(model);
		}
		
		foodService.deleteFood(form.getFoodId());
		return "redirect:/foods/updateFood";
	}
	
	//아무 유저 설정
}