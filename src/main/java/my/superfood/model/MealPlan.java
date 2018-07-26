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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<FoodInMealPlan> food;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<RecipeInMealPlan> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FoodInMealPlan> getFood() {
        return food;
    }

    public void setFood(List<FoodInMealPlan> food) {
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

    public List<RecipeInMealPlan> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeInMealPlan> recipes) {
        this.recipes = recipes;
    }
}
