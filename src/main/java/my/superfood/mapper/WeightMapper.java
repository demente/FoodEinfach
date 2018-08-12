package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Unit;

import static my.superfood.model.enums.Unit.MICROGRAM;

public class WeightMapper {

    public WeightDto toWeightDto(Long weight) {
        WeightDto dto = new WeightDto();
        dto.setWeight(weight);
        dto.setUnit(MICROGRAM.name());
        return dto;
    }

    public Long toWeight(WeightDto weightDto) {
        if (weightDto == null) {
            return null;
        }

        Unit unit = Unit.valueOf(weightDto.getUnit());

        if (unit == null) {
            return null;
        }

        return weightDto.getWeight() * unit.getMultiplier();
    }

}
