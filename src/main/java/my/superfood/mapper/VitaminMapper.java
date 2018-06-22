package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.VitaminAmount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VitaminMapper {

    VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);

    VitaminDto toVitaminRepresentation(VitaminAmount vitamin);

    VitaminAmount toVitamin(VitaminDto vitamin);

}
