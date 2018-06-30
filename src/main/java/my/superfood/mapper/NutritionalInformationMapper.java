package my.superfood.mapper;

import my.superfood.dto.NutritionalInformationDto;
import my.superfood.model.NutritionalInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {VitaminMapper.class, MineralMapper.class, WeightMapper.class})
public interface NutritionalInformationMapper {

    NutritionalInformation toNutritionalInformation(NutritionalInformationDto nutritionalInformationDto);

    NutritionalInformationDto toNutritionalInformationDto(NutritionalInformation nutritionalInformation);

}
