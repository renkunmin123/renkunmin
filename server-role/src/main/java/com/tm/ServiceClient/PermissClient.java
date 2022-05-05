package com.tm.ServiceClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("server-permiss")
public interface PermissClient {

    @PostMapping("deleteAll")
    void deleteAll(@RequestBody List<Integer> ids);

}
