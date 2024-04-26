package ru.practicum.service.request;

import ru.practicum.dto.request.EventRequestStatusUpdateRequest;
import ru.practicum.dto.request.EventRequestStatusUpdateResult;
import ru.practicum.dto.request.ParticipationRequestDto;

import java.util.List;

public interface RequestService {
    ParticipationRequestDto createRequest(Long userId, Long eventId);

    List<ParticipationRequestDto> getRequestsToUserEvent(Long userId, Long eventId);

    EventRequestStatusUpdateResult confirmRequests(Long userId, Long eventId, EventRequestStatusUpdateRequest updateRequest);

    ParticipationRequestDto cancelRequest(Long userId, Long requestId);

    List<ParticipationRequestDto> getUserRequests(Long userId);
}
