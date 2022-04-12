package meow.soft.fnsopendata.mapper;


import meow.soft.fnsopendata.dto.TaxAuthorityDto;
import meow.soft.fnsopendata.model.TaxAuthority;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TaxAuthorityMapper {
    TaxAuthorityDto toDto(TaxAuthority taxAuthority);
}
