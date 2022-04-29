package restful.phase1.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private List<String> coursesTaken;
}
