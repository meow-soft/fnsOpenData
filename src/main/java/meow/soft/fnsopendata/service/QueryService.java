package meow.soft.fnsopendata.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import meow.soft.fnsopendata.model.TaxAuthority;
import meow.soft.fnsopendata.repo.TaxAuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryService implements GraphQLQueryResolver {

    private final TaxAuthorityRepository repository;

    public List<TaxAuthority> list() {
        return repository.findAll();
    }

    public TaxAuthority tnoByCode(String code) {
        return repository.findByCode(code);
    }

    public List<TaxAuthority> tnoByCodes(List<String> codes) {
        return repository.findByCodeIn(codes);
    }
}
