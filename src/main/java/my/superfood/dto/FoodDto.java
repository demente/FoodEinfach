package my.superfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoodDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String type;
    @JsonProperty
    private WeightDto weightPerServing;
    @JsonProperty
    private NutritionalInformationDto nutritionalInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
