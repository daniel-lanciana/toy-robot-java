package com.rea;

import com.rea.service.RobotAdapter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    /*
                    ___
                   /\  \
      ___         /::\  \         ___
     /\__\       /:/\:\  \       /|  |
    /:/  /      /:/  \:\  \     |:|  |
   /:/__/      /:/__/ \:\__\    |:|  |
  /::\  \      \:\  \ /:/  /  __|:|__|
 /:/\:\  \      \:\  /:/  /  /::::\  \
 \/__\:\  \      \:\/:/  /   ~~~~\:\  \
      \:\__\      \::/  /         \:\__\
       \/__/       \/__/           \/__/
      ___           ___                         ___
     /\  \         /\  \         _____         /\  \
    /::\  \       /::\  \       /::\  \       /::\  \         ___
   /:/\:\__\     /:/\:\  \     /:/\:\  \     /:/\:\  \       /\__\
  /:/ /:/  /    /:/  \:\  \   /:/ /::\__\   /:/  \:\  \     /:/  /
 /:/_/:/__/___ /:/__/ \:\__\ /:/_/:/\:|__| /:/__/ \:\__\   /:/__/
 \:\/:::::/  / \:\  \ /:/  / \:\/:/ /:/  / \:\  \ /:/  /  /::\  \
  \::/~~/~~~~   \:\  /:/  /   \::/_/:/  /   \:\  /:/  /  /:/\:\  \
   \:\~~\        \:\/:/  /     \:\/:/  /     \:\/:/  /   \/__\:\  \
    \:\__\        \::/  /       \::/  /       \::/  /         \:\__\
     \/__/         \/__/         \/__/         \/__/           \/__/
                    ___           ___           ___
     _____         /\__\         /\  \         /\  \
    /::\  \       /:/ _/_       |::\  \       /::\  \
   /:/\:\  \     /:/ /\__\      |:|:\  \     /:/\:\  \
  /:/  \:\__\   /:/ /:/ _/_   __|:|\:\  \   /:/  \:\  \
 /:/__/ \:|__| /:/_/:/ /\__\ /::::|_\:\__\ /:/__/ \:\__\
 \:\  \ /:/  / \:\/:/ /:/  / \:\~~\  \/__/ \:\  \ /:/  /
  \:\  /:/  /   \::/_/:/  /   \:\  \        \:\  /:/  /
   \:\/:/  /     \:\/:/  /     \:\  \        \:\/:/  /
    \::/  /       \::/  /       \:\__\        \::/  /
     \/__/         \/__/         \/__/         \/__/

*/

    /**
     * Command-line Java program main method. Passes input to the adapter, quits on the word EXIT.
     *
     * @param args
     */
    public static void main(String[] args) {
        RobotAdapter adapter = new RobotAdapter();
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("To quit type EXIT");

        do {
            input = sc.nextLine();
            // Output response from the adapter (e.g. REPORT)
            System.out.println(adapter.input(input));
        }
        while (!"exit".equalsIgnoreCase(input));

        // Uncomment this line to run as a web application via Spring Boot
        //SpringApplication.run(Application.class, args);
    }
}