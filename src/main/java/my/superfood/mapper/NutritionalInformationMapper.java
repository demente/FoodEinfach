package my.superfood.mapper;

import my.superfood.dto.NutritionalInformationDto;
import my.superfood.model.NutritionalInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {VitaminMapper.class, MineralMapper.class})
public interface NutritionalInformationMapper {

    @Mappings({
            @Mapping(target = "carbohydrates", source = "carbohydrate.weight"),
            @Mapping(target = "carbohydratesUnit", source = "carbohydrate.unit"),
            @Mapping(target = "fibre", source = "fibre.weight"),
            @Mapping(target = "fibreUnit", source = "fibre.unit"),
            @Mapping(target = "nonSaturatedFat", source = "nonSaturatedFat.weight"),
            @Mapping(target = "nonSaturatedFatUnit", source = "nonSaturatedFat.unit"),
            @Mapping(target = "protein", source = "protein.weight"),
            @Mapping(target = "proteinUnit", source = "protein.unit"),
            @Mapping(target = "saturatedFat", source = "saturatedFat.weight"),
            @Mapping(target = "saturatedFatUnit", source = "saturatedFat.unit"),
            @Mapping(target = "sugar", source = "sugar.weight"),
            @Mapping(target = "sugarUnit", source = "sugar.unit")})
    NutritionalInformation toNutritionalInformation(NutritionalInformationDto nutritionalInformationDto);


    @Mappings({
            @Mapping(source = "carbohydrates", target = "carbohydrate.weight"),
            @Mapping(source = "carbohydratesUnit", target = "carbohydrate.unit"),
            @Mapping(source = "fibre", target = "fibre.weight"),
            @Mapping(source = "fibreUnit", target = "fibre.unit"),
            @Mapping(source = "nonSaturatedFat", target = "nonSaturatedFat.weight"),
            @Mapping(source = "nonSaturatedFatUnit", target = "nonSaturatedFat.unit"),
            @Mapping(source = "protein", target = "protein.weight"),
            @Mapping(source = "proteinUnit", target = "protein.unit"),
            @Mapping(source = "saturatedFat", target = "saturatedFat.weight"),
            @Mapping(source = "saturatedFatUnit", target = "saturatedFat.unit"),
            @Mapping(source = "sugar", target = "sugar.weight"),
            @Mapping(source = "sugarUnit", target = "sugar.unit")})
    NutritionalInformationDto toNutritionalInformationDto(NutritionalInformation nutritionalInformation);

}
