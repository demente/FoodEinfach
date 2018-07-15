package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.superfood.model.enums.MealType;

import java.time.DayOfWeek;

public class MealPlanRecipeDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private RecipeDto recipe;
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

    public RecipeDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDto recipe) {
        this.recipe = recipe;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
