package com.github.vlsidlyarevich.pepeserver.web.rest;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.service.ChatRoomService;
import com.github.vlsidlyarevich.pepeserver.web.rest.annotations.ApiVersion;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.CreateChatRoomRequest;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.CreateChatRoomResponse;
import com.github.vlsidlyarevich.pepeserver.web.rest.model.converter.ChatRoomConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ChatRoomController
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/2/21.
 */
@Slf4j
@ApiVersion
@RestController("/chat/room")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChatRoomController {

    private final ChatRoomService service;

    private final ChatRoomConverter converter;

    @PostMapping
    public ResponseEntity<CreateChatRoomResponse> create(@Valid @RequestBody final CreateChatRoomRequest request) {
        ChatRoom savedRoom = service.create(request.getName(), request.getUserIds());
        var response = converter.toResponse(savedRoom);
        return ResponseEntity.ok(response);
    }
}
