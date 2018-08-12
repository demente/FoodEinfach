package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Unit;

import static my.superfood.model.enums.Unit.MICROGRAM;

public class WeightMapper {

    public WeightDto toWeightDto(Long weight) {
        return toWeightDto(weight, MICROGRAM);
    }

    public WeightDto toWeightDto(Long weight, Unit targetUnit) {
        WeightDto dto = new WeightDto();
        dto.setWeight(weight / targetUnit.getMultiplier());
        dto.setUnit(targetUnit.name());
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
