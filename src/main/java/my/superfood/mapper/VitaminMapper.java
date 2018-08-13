package my.superfood.mapper;

import my.superfood.dto.VitaminAmountDto;
import my.superfood.dto.VitaminDto;
import my.superfood.model.Vitamin;
import my.superfood.model.VitaminAmount;
import my.superfood.model.enums.VitaminName;
import my.superfood.resolver.VitaminResolver;

import java.util.ArrayList;
import java.util.List;

public class VitaminMapper {

    private final WeightMapper weightMapper;
    private final VitaminResolver vitaminResolver;

    public VitaminMapper(VitaminResolver vitaminResolver, WeightMapper weightMapper) {
        this.vitaminResolver = vitaminResolver;
        this.weightMapper = weightMapper;
    }


    public VitaminAmount toVitaminAmount(VitaminAmountDto vitaminAmountDto) {
        if (vitaminAmountDto == null) {
            return null;
        }

        VitaminAmount vitaminAmount = new VitaminAmount();
        vitaminAmount.setId(vitaminAmountDto.getId());
        vitaminAmount.setAmount(weightMapper.toWeightInMicrograms(vitaminAmountDto.getAmount()));

        Vitamin vitamin = vitaminResolver.toVitamin(vitaminAmountDto.getName());
        vitaminAmount.setVitamin(vitamin);

        return vitaminAmount;
    }

    public VitaminAmountDto toVitaminAmountDto(VitaminAmount vitaminAmount) {
        if (vitaminAmount == null) {
            return null;
        }
        VitaminAmountDto vitaminAmountDto = new VitaminAmountDto();

        vitaminAmountDto.setId(vitaminAmount.getId());
        vitaminAmountDto.setName(getVitaminName(vitaminAmount));
        vitaminAmountDto.setDailyNorm(weightMapper.toWeightDto(getDailyNorm(vitaminAmount)));
        vitaminAmountDto.setAmount(weightMapper.toWeightDto(vitaminAmount.getAmount()));

        return vitaminAmountDto;
    }

    public VitaminDto toVitaminDto(Vitamin vitamin) {
        if (vitamin == null) {
            return null;
        }

        VitaminDto vitaminDto = new VitaminDto();

        if (vitamin.getName() != null) {
            vitaminDto.setName(vitamin.getName());
        }
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

    public List<VitaminAmount> toVitaminAmountList(List<VitaminAmountDto> vitaminAmountDtoList) {
        if (vitaminAmountDtoList == null) {
            return null;
        }

        List<VitaminAmount> list = new ArrayList<VitaminAmount>();
        for (VitaminAmountDto vitaminAmountDto : vitaminAmountDtoList) {
            list.add(toVitaminAmount(vitaminAmountDto));
        }

        return list;
    }

    public List<VitaminAmountDto> toVitaminAmountDtoList(List<VitaminAmount> vitaminAmountList) {
        if (vitaminAmountList == null) {
            return null;
        }

        List<VitaminAmountDto> list = new ArrayList<VitaminAmountDto>();
        for (VitaminAmount vitaminAmount : vitaminAmountList) {
            list.add(toVitaminAmountDto(vitaminAmount));
        }

        return list;
    }

    private Long getDailyNorm(VitaminAmount vitaminAmount) {

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

    private VitaminName getVitaminName(VitaminAmount vitaminAmount) {

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
