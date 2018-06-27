package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.VitaminAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VitaminMapper {

    VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);


    @Mappings({
            @Mapping(target = "amount.weight", source = "amount"),
            @Mapping(target = "amount.unit", source = "unit")})
    VitaminDto toVitaminDto(VitaminAmount vitamin);

    @Mappings({
            @Mapping(target = "amount", source = "amount.weight"),
            @Mapping(target = "unit", source = "amount.unit")})
    VitaminAmount toVitamin(VitaminDto vitamin);

}
