package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class MealPlanDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private List<MealPlanFoodDto> food;
    @JsonProperty
    private List<MealPlanRecipeDto> recipes;
    @JsonProperty
    private Date startDate;
    @JsonProperty
    private Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
