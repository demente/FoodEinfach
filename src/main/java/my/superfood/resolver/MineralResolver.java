package my.superfood.resolver;

import my.superfood.dao.MineralDao;
import my.superfood.model.Mineral;
import my.superfood.model.enums.MineralName;

public class MineralResolver {

    private final MineralDao mineralDao;

    public MineralResolver(MineralDao mineralDao) {
        this.mineralDao = mineralDao;
    }

    public Mineral toMineral(MineralName mineralName) {
        return mineralDao.findByName(mineralName);
    }
}
