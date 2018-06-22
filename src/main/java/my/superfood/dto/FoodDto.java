package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class FoodDto {

    @JsonProperty
    private String name;
    @JsonProperty
    private String type;
    @JsonProperty
    private WeightDto weightPerServing;
    @JsonProperty
    private NutritionalInformationDto nutritionalInformation;
    @JsonProperty
    private List<VitaminDto> vitamins;
    @JsonProperty
    private List<MineralDto> minerals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WeightDto getWeightPerServing() {
        return weightPerServing;
    }

    public void setWeightPerServing(WeightDto weightPerServing) {
        this.weightPerServing = weightPerServing;
    }

    public NutritionalInformationDto getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(NutritionalInformationDto nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    public List<VitaminDto> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<VitaminDto> vitamins) {
        this.vitamins = vitamins;
    }

    public List<MineralDto> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<MineralDto> minerals) {
        this.minerals = minerals;
    }
}
