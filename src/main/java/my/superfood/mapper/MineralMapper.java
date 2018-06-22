package my.superfood.mapper;

import my.superfood.dto.MineralDto;
import my.superfood.model.MineralAmount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MineralMapper {

    MineralMapper INSTANCE = Mappers.getMapper(MineralMapper.class);

    MineralAmount toMineral(MineralDto mineral);

    MineralDto toMineralRepresentation(MineralAmount mineral);
}
