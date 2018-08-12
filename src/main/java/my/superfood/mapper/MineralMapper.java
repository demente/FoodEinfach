package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import my.superfood.model.enums.MineralName;
import my.superfood.resolver.MineralResolver;

import java.util.ArrayList;
import java.util.List;

public class MineralMapper {

    private final MineralResolver mineralResolver;
    private final WeightMapper weightMapper;

    public MineralMapper(MineralResolver mineralResolver, WeightMapper weightMapper) {
        this.mineralResolver = mineralResolver;
        this.weightMapper = weightMapper;
    }

    public MineralAmount toMineralAmount(MineralAmountDto mineralAmountDto) {
        if (mineralAmountDto == null) {
            return null;
        }

        MineralAmount mineralAmount = new MineralAmount();
        mineralAmount.setId(mineralAmountDto.getId());
        mineralAmount.setAmount(weightMapper.toWeight(mineralAmountDto.getAmount()));
        mineralAmount.setMineral(mineralResolver.toMineral(mineralAmountDto.getName()));

        return mineralAmount;
    }

    public MineralAmountDto toMineralAmountDto(MineralAmount mineralAmount) {
        if (mineralAmount == null) {
            return null;
        }

        MineralAmountDto mineralAmountDto = new MineralAmountDto();

        mineralAmountDto.setId(mineralAmount.getId());
        mineralAmountDto.setName(getMineralName(mineralAmount));
        mineralAmountDto.setDailyNorm(weightMapper.toWeightDto(getDailyNorm(mineralAmount)));
        mineralAmountDto.setAmount(weightMapper.toWeightDto(mineralAmount.getAmount()));

        return mineralAmountDto;
    }

    public MineralDto toMineralDto(Mineral mineral) {
        if (mineral == null) {
            return null;
        }

        MineralDto mineralDto = new MineralDto();

        if (mineral.getName() != null) {
            mineralDto.setName(mineral.getName().name());
        }
        mineralDto.setDailyNorm(weightMapper.toWeightDto(mineral.getDailyNorm()));

        return mineralDto;
    }

    public List<MineralDto> toMineralDtoList(List<Mineral> mineralList) {
        if (mineralList == null) {
            return null;
        }

        List<MineralDto> list = new ArrayList<MineralDto>();
        for (Mineral mineral : mineralList) {
            list.add(toMineralDto(mineral));
        }

        return list;
    }

    public List<MineralAmountDto> toMineralAmountDtoList(List<MineralAmount> mineralAmountList) {
        if (mineralAmountList == null) {
            return null;
        }

        List<MineralAmountDto> list = new ArrayList<MineralAmountDto>();
        for (MineralAmount mineralAmount : mineralAmountList) {
            list.add(toMineralAmountDto(mineralAmount));
        }

        return list;
    }

    public List<MineralAmount> toMineralAmountList(List<MineralAmountDto> mineralAmountDtoList) {
        if (mineralAmountDtoList == null) {
            return null;
        }

        List<MineralAmount> list = new ArrayList<MineralAmount>();
        for (MineralAmountDto mineralAmountDto : mineralAmountDtoList) {
            list.add(toMineralAmount(mineralAmountDto));
        }

        return list;
    }

    private Long getDailyNorm(MineralAmount mineralAmount) {

        if (mineralAmount == null) {
            return null;
        }
        Mineral mineral = mineralAmount.getMineral();
        if (mineral == null) {
            return null;
        }
        Long dailyNorm = mineral.getDailyNorm();
        if (dailyNorm == null) {
            return null;
        }
        return dailyNorm;
    }

    private MineralName getMineralName(MineralAmount mineralAmount) {

        if (mineralAmount == null) {
            return null;
        }
        Mineral mineral = mineralAmount.getMineral();
        if (mineral == null) {
            return null;
        }
        MineralName name = mineral.getName();
        if (name == null) {
            return null;
        }
        return name;
    }

}
