package foodmanager.domain.service.food;

import java.util.List;
import java.time.LocalDateTime;

import foodmanager.domain.mapper.FoodMapper;
import foodmanager.domain.model.Food;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodService{
	
	FoodMapper foodMapper = new FoodMapper();
	
	public List<Food> findAllFoods(){
		return foodMapper.findAll();
	}
	
	public Food findFoodByfoodId(Integer foodId) {
		return foodMapper.findOne(foodId);
	}
}