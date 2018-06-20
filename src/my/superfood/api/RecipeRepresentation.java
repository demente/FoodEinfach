package my.superfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class RecipeRepresentation {

    @JsonProperty
    private String name;
    @JsonProperty
    private List<IngredientRepresentation> ingredients;
    @JsonProperty
    private String instructions;
    @JsonProperty
    private List<String> type;
    @JsonProperty
    private Long preparationTime; // in minutes
    @JsonProperty
    private Long servings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientRepresentation> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientRepresentation> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
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

}
