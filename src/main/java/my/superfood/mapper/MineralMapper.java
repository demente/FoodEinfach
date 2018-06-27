package my.superfood.mapper;

import my.superfood.dto.MineralDto;
import my.superfood.model.MineralAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MineralMapper {

    MineralMapper INSTANCE = Mappers.getMapper(MineralMapper.class);

    @Mappings({
            @Mapping(target = "amount", source = "amount.weight"),
            @Mapping(target = "unit", source = "amount.unit")})
    MineralAmount toMineral(MineralDto mineral);

    @Mappings({
            @Mapping(target = "amount.weight", source = "amount"),
            @Mapping(target = "amount.unit", source = "unit")})
    MineralDto toMineralDto(MineralAmount mineral);
}
