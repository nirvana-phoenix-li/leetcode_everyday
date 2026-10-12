package entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class MyTest {
    private LocalDateTime time;
    private String esKey;
    private Map<String,Object> data;
}
