package my.superfood.resolver;

import my.superfood.dao.VitaminDao;
import my.superfood.model.Vitamin;
import my.superfood.model.enums.VitaminName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.model.VitaminBuilder.aVitamin;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class VitaminResolverTest {

    private VitaminResolver vitaminResolver;
    @Mock
    private VitaminDao vitaminDao;

    @Before
    public void setup() {
        vitaminResolver = new VitaminResolver(vitaminDao);
    }

    @Test
    public void findsByVitaminName() {
        vitaminResolver.toVitamin(VitaminName.A);

        then(vitaminDao).should().findByName(VitaminName.A);
    }

    @Test
    public void returnsVitaminFoundByName() {
        Vitamin expected = aVitamin().build();
        given(vitaminDao.findByName(any())).willReturn(expected);

        Vitamin actual = vitaminResolver.toVitamin(VitaminName.A);

        assertThat(actual).isEqualTo(expected);
    }

}