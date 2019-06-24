package foodmanager.domain.model;

import java.io.Serializable;

public class Recipe implements Serializable {

	private static final long serialVersionUID = 4253419048085618218L;

	private int recipeId;
	
	private String recipeName;
	
	private String neededFood;
	
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getNeededFood() {
		return neededFood;
	}

	public void setNeededFood(String neededFood) {
		this.neededFood = neededFood;
	}

}
