package com.scaler.splitwise;

import com.scaler.splitwise.Commands.CommandExecutor;
import com.scaler.splitwise.Commands.CreateUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

    private CommandExecutor commandExecutor;
    private Scanner scanner;


    public  SplitWiseApplication(CommandExecutor commandExecutor)
    {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        //this.commandExecutor.addCommand(new CreateUserCommand());
    }


    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception //takes an array of strings as input
    {
        while(true)
        {
            System.out.println("Enter input");
            String input = scanner.nextLine();
            System.out.println("user entered" + input);

            commandExecutor.execute(input);
        }
    }

}
