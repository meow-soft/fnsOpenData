package meow.soft.fnsopendata.interfaces;

import meow.soft.fnsopendata.dto.TaxAuthorityDto;
import meow.soft.fnsopendata.model.TaxAuthority;

public interface ITaxAuthorityService {
    void saveOrUpdate(TaxAuthority taxAuthority);

    TaxAuthorityDto findByCode(String code);
}
