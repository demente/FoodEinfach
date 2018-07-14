package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {WeightMapper.class})
public interface VitaminMapper {

    VitaminMapper INSTANCE = Mappers.getMapper(VitaminMapper.class);

    @Mappings({@Mapping(target = "name", source = "vitamin.name"),
            @Mapping(target = "dailyNorm", source = "vitamin.dailyNorm")})
    VitaminDto toVitaminDto(VitaminAmount vitaminAmount);

    @Mappings({@Mapping(target = "vitamin.name", source = "name"),
            @Mapping(target = "vitamin.dailyNorm", source = "dailyNorm")})
    VitaminAmount toVitaminAmount(VitaminDto vitaminDto);

    VitaminDto toVitaminDto(Vitamin vitamin);

    List<VitaminDto> toVitaminDtoList(List<Vitamin> vitaminList);

    Vitamin toVitamin(VitaminDto vitaminDto);
}
