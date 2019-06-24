package foodmanager.domain.service.food;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import foodmanager.domain.mapper.FoodMapper;
import foodmanager.domain.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService{
	@Autowired
	FoodMapper foodMapper;
	
	public List<Food> findAllFoods(){
		return foodMapper.findAll();
	}
	
	public List<Food> findExpiredFoods(){
		List<Food> foodsEx=foodMapper.findAll();
		LocalDate today = LocalDate.now();
		for(int i=0;i<foodsEx.size();i++) {
			if (today.isBefore(foodsEx.get(i).getExpirationDate())) {
				foodsEx.remove(i--);
			}
		}
		return foodsEx;
	}
	/*
	public Food findFoodByfoodId(Integer foodId) {
		return foodMapper.findOne(foodId);
	}
	
	public int findFoodIdSet() {
		return foodMapper.findFoodIdSet();
	}
	*/
	public void saveFood(Food food) {
		foodMapper.saveFood(food);
	}

	public void editFood(Food food) {
		foodMapper.editFood(food);
	}
	
	public void deleteFood(int foodId) {
		foodMapper.deleteFood(foodId);
	}
	
}