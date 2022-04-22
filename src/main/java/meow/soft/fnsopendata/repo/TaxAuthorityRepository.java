package meow.soft.fnsopendata.repo;

import meow.soft.fnsopendata.model.TaxAuthority;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaxAuthorityRepository extends MongoRepository<TaxAuthority, String> {
    TaxAuthority findByCode(String code);

    List<TaxAuthority> findByCodeIn(List<String> codes);
}
