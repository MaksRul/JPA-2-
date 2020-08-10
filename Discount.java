import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
@DiscriminatorColumn(name = "true")
public class Discount extends Menu{
@Column(name = "%" )
    private String interest;

    public Discount() {
    }

    public Discount(String nameDish, Integer cost, Integer weight, String interest) {
        super(nameDish, cost, weight);
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Discount{" + "name dish=" + getNameDish()+
                "interest='" + interest + '\'' +
                '}'
                 ;
    }
}
