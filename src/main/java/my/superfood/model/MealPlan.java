package my.superfood.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

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
    @Temporal(DATE)
    private Date startDate;
    @Temporal(DATE)
    private Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public void setRecipe(List<RecipeInMealPlan> recipe) {
        this.recipe = recipe;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
