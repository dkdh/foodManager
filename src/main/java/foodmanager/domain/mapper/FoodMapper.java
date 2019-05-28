package foodmanager.domain.mapper;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;

import foodmanager.domain.model.Food;


//일단 class로. 지금은 실제 DB와의 연결없으니 과정 상 만든 거
public class FoodMapper{
	private List<Food> foods;
	
	public FoodMapper() {
		this.foods = new LinkedList<>();
		List<String> foodName = new LinkedList<>();
		List<Integer> foodId = new LinkedList<>();
		List<String> category = new LinkedList<>();
		List<Integer> num = new LinkedList<>();
		List<LocalDate> expirationDate = new LinkedList<>();
		
		foodName.add("당근");
		foodName.add("설탕");
		foodId.add(0);
		foodId.add(1);
		category.add("기타");
		category.add("설탕");
		num.add(4);
		num.add(150);
		expirationDate.add(LocalDate.parse("2019-12-03"));
		expirationDate.add(LocalDate.parse("2019-05-03"));
		
		for(int i =0;i<foodName.size();i++) {
			Food a = new Food();
			a.setFoodId(foodId.get(i));
			a.setFoodName(foodName.get(i));
			a.setCategory(category.get(i));
			a.setNum(num.get(i));
			a.setExpirationDate(expirationDate.get(i));
			this.foods.add(a);
		}
	}	
	
	public List<Food> findAll() {
		return this.foods;
	}
	
	public Food findOne(Integer foodId) {
		//foodId에 따라 DB에서 맞는 값을 꺼냄
		
		//일단 아무 값이나
		Food a = new Food();
		a.setFoodId(1);
		a.setFoodName("딸기");
		a.setCategory("딸기");
		a.setNum(5);
		a.setExpirationDate(LocalDate.parse("2010-10-10"));
		return a;
	}
	
}