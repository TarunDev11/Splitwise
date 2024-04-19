package com.scaler.splitwise.Commands;

import com.scaler.splitwise.Controller.UserController;
import com.scaler.splitwise.Dtos.CreateUserRequest;
import com.scaler.splitwise.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@AllArgsConstructor
@Builder
//Step 2 - Create the concrete command classes
public class CreateUserCommand implements Command{

    private UserController userController;


    @Override
    public boolean matches(String input)
    {
//        input.split(" "): This splits the string stored in the variable input into an array of substrings based on the space character " ". For example, if input is "Hello World", this will produce an array ["Hello", "World"].
//        Arrays.stream(...): This creates a stream of elements from the array produced by the split method.
//        toList(): This converts the stream of elements into a List. Specifically, it creates an immutable List containing the elements of the stream. This is done using the Collectors.toList() collector from the java.util.stream.Collectors class.

        List<String> tokens = Arrays.stream(input.split(" ")).toList();
        String command = tokens.get(0);
        if(!command.equals(Commands.REGISTER_USER_COMMAND))
        {
            return false;
        }

        if(tokens.size() <  5)
        {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input)
    {
        System.out.println("Executing create user command");
        List<String> tokens = Arrays.stream(input.split(" ")).toList();
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phone(tokens.get(4))
                .build();
        User user = userController.createUser(createUserRequest);
        System.out.println("Created user with id" + user.getId());
    }


}
