package my.superfood.model;

import my.superfood.model.enums.MealType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
@NamedQueries({@NamedQuery(name = "allRecipes",
        query = "SELECT r FROM Recipe r"),
        @NamedQuery(name = "recipeByName", query = "SELECT r FROM Recipe r WHERE lower(name) like concat(lower(:name),'%')"),
        @NamedQuery(name = "recipeByType", query = "SELECT r FROM Recipe r left join r.type m where :type=m")})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> ingredients;

    private String instructions; // TODO: to be later changed to a proper entity

    @ElementCollection()
    private List<MealType> type;

    private Long preparationTime;

    private Long cookingTime;
    private Long servings;

    public Long getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Long cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<MealType> getType() {
        return type;
    }

    public void setType(List<MealType> type) {
        this.type = type;
    }

    public Long getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Long preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Long getServings() {
        return servings;
    }

    public void setServings(Long servings) {
        this.servings = servings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionalInformation getNutritionalInformation() {
        NutritionalInformation total = new NutritionalInformation(0L, 0L, 0L, 0L, 0L, 0L);

        for (Ingredient ingredient : getIngredients()) {
            total.addNutritionalInformation(ingredient.getNutritionalInformation());
        }
        return total;
    }

    public NutritionalInformation getNutritionalInformationPerServing() {
        NutritionalInformation total = getNutritionalInformation();

        double servings = getServings();

        total.setCalories(Math.round(total.getCalories() / servings));
        total.setProtein(Math.round(total.getProtein() / servings));
        total.setCarbohydrates(Math.round(total.getCarbohydrates() / servings));
        total.setFat(Math.round(total.getFat() / servings));
        total.setFibre(Math.round(total.getFibre() / servings));
        total.setSugar(Math.round(total.getSugar() / servings));
        for (VitaminAmount vitaminAmount : total.getVitamins()) {
            vitaminAmount.setAmount(Math.round(vitaminAmount.getAmount() / servings));
        }
        for (MineralAmount mineralAmount : total.getMinerals()) {
            mineralAmount.setAmount(Math.round(mineralAmount.getAmount() / servings));
        }

        return total;
    }

}
