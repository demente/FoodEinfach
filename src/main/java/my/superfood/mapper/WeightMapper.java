package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Unit;

import static my.superfood.model.enums.Unit.MICROGRAM;

public class WeightMapper {

    public WeightDto toWeightDto(Long weightInMicrograms) {
        return toWeightDto(weightInMicrograms, MICROGRAM);
    }

    public WeightDto toWeightDto(Long weightInMicrograms, Unit targetUnit) {
        if (weightInMicrograms == null) {
            return null;
        }

        WeightDto dto = new WeightDto();
        dto.setWeight(Double.valueOf(weightInMicrograms) / Double.valueOf(targetUnit.getMultiplier()));
        dto.setUnit(targetUnit.name());
        return dto;
    }

    public Long toWeightInMicrograms(WeightDto weightDto) {
        if (weightDto == null) {
            return null;
        }

        Unit unit = Unit.valueOf(weightDto.getUnit());

        if (unit == null) {
            return null;
        }

        return Math.round(weightDto.getWeight() * unit.getMultiplier());
    }

}
