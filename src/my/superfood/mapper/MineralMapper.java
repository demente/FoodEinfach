package my.superfood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import my.superfood.api.MineralRepresentation;
import my.superfood.model.MineralAmount;

@Mapper
public interface MineralMapper {

	MineralMapper INSTANCE = Mappers.getMapper(MineralMapper.class);

	MineralAmount toMineral(MineralRepresentation mineral);

	MineralRepresentation toMineralRepresentation(MineralAmount mineral);
}
