package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.NutritionalInformationDto;
import my.superfood.dto.VitaminAmountDto;
import my.superfood.model.MineralAmount;
import my.superfood.model.NutritionalInformation;
import my.superfood.model.VitaminAmount;

import java.util.List;

public class NutritionalInformationMapper {

    private final VitaminMapper vitaminMapper;
    private final MineralMapper mineralMapper;
    private final WeightMapper weightMapper;

    public NutritionalInformationMapper(VitaminMapper vitaminMapper, MineralMapper mineralMapper, WeightMapper weightMapper) {
        this.vitaminMapper = vitaminMapper;
        this.mineralMapper = mineralMapper;
        this.weightMapper = weightMapper;
    }

    public NutritionalInformation toNutritionalInformation(NutritionalInformationDto nutritionalInformationDto) {
        if (nutritionalInformationDto == null) {
            return null;
        }

        NutritionalInformation nutritionalInformation = new NutritionalInformation();

        nutritionalInformation.setProtein(weightMapper.toWeight(nutritionalInformationDto.getProtein()));
        nutritionalInformation.setFat(weightMapper.toWeight(nutritionalInformationDto.getFat()));
        nutritionalInformation.setCarbohydrates(weightMapper.toWeight(nutritionalInformationDto.getCarbohydrates()));
        nutritionalInformation.setSugar(weightMapper.toWeight(nutritionalInformationDto.getSugar()));
        nutritionalInformation.setFibre(weightMapper.toWeight(nutritionalInformationDto.getFibre()));
        nutritionalInformation.setCalories(nutritionalInformationDto.getCalories());
        List<VitaminAmount> list = vitaminMapper.toVitaminAmountList(nutritionalInformationDto.getVitamins());
        if (list != null) {
            nutritionalInformation.setVitamins(list);
        }
        List<MineralAmount> list_ = mineralMapper.toMineralAmountList(nutritionalInformationDto.getMinerals());
        if (list_ != null) {
            nutritionalInformation.setMinerals(list_);
        }

        return nutritionalInformation;
    }

    public NutritionalInformationDto toNutritionalInformationDto(NutritionalInformation nutritionalInformation) {
        if (nutritionalInformation == null) {
            return null;
        }

        NutritionalInformationDto nutritionalInformationDto = new NutritionalInformationDto();

        nutritionalInformationDto.setCalories(nutritionalInformation.getCalories());
        nutritionalInformationDto.setProtein(weightMapper.toWeightDto(nutritionalInformation.getProtein()));
        nutritionalInformationDto.setFat(weightMapper.toWeightDto(nutritionalInformation.getFat()));
        nutritionalInformationDto.setCarbohydrates(weightMapper.toWeightDto(nutritionalInformation.getCarbohydrates()));
        nutritionalInformationDto.setSugar(weightMapper.toWeightDto(nutritionalInformation.getSugar()));
        nutritionalInformationDto.setFibre(weightMapper.toWeightDto(nutritionalInformation.getFibre()));
        List<VitaminAmountDto> vitaminAmountDtoList = vitaminMapper.toVitaminAmountDtoList(nutritionalInformation.getVitamins());
        if (vitaminAmountDtoList != null) {
            nutritionalInformationDto.setVitamins(vitaminAmountDtoList);
        }
        List<MineralAmountDto> mineralAmountList = mineralMapper.toMineralAmountDtoList(nutritionalInformation.getMinerals());
        if (mineralAmountList != null) {
            nutritionalInformationDto.setMinerals(mineralAmountList);
        }

        return nutritionalInformationDto;
    }

}
