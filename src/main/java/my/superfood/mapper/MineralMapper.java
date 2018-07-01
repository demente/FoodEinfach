package my.superfood.mapper;

import my.superfood.dto.MineralDto;
import my.superfood.model.MineralAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {WeightMapper.class})
public interface MineralMapper {

    MineralMapper INSTANCE = Mappers.getMapper(MineralMapper.class);

    @Mappings({@Mapping(target = "mineral.name", source = "name")})
    MineralAmount toMineral(MineralDto mineralDto);

    @Mappings({@Mapping(target = "name", source = "mineral.name"),
            @Mapping(target = "dailyNorm", source = "mineral.dailyNorm")})
    MineralDto toMineralDto(MineralAmount mineralAmount);
}
