package guru.springframework.msscbrewery.web.mappers;

public interface BaseMapper<Entity, Dto> {
    Dto entityToDto(Entity entity);

    Entity dtoToEntity(Dto dto);
}
