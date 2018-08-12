package my.superfood.mapper;

import my.superfood.dto.VitaminDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import my.superfood.model.enums.VitaminName;

import java.util.ArrayList;
import java.util.List;

public class VitaminMapper {

    private final WeightMapper weightMapper;

    public VitaminMapper(WeightMapper weightMapper) {
        this.weightMapper = weightMapper;
    }

    public VitaminDto toVitaminDto(VitaminAmount vitaminAmount) {
        if (vitaminAmount == null) {
            return null;
        }

        VitaminDto vitaminDto = new VitaminDto();

        vitaminDto.setDailyNorm(weightMapper.toWeightDto(vitaminAmountVitaminDailyNorm(vitaminAmount)));
        vitaminDto.setName(vitaminAmountVitaminName(vitaminAmount));
        vitaminDto.setAmount(weightMapper.toWeightDto(vitaminAmount.getAmount()));
        vitaminDto.setId(vitaminAmount.getId());

        return vitaminDto;
    }

    public VitaminAmount toVitaminAmount(VitaminDto vitaminDto) {
        if (vitaminDto == null) {
            return null;
        }

        VitaminAmount vitaminAmount = new VitaminAmount();

        Vitamin vitamin = new Vitamin();
        vitaminAmount.setVitamin(vitamin);

        vitamin.setDailyNorm(weightMapper.toWeight(vitaminDto.getDailyNorm()));
        vitamin.setName(vitaminDto.getName());
        vitaminAmount.setId(vitaminDto.getId());
        vitaminAmount.setAmount(weightMapper.toWeight(vitaminDto.getAmount()));

        return vitaminAmount;
    }

    public VitaminDto toVitaminDto(Vitamin vitamin) {
        if (vitamin == null) {
            return null;
        }

        VitaminDto vitaminDto = new VitaminDto();

        vitaminDto.setName(vitamin.getName());
        vitaminDto.setDailyNorm(weightMapper.toWeightDto(vitamin.getDailyNorm()));

        return vitaminDto;
    }

    public List<VitaminDto> toVitaminDtoList(List<Vitamin> vitaminList) {
        if (vitaminList == null) {
            return null;
        }

        List<VitaminDto> list = new ArrayList<VitaminDto>();
        for (Vitamin vitamin : vitaminList) {
            list.add(toVitaminDto(vitamin));
        }

        return list;
    }

    public Vitamin toVitamin(VitaminDto vitaminDto) {
        if (vitaminDto == null) {
            return null;
        }

        Vitamin vitamin = new Vitamin();

        vitamin.setName(vitaminDto.getName());
        vitamin.setDailyNorm(weightMapper.toWeight(vitaminDto.getDailyNorm()));

        return vitamin;
    }

    private Long vitaminAmountVitaminDailyNorm(VitaminAmount vitaminAmount) {

        if (vitaminAmount == null) {
            return null;
        }
        Vitamin vitamin = vitaminAmount.getVitamin();
        if (vitamin == null) {
            return null;
        }
        Long dailyNorm = vitamin.getDailyNorm();
        if (dailyNorm == null) {
            return null;
        }
        return dailyNorm;
    }

    private VitaminName vitaminAmountVitaminName(VitaminAmount vitaminAmount) {

        if (vitaminAmount == null) {
            return null;
        }
        Vitamin vitamin = vitaminAmount.getVitamin();
        if (vitamin == null) {
            return null;
        }
        VitaminName name = vitamin.getName();
        if (name == null) {
            return null;
        }
        return name;
    }
}
