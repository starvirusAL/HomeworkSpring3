package app.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class MapperFacade<E, D> {
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    private final ModelMapper modelMapper = new ModelMapper();

    public MapperFacade(final Class<E> eClass, final Class<D> dClass) {
        entityClass = eClass;
        dtoClass = dClass;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public D convertToDto(final E entity) {
        final D dto = modelMapper.map(entity, dtoClass);
        decorateDto(dto, entity);
        return dto;
    }
    protected void decorateDto(final D dto, final E entity) {
    }
}
