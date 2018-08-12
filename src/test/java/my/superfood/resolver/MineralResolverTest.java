package my.superfood.resolver;

import my.superfood.dao.MineralDao;
import my.superfood.model.Mineral;
import my.superfood.model.enums.MineralName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static my.superfood.model.MineralBuilder.aMineral;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MineralResolverTest {

    private MineralResolver mineralResolver;
    @Mock
    private MineralDao mineralDao;

    @Before
    public void setup() {
        mineralResolver = new MineralResolver(mineralDao);
    }

    @Test
    public void findsByMineralName() {
        mineralResolver.toMineral(MineralName.Ca);

        then(mineralDao).should().findByName(MineralName.Ca);
    }

    @Test
    public void returnsMineralFoundByName() {
        Mineral expected = aMineral().build();
        given(mineralDao.findByName(any())).willReturn(expected);

        Mineral actual = mineralResolver.toMineral(MineralName.Ca);

        assertThat(actual).isEqualTo(expected);
    }
}