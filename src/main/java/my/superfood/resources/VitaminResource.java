package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.VitaminDao;
import my.superfood.dto.VitaminDto;
import my.superfood.mapper.VitaminMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/vitamins")
public class VitaminResource {
    private final VitaminDao vitaminDao;
    private final VitaminMapper vitaminMapper;

    public VitaminResource(VitaminDao vitaminDao, VitaminMapper vitaminMapper) {
        this.vitaminDao = vitaminDao;
        this.vitaminMapper = vitaminMapper;
    }


    @GET
    @UnitOfWork
    public List<VitaminDto> findAll() {
        return vitaminMapper.toVitaminDtoList(vitaminDao.findAll());
    }
}
