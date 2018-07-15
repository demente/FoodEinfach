package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.MealType;

import java.time.DayOfWeek;

public class MealPlanFoodDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private FoodDto food;
    @JsonProperty
    private WeightDto amount;
    @JsonProperty
    private DayOfWeek dayOfWeek;
    @JsonProperty
    private MealType mealType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public FoodDto getFood() {
        return food;
    }

    public void setFood(FoodDto food) {
        this.food = food;
    }

    public WeightDto getAmount() {
        return amount;
    }

    public void setAmount(WeightDto amount) {
        this.amount = amount;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
