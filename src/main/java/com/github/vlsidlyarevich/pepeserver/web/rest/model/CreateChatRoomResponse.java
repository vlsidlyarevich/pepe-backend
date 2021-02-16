package com.github.vlsidlyarevich.pepeserver.web.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CreateChatRoomResponse
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/11/21.
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateChatRoomResponse {

    private String id;
    private String name;
    private LocalDateTime createdAt;
    private List<String> userIds;
}
