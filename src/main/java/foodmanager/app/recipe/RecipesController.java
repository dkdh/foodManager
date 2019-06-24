package foodmanager.app.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodmanager.domain.model.Recipe;
import foodmanager.domain.service.recipe.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipesController{
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String recipeList(Model model) {
		
		List<Recipe> recipes = recipeService.findAbleRecipes();
		//List<Recipe> recipes=recipeService.findAllRecipes();
		
		//List<String> neededFoods = recipeService.findNeededFoodAll();
		
		model.addAttribute("recipes", recipes);
		//model.addAttribute("neededFoods", neededFoods);
		return "recipe/listRecipes";
	}
}