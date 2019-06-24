package foodmanager.domain.service.food;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import foodmanager.domain.mapper.FoodMapper;
import foodmanager.domain.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService{
	@Autowired
	FoodMapper foodMapper;
	
	public List<Food> findAllFoods(){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String userName= userDetails.getUsername();
		
		return foodMapper.findAll(userName);
	}
	
	public List<Food> findExpiredFoods(){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String userName= userDetails.getUsername();
		List<Food> foodsEx=foodMapper.findAll(userName);
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
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String userName= userDetails.getUsername();
		food.setUserName(userName);
		foodMapper.saveFood(food);
	}

	public void editFood(Food food) {
		foodMapper.editFood(food);
	}
	
	public void deleteFood(int foodId) {
		foodMapper.deleteFood(foodId);
	}
	
}