package foodmanager.domain.mapper;

import java.util.List;

import foodmanager.domain.model.Food;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FoodMapper{
	//모든 음식에 대한 리스트 반환 //이따 뒤에 WHERE userId=#{userId} 추가 그리고 인자 추가userId
	@Select("SELECT * FROM food WHERE userName=#{userName} ORDER by foodId")
	List<Food> findAll(String userName);

	//음식 db에 추가
	@Insert("INSERT INTO food(userName, foodName, category, expirationDate, num) VALUES(#{userName},#{foodName},#{category},#{expirationDate},#{num})")
	void saveFood(Food food);
	
	//음식 db에서 수정
	@Update("UPDATE food SET foodName=#{foodName}, num=#{num}, expirationDate=#{expirationDate}, category=#{category} WHERE foodId=#{foodId}")
	void editFood(Food food);
	
	//음식 삭제
	@Delete("DELETE FROM food WHERE foodId = #{foodId}")
	void deleteFood(int foodId);
	
}