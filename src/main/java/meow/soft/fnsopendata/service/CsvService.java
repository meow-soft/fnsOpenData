package meow.soft.fnsopendata.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import meow.soft.fnsopendata.interfaces.ICsvService;
import meow.soft.fnsopendata.interfaces.ITaxAuthorityService;
import meow.soft.fnsopendata.model.TaxAuthority;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CsvService implements ICsvService {

    private final ITaxAuthorityService taxAuthorityService;

    @Override
    public void readFromFile(String filePath) {
        taxAuthorityService.clearRecords();

        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
        CsvMapper csvMapper = new CsvMapper();

        try {
            MappingIterator<TaxAuthority> values = csvMapper.readerFor(TaxAuthority.class)
                    .with(csvSchema)
                    .readValues(new File(filePath));
            for (TaxAuthority taxAuthority : values.readAll()) {
                taxAuthorityService.saveOrUpdate(taxAuthority);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
