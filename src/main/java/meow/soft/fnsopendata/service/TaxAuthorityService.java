package meow.soft.fnsopendata.service;

import lombok.RequiredArgsConstructor;
import meow.soft.fnsopendata.dto.TaxAuthorityDto;
import meow.soft.fnsopendata.interfaces.ITaxAuthorityService;
import meow.soft.fnsopendata.mapper.TaxAuthorityMapper;
import meow.soft.fnsopendata.model.TaxAuthority;
import meow.soft.fnsopendata.repo.TaxAuthorityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxAuthorityService implements ITaxAuthorityService {

    private final TaxAuthorityRepository repository;
    private final TaxAuthorityMapper mapper;

    @Override
    public void saveOrUpdate(TaxAuthority taxAuthority) {
        repository.save(taxAuthority);
    }

    @Override
    public TaxAuthorityDto findByCode(String code) {
        TaxAuthority byCode = repository.findByCode(code);
        return mapper.toDto(byCode);
    }
}
