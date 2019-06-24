package foodmanager.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import foodmanager.domain.model.Recipe;

@Mapper
public interface RecipeMapper {
	
	//모든 레시피 반환
	@Select("SELECT * FROM recipe ORDER BY recipeId")
	List<Recipe> findAll();
	
	@Select("SELECT neededFood FROM recipe WHERE recipeId=#{recipeId} ORDER BY recipeId")
	String findNeededFood(int recipeId);

}
