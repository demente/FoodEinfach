package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

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
    private LocalDate startDate;
    @JsonProperty
    private LocalDate endDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
