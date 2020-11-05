package domain;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Product extends Artikel {

    private LocalDate datumPlaatsing;


    private ProductStatus status;

    @Embedded
    private BezorgOpties bezorgOpties;


}
