package my.superfood.resolver;

import my.superfood.dao.VitaminDao;
import my.superfood.model.Vitamin;
import my.superfood.model.enums.VitaminName;

public class VitaminResolver {

    private final VitaminDao vitaminDao;

    public VitaminResolver(VitaminDao vitaminDao) {
        this.vitaminDao = vitaminDao;
    }

    public Vitamin toVitamin(VitaminName name) {
        return vitaminDao.findByName(name);
    }
}
