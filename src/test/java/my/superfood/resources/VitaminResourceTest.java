package my.superfood.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.assertions.DtoAssertions;
import my.superfood.dao.VitaminDao;
import my.superfood.dto.FoodDto;
import my.superfood.dto.MineralDto;
import my.superfood.dto.VitaminDto;
import my.superfood.mapper.VitaminMapper;
import my.superfood.model.Vitamin;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.assertions.DtoAssertions.assertEqualVitaminDto;
import static my.superfood.dto.MineralDtoBuilder.aMineralDto;
import static my.superfood.dto.VitaminDtoBuilder.aVitaminDto;
import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class VitaminResourceTest {

    private static final VitaminDao vitaminDao = mock(VitaminDao.class);
    private static final VitaminMapper vitaminMapper = mock(VitaminMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new VitaminResource(vitaminDao, vitaminMapper))
            .build();

    @Before
    public void setup() {
        reset(vitaminDao);
        reset(vitaminMapper);

        given(vitaminDao.findAll()).willReturn(asList(aVitamin().build()));
        given(vitaminMapper.toVitaminDtoList(asList())).willReturn(asList(aVitaminDto().build()));
    }

    @Test
    public void findsAll() {
        resources.target("/vitamins").request().get(new GenericType<List<VitaminDto>>() {
        });

        then(vitaminDao).should().findAll();
    }

    @Test
    public void mapsFoundVitaminsToDtoList() {
        List<Vitamin> expected = asList(aVitamin().build());
        given(vitaminDao.findAll()).willReturn(expected);

        resources.target("/vitamins").request().get(new GenericType<List<VitaminDto>>() {
        });

        then(vitaminMapper).should().toVitaminDtoList(expected);

    }

    @Test
    public void returnsFoundVitamins() {
        VitaminDto expected = aVitaminDto().build();
        given(vitaminMapper.toVitaminDtoList(anyList())).willReturn(asList(expected));

        List<VitaminDto> actual = resources.target("/vitamins").request().get(new GenericType<List<VitaminDto>>() {
        });

        assertEqualVitaminDto(actual.get(0), expected);
    }

}