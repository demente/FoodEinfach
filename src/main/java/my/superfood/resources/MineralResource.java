package my.superfood.resources;

import io.dropwizard.hibernate.UnitOfWork;
import my.superfood.dao.MineralDao;
import my.superfood.dto.MineralDto;
import my.superfood.mapper.MineralMapper;
import my.superfood.model.Mineral;
import my.superfood.model.enums.MineralName;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

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