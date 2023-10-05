package restfulapi.controller.advice.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ErrorMessage {
    private final HttpStatus status;
    private final String message;
}
