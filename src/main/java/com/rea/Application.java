package com.rea;

import com.rea.service.RobotAdapter;
import org.springframework.boot.SpringApplication;
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

    public static void main(String[] args) {
        RobotAdapter adapter = new RobotAdapter();
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("To quit type EXIT");

        do {
            input = sc.nextLine();
            System.out.println(adapter.input(input));
        }
        while (!"exit".equalsIgnoreCase(input));

        //SpringApplication.run(Application.class, args);
    }
}