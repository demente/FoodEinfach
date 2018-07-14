package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.MineralDao;
import my.superfood.dto.MineralDto;
import my.superfood.mapper.MineralMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/minerals")
public class MineralResource {

    private final MineralDao mineralDao;
    private final MineralMapper mineralMapper;

    public MineralResource(MineralDao mineralDao, MineralMapper mineralMapper) {
        this.mineralDao = mineralDao;
        this.mineralMapper = mineralMapper;
    }

    @GET
    @UnitOfWork
    public List<MineralDto> findAll() {
        return mineralMapper.toMineralDtoList(mineralDao.findAll());
    }
}