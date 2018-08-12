package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.NutritionalInformationDto;
import my.superfood.dto.VitaminDto;
import my.superfood.model.MineralAmount;
import my.superfood.model.NutritionalInformation;
import my.superfood.model.VitaminAmount;

import java.util.ArrayList;
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
        List<VitaminAmount> list = vitaminDtoListToVitaminAmountList(nutritionalInformationDto.getVitamins());
        if (list != null) {
            nutritionalInformation.setVitamins(list);
        }
        List<MineralAmount> list_ = mineralAmountDtoListToMineralAmountList(nutritionalInformationDto.getMinerals());
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
        List<VitaminDto> list = vitaminAmountListToVitaminDtoList(nutritionalInformation.getVitamins());
        if (list != null) {
            nutritionalInformationDto.setVitamins(list);
        }
        List<MineralAmountDto> list_ = mineralAmountListToMineralAmountDtoList(nutritionalInformation.getMinerals());
        if (list_ != null) {
            nutritionalInformationDto.setMinerals(list_);
        }

        return nutritionalInformationDto;
    }

    protected List<VitaminAmount> vitaminDtoListToVitaminAmountList(List<VitaminDto> list) {
        if (list == null) {
            return null;
        }

        List<VitaminAmount> list_ = new ArrayList<VitaminAmount>();
        for (VitaminDto vitaminDto : list) {
            list_.add(vitaminMapper.toVitaminAmount(vitaminDto));
        }

        return list_;
    }

    protected List<MineralAmount> mineralAmountDtoListToMineralAmountList(List<MineralAmountDto> list) {
        if (list == null) {
            return null;
        }

        List<MineralAmount> list_ = new ArrayList<MineralAmount>();
        for (MineralAmountDto mineralAmountDto : list) {
            list_.add(mineralMapper.toMineralAmount(mineralAmountDto));
        }

        return list_;
    }

    protected List<VitaminDto> vitaminAmountListToVitaminDtoList(List<VitaminAmount> list) {
        if (list == null) {
            return null;
        }

        List<VitaminDto> list_ = new ArrayList<VitaminDto>();
        for (VitaminAmount vitaminAmount : list) {
            list_.add(vitaminMapper.toVitaminDto(vitaminAmount));
        }

        return list_;
    }

    protected List<MineralAmountDto> mineralAmountListToMineralAmountDtoList(List<MineralAmount> list) {
        if (list == null) {
            return null;
        }

        List<MineralAmountDto> list_ = new ArrayList<MineralAmountDto>();
        for (MineralAmount mineralAmount : list) {
            list_.add(mineralMapper.toMineralAmountDto(mineralAmount));
        }

        return list_;
    }
}
