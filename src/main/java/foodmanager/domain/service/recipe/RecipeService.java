package foodmanager.domain.service.recipe;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import foodmanager.domain.mapper.RecipeMapper;
import foodmanager.domain.model.Food;
import foodmanager.domain.model.Recipe;
import foodmanager.domain.mapper.FoodMapper;

@Service
public class RecipeService {
	@Autowired
	RecipeMapper recipeMapper;
	
	@Autowired
	FoodMapper foodMapper;
	

	public List<Recipe> findAllRecipes(){
		return recipeMapper.findAll();
	}
	
	public List<Recipe> findAbleRecipes(){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		
		String userName= userDetails.getUsername();
		
		List<Recipe> recipes = findAllRecipes();
		List<Recipe> recipesAble = new LinkedList<>();
		List<Food> foods=foodMapper.findAll(userName);
		
		for(int i =0;i<recipes.size();i++) {
			int count=0;
			String neededFood=recipeMapper.findNeededFood(recipes.get(i).getRecipeId());
			List<String> neededFoods=makeNeededFoods(neededFood);
			int whole=neededFoods.size();
			for(int j=0;j<foods.size();j++) {
				if(neededFoods.contains(foods.get(j).getCategory())) {
					count++;
				}
			}
			if(count/(double)whole>0.6) {
				recipesAble.add(recipes.get(i));
			}
		}
		
		return recipesAble;
	}
	
	public List<String> makeNeededFoods(String neededFood){
		List<String> neededFoods = new LinkedList<>();
		String[] nf=neededFood.split("\\s");
		for(String f: nf) {
			neededFoods.add(f);
		}
		
		return neededFoods;
	}
	
	public List<String> makeSelectableCategory(){
		List<String> categories=  new LinkedList<>();
		List<Recipe> recipes=findAllRecipes();
		for(int i=0;i<recipes.size();i++) {
			String neededFood= recipes.get(i).getNeededFood();
			String[] nf=neededFood.split("\\s");
			for(String f:nf) {
				if(!categories.contains(f)) {
					categories.add(f);
				}
			}
		}
		categories.add("해당없음");
		return categories;
	}
	/*
	public Recipe findRecipeById(int recipeId) {
		return recipeMapper.findOne(recipeId);
	}
	/*
	public String findNeededFoodByRecipeId(int recipeId){
		FoodService foodService = new FoodService();
		Recipe a = findRecipeById(recipeId);
		String neededFood="";
		String sfood = a.getNeededFood();
		String[] foodIds = sfood.split("\\s");
		for(String f : foodIds) {
			Food food = new Food();
			food = foodService.findFoodByfoodId(Integer.parseInt(f));
			if(neededFood.equals("")) {
				neededFood = neededFood + food.getFoodName();
				}
			else {
				neededFood = neededFood + ", " + food.getFoodName();
			}
		}
		return neededFood;
	}
	
	public List<String> findNeededFoodAll(){
		List<String> neededFoods = new LinkedList<>();
		List<Recipe> recipes = findAbleRecipes();
		for(Recipe recipe : recipes) {
			String neededFood = findNeededFoodByRecipeId(recipe.getRecipeId());
			neededFoods.add(neededFood);
		}
		return neededFoods;
	}
	*/
}
