package my.superfood.resources;


import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.assertions.DtoAssertions;
import my.superfood.dao.MineralDao;
import my.superfood.dto.FoodDto;
import my.superfood.dto.MineralDto;
import my.superfood.mapper.MineralMapper;
import my.superfood.model.Mineral;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.assertions.DtoAssertions.assertEqualMineralDto;
import static my.superfood.dto.MineralDtoBuilder.aMineralDto;
import static my.superfood.model.MineralBuilder.aMineral;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class MineralResourceTest {

    private static final MineralDao mineralDao = mock(MineralDao.class);
    private static final MineralMapper mineralMapper = mock(MineralMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new MineralResource(mineralDao, mineralMapper))
            .build();

    @Before
    public void setup() {
        reset(mineralDao);
        reset(mineralMapper);

        given(mineralDao.findAll()).willReturn(asList(aMineral().build()));
        given(mineralMapper.toMineralDtoList(asList())).willReturn(asList(aMineralDto().build()));
    }

    @Test
    public void findsAll() {
        resources.target("/minerals").request().get(new GenericType<List<MineralDto>>() {
        });

        then(mineralDao).should().findAll();
    }

    @Test
    public void mapsFoundMineralsToDtoList() {
        List<Mineral> expected = asList(aMineral().build());
        given(mineralDao.findAll()).willReturn(expected);

        resources.target("/minerals").request().get(new GenericType<List<MineralDto>>() {
        });

        then(mineralMapper).should().toMineralDtoList(expected);

    }

    @Test
    public void returnsFoundMinerals() {
        MineralDto expected = aMineralDto().build();
        given(mineralMapper.toMineralDtoList(anyList())).willReturn(asList(expected));

        List<MineralDto> actual = resources.target("/minerals").request().get(new GenericType<List<MineralDto>>() {
        });

        assertEqualMineralDto(actual.get(0), expected);
    }
}