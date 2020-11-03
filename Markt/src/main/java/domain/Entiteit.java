package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entiteit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
}
