package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.HitDto;
import ru.practicum.dto.StatsDto;
import ru.practicum.exception.BadRequestException;
import ru.practicum.service.StatsService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
@Validated
@RequiredArgsConstructor
public class StatsController {
    private final StatsService service;
    private final DateTimeFormatter dateTimeFormatter;

    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody HitDto hitDto) {
        log.info("Контроллер: получен POST метод запроса по эндпоинту /hit с {}", hitDto);
        service.save(hitDto);
    }

    @GetMapping("/stats")
    @ResponseStatus(HttpStatus.OK)
    public List<StatsDto> getStats(
            @RequestParam(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
            @RequestParam(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
            @RequestParam(value = "uris", required = false) List<String> uris,
            @RequestParam(value = "unique", defaultValue = "false") Boolean unique) {
        log.info("Контроллер: получен GET метод запроса по эндпоинту /stats c start = {}, end = {}, uris = {}, unique = {}",
                start, end, uris, unique
        );
        if (end.isBefore(start)) {
            throw new BadRequestException("Указаны некорректные значения для даты/времени");
        }
        return service.findStatistics(start, end, uris, unique);
    }
}
