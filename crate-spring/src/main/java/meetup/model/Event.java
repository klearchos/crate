package meetup.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Event {

    private String id;

    @NotEmpty
    private String sensorName;

    @NotNull
    private Float sensorTempValue;

    @NotNull
    private Float sensorHumidityValue;

    private Date created;
}
