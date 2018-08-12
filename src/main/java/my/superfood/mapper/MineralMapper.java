package my.superfood.mapper;

import my.superfood.dto.MineralAmountDto;
import my.superfood.dto.MineralDto;
import my.superfood.model.Mineral;
import my.superfood.model.MineralAmount;
import my.superfood.model.enums.MineralName;

import java.util.ArrayList;
import java.util.List;

public class MineralMapper {


    private final WeightMapper weightMapper;

    public MineralMapper(WeightMapper weightMapper) {
        this.weightMapper = weightMapper;
    }

    public MineralAmount toMineralAmount(MineralAmountDto mineralAmountDto) {
        if (mineralAmountDto == null) {
            return null;
        }

        MineralAmount mineralAmount = new MineralAmount();

        Mineral mineral = new Mineral();
        mineralAmount.setMineral(mineral);

        mineral.setDailyNorm(weightMapper.toWeight(mineralAmountDto.getDailyNorm()));
        mineral.setName(mineralAmountDto.getName());
        mineralAmount.setId(mineralAmountDto.getId());
        mineralAmount.setAmount(weightMapper.toWeight(mineralAmountDto.getAmount()));

        return mineralAmount;
    }

    public MineralAmountDto toMineralAmountDto(MineralAmount mineralAmount) {
        if (mineralAmount == null) {
            return null;
        }

        MineralAmountDto mineralAmountDto = new MineralAmountDto();

        mineralAmountDto.setDailyNorm(weightMapper.toWeightDto(mineralAmountMineralDailyNorm(mineralAmount)));
        mineralAmountDto.setName(mineralAmountMineralName(mineralAmount));
        mineralAmountDto.setAmount(weightMapper.toWeightDto(mineralAmount.getAmount()));
        mineralAmountDto.setId(mineralAmount.getId());

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

    private Long mineralAmountMineralDailyNorm(MineralAmount mineralAmount) {

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

    private MineralName mineralAmountMineralName(MineralAmount mineralAmount) {

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
