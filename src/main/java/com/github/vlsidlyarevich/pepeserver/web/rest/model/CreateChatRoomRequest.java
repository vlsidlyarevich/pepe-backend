package com.github.vlsidlyarevich.pepeserver.web.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * CreateChatRoomRequest
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 2/11/21.
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateChatRoomRequest {

    private String name;
    private List<String> userIds = new ArrayList<>();
}
