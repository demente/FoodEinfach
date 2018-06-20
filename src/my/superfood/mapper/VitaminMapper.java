package my.superfood.mapper;

import my.superfood.api.VitaminRepresentation;
import my.superfood.model.VitaminAmount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VitaminMapper {

    VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);

    VitaminRepresentation toVitaminRepresentation(VitaminAmount vitamin);

    VitaminAmount toVitamin(VitaminRepresentation vitamin);

}
