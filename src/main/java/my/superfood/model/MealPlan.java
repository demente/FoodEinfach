package my.superfood.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<FoodInMealPlan> food;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meal_plan_id")
    private List<RecipeInMealPlan> recipe;

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

    public List<RecipeInMealPlan> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<RecipeInMealPlan> recipe) {
        this.recipe = recipe;
    }
}
