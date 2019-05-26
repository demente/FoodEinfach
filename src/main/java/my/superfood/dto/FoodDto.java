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
    private WeightDto weight;
    @JsonProperty
    private String pieceName;
    @JsonProperty
    private NutritionalInformationDto nutritionalInformation;
    @JsonProperty
    private WeightDto minimumWeight;
    @JsonProperty
    private Long pricePerMinimumWeightInCents;
    @JsonProperty
    private String minimumPackageName;

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

    public WeightDto getWeight() {
        return weight;
    }

    public void setWeight(WeightDto weight) {
        this.weight = weight;
    }

    public NutritionalInformationDto getNutritionalInformation() {
        return nutritionalInformation;
    }

    public void setNutritionalInformation(NutritionalInformationDto nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public WeightDto getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(WeightDto minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public Long getPricePerMinimumWeightInCents() {
        return pricePerMinimumWeightInCents;

    public String getMinimumPackageName() {
        return minimumPackageName;
    }

    public void setPricePerMinimumWeightInCents(Long pricePerMinimumWeightInCents) {
        this.pricePerMinimumWeightInCents = pricePerMinimumWeightInCents;
    public void setMinimumPackageName(String minimumPackageName) {
        this.minimumPackageName = minimumPackageName;
    }
}
