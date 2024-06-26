package ru.practicum.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.practicum.model.Event;
import ru.practicum.model.StateAction;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UpdateEventAdminRequest {
    @Size(min = 20, max = 2000, message = "Поле annotation должно содержать от 20 до 2000 символов")
    private String annotation;
    private Long category;
    @Size(min = 20, max = 7000, message = "Поле description должно содержать от 20 до 2000 символов")
    private String description;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;
    private Event.Location location;
    private Boolean paid;
    private Long participantLimit;
    private Boolean requestModeration;
    private StateAction stateAction;
    @Size(min = 3, max = 120, message = "Поле title должно содержать от 3 до 120 символов")
    private String title;
}
