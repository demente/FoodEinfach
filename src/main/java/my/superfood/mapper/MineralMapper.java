package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {WeightMapper.class})
public interface MineralMapper {

    MineralMapper INSTANCE = Mappers.getMapper(MineralMapper.class);

    @Mappings({@Mapping(target = "mineral.name", source = "name")})
    MineralAmount toMineralAmount(MineralAmountDto mineralAmountDto);

    @Mappings({@Mapping(target = "name", source = "mineral.name"),
            @Mapping(target = "dailyNorm", source = "mineral.dailyNorm")})
    MineralAmountDto toMineralAmountDto(MineralAmount mineralAmount);

    MineralDto toMineralDto(Mineral mineral);

    List<MineralDto> toMineralDtoList(List<Mineral> mineralList);
}
