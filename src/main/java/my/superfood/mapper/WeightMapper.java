package my.superfood.mapper;

import my.superfood.dto.WeightDto;
import my.superfood.model.Weight;
import org.mapstruct.Mapper;

@Mapper
public interface WeightMapper {

    WeightDto toWeightDto(Weight weight);

    Weight toWeight(WeightDto weightDto);
}
