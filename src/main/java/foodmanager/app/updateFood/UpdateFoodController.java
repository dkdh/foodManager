package foodmanager.app.updateFood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodmanager.domain.model.Food;
import foodmanager.domain.service.food.FoodService;

@Controller
@RequestMapping("foods/updateFood")
public class UpdateFoodController{
	@Autowired
	FoodService foodService;
	
	@ModelAttribute
	UpdateFoodForm setUpForm() {
		UpdateFoodForm form = new UpdateFoodForm();
		//기본 값
		/*form.setFoodName("소금");
		form.setCategory("기타");
		form.setNum(200);
		form.setExpirationDate("2010-12-11T11:14:21");
		*/
		return form;
	}
	
	//음식 추가 버튼 클릭 시
	/*@RequestMapping(method = RequestMethod.GET)
	public String addFood(Model model) {
		//UpdateFoodForm form = new UpdateFoodForm();
		

		return "food/updateFood";
	}*/
		
	@RequestMapping(value = "{foodId}",method = RequestMethod.POST)
	public String addFoodtoList(UpdateFoodForm form,@PathVariable("foodId") Integer foodId,Model model) {
		Food food = new Food();
		System.out.println(foodId);
		food.setFoodName(form.getFoodName());
		food.setCategory(form.getCategory());
		System.out.println(food.getCategory());
		food.setExpirationDate(form.getExpirationDate());
		
		//DB에 음식 추가
		
		model.addAttribute("food", food);
		
		return "redirect:/foods/updateFood/{foodId}";
	}
	
	//음식 수정
	@RequestMapping(value = "{foodId}", method = RequestMethod.GET)
	//foodId는 고정 음식 누르면 그거에 해당하는 id불러서 url에 매핑하는 걸로.
	public String updateFoodinList(@PathVariable("foodId") Integer foodId, Model model) {

		
		return "food/updateFood";
	}
	
	//아무 유저 설정
}