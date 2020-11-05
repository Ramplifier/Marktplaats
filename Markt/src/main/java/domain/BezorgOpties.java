package domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class BezorgOpties {
    private boolean afhalen;
    private boolean magazijn;
    private boolean rembours;
    private boolean versturen;
}
