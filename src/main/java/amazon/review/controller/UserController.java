package amazon.review.controller;

import amazon.review.model.dto.UserDto;
import amazon.review.model.mapper.UserMapper;
import amazon.review.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final String PAGE_SIZE = "1000";
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/most-active")
    public List<UserDto> getMostActive(
            @RequestParam(defaultValue = PAGE_SIZE) int amount) {
        return userService.getMostActive(amount)
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
