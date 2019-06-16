package my.superMealPlan.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import my.superfood.dao.MealPlanDao;
import my.superfood.dto.MealPlanDto;
import my.superfood.mapper.MealPlanMapper;
import my.superfood.model.MealPlan;
import my.superfood.resources.MealPlanResource;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.Arrays.asList;
import static my.superfood.assertions.DtoAssertions.assertEqualMealPlanDto;
import static my.superfood.dto.MealPlanDtoBuilder.aMealPlanDto;
import static my.superfood.model.MealPlanBuilder.aMealPlan;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class MealPlanResourceTest {

    private static final MealPlanDao mealPlanDao = mock(MealPlanDao.class);
    private static final MealPlanMapper mealPlanMapper = mock(MealPlanMapper.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new MealPlanResource(mealPlanDao, mealPlanMapper))
            .build();

    @Before
    public void setup() {
        reset(mealPlanDao);
        reset(mealPlanMapper);

        given(mealPlanDao.save(any(MealPlan.class))).willReturn(aMealPlan().build());
        given(mealPlanMapper.toMealPlan(any(MealPlanDto.class))).willReturn(aMealPlan().build());
    }

    @Test
    public void findsById() {
        resources.target("/mealplans/1").request().get(MealPlanDto.class);

        then(mealPlanDao).should().findById(1L);
    }

    @Test
    public void mapsFoundMealPlanToDto() {
        MealPlan expected = aMealPlan().build();
        given(mealPlanDao.findById(anyLong())).willReturn(expected);

        resources.target("/mealplans/1").request().get(MealPlanDto.class);

        then(mealPlanMapper).should().toMealPlanDto(expected);
    }

    @Test
    public void returnsMappedMealPlanDto() {
        MealPlanDto expected = aMealPlanDto().build();
        given(mealPlanMapper.toMealPlanDto(any())).willReturn(expected);

        MealPlanDto actual = resources.target("/mealplans/1").request().get(MealPlanDto.class);

        assertEqualMealPlanDto(expected, actual);
    }

    @Test
    public void savesMealPlan() {
        MealPlan expected = aMealPlan().build();
        given(mealPlanMapper.toMealPlan(any(MealPlanDto.class))).willReturn(expected);
        given(mealPlanDao.save(any(MealPlan.class))).willReturn(expected);

        resources.target("/mealplans").request().post(Entity.json(aMealPlanDto().build()));

        then(mealPlanDao).should().save(expected);
    }

    @Test
    public void mapsMealPlanDtoToMealPlan() {
        MealPlanDto expected = aMealPlanDto().build();
        resources.target("/mealplans").request().post(Entity.json(expected));

        ArgumentCaptor<MealPlanDto> mealPlanDtoArgumentCaptor = ArgumentCaptor.forClass(MealPlanDto.class);

        then(mealPlanMapper).should().toMealPlan(mealPlanDtoArgumentCaptor.capture());

        assertEqualMealPlanDto(mealPlanDtoArgumentCaptor.getValue(), expected);
    }

    @Test
    public void returnsIdOfPersistedMealPlan() {
        Long expectedId = 4L;
        given(mealPlanDao.save(any(MealPlan.class))).willReturn(aMealPlan().withId(expectedId).build());

        Response response = resources.target("/mealplans").request().post(Entity.json(aMealPlanDto().build()));
        assertThat(response.readEntity(Long.class)).isEqualTo(expectedId);
    }

    @Test
    public void deletesMealPlan() {
        resources.target("/mealplans/1").request().delete();

        then(mealPlanDao).should().delete(1L);
    }

    @Test
    public void findsAll() {
        resources.target("/mealplans").request().get(new GenericType<List<MealPlanDto>>() {
        });

        then(mealPlanDao).should().findAll();
    }

    @Test
    public void mapsFoundMealPlansToDtoList() {
        List<MealPlan> expected = asList(aMealPlan().build());
        given(mealPlanDao.findAll()).willReturn(expected);

        resources.target("/mealplans").request().get(new GenericType<List<MealPlanDto>>() {
        });

        then(mealPlanMapper).should().toMealPlanDtoList(expected);

    }

    @Test
    public void returnsFoundMealPlans() {
        MealPlanDto expected = aMealPlanDto().build();
        given(mealPlanMapper.toMealPlanDtoList(anyList())).willReturn(asList(expected));

        List<MealPlanDto> actual = resources.target("/mealplans").request().get(new GenericType<List<MealPlanDto>>() {
        });

        assertEqualMealPlanDto(actual.get(0), expected);
    }

}