package my.superfood.mapper;

import my.superfood.dto.NutritionalInformationDto;
import my.superfood.model.NutritionalInformation;
import org.mapstruct.Mapper;

@Mapper(uses = {WeightMapper.class, VitaminMapper.class, MineralMapper.class})
public interface NutritionalInformationMapper {

    NutritionalInformation toNutritionalInformation(NutritionalInformationDto nutritionalInformationDto);

    NutritionalInformationDto toNutritionalInformationDto(NutritionalInformation nutritionalInformation);

}
