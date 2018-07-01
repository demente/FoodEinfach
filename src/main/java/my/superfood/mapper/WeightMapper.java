package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.enums.Unit;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

import static my.superfood.model.enums.Unit.MICROGRAM;

@Mapper
public interface WeightMapper {

    default WeightDto toWeightDto(Long weight) {
        WeightDto dto = new WeightDto();
        dto.setWeight(weight);
        dto.setUnit(MICROGRAM.name());
        return dto;
    }

    default Long toWeight(WeightDto weightDto) {
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
