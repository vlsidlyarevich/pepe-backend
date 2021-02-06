package com.github.vlsidlyarevich.pepeserver.web.rest;

import com.github.vlsidlyarevich.pepeserver.room.service.ChatRoomService;
import com.github.vlsidlyarevich.pepeserver.web.rest.annotations.ApiVersion;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private ChatRoomService service;

    @PostMapping
    public ResponseEntity create() {
        return ResponseEntity.ok().build();
    }
}
