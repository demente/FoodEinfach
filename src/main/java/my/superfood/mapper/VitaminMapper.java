package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.VitaminAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {WeightMapper.class})
public interface VitaminMapper {

    VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);

    @Mappings({@Mapping(target = "name", source = "vitamin.name")})
    VitaminDto toVitaminDto(VitaminAmount vitaminAmount);

    @Mappings({@Mapping(target = "vitamin.name", source = "name")})
    VitaminAmount toVitamin(VitaminDto vitaminDto);

}
