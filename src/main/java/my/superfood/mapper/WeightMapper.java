package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper
public interface WeightMapper {

    default WeightDto toWeightDto(Long weight) {
        WeightDto dto = new WeightDto();
        dto.setWeight(weight);
        dto.setUnit("μg");
        return dto;
    }

    default Long toWeight(WeightDto weightDto) {
        if (weightDto == null) {
            return null;
        }
        return weightDto.getWeight();
    }

}
