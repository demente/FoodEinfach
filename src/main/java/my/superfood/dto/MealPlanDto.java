package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class MealPlanDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private List<MealPlanFoodDto> food;
    @JsonProperty
    private List<MealPlanRecipeDto> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MealPlanFoodDto> getFood() {
        return food;
    }

    public void setFood(List<MealPlanFoodDto> food) {
        this.food = food;
    }

    public List<MealPlanRecipeDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<MealPlanRecipeDto> recipes) {
        this.recipes = recipes;
    }
}
