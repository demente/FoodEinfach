package my.superfood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import my.superfood.api.VitaminRepresentation;
import my.superfood.model.VitaminAmount;

@Mapper
public interface VitaminMapper {

	VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);

	VitaminRepresentation toVitaminRepresentation(VitaminAmount vitamin);

	VitaminAmount toVitamin(VitaminRepresentation vitamin);

}
