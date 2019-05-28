package foodmanager.app.updateFood;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//입력 폼 클래스
public class UpdateFoodForm {
	
	@NotNull(message = "필수 입력 항목입니다.")
	@Size(min = 1, max = 50)
	private String foodName;
	
	@NotNull(message = "필수 입력 항목입니다.")
	private String category;
	
	@NotNull(message = "필수 입력 항목입니다.")
	private int num;
	
	@NotNull(message = "필수 입력 항목입니다.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expirationDate;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
}