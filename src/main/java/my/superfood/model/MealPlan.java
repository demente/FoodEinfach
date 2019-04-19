package my.superfood.model;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meal_plan")

@NamedQueries({
        @NamedQuery(name = "allMealPlans",
                query = "SELECT m FROM MealPlan m")})
public class MealPlan {

    public static final double DAYS_IN_WEEK = 7.0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<MealPlanFood> food;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<MealPlanRecipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MealPlanFood> getFood() {
        return food;
    }

    public void setFood(List<MealPlanFood> food) {
        this.food = food;
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

    public List<MealPlanRecipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<MealPlanRecipe> recipes) {
        this.recipes = recipes;
    }

    public NutritionalInformation getDailyAverageNutrition() {
        NutritionalInformation averageNutritionalInfo = new NutritionalInformation();
        for (MealPlanRecipe mealPlanRecipe : getRecipes()) {
            averageNutritionalInfo.addNutritionalInformation(mealPlanRecipe.getRecipe().getNutritionalInformationPerServing());
        }
        averageNutritionalInfo.divide(DAYS_IN_WEEK);
        return averageNutritionalInfo;
    }
}
