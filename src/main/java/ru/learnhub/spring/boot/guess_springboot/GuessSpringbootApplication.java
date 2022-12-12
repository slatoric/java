package ru.learnhub.spring.boot.guess_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ResourceBundle;
import java.util.Scanner;

import static java.util.Locale.US;

@SpringBootApplication
public class GuessSpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GuessSpringbootApplication.class, args);
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");
		game.Game game=(game.Game) context.getBean("game");
//		System.out.println(game.getCode());
//		ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) context.getBean("messageSource");
		ResourceBundle messageSource =ResourceBundle.getBundle("game",US);
//		System.out.println(ResourceBundle.getBundle("game",US).getString("greeting"));
		System.out.println(messageSource.getString(game.getCode()));
		Scanner in=new Scanner(System.in);
		while (game.getCode()!="exact"){
			int num = in.nextInt();
			context.publishEvent(event.EventGame.of("UserEntered",Integer.toString(num)));
//			System.out.println(context.getMessage(game.getCode(), new Object[] {num},null, US));//it doesn't work for some reason
			String mes=messageSource.getString(game.getCode());
			if(game.getCode()=="exact"){
				String replace = mes.replace("{0}", Integer.toString(num));
				System.out.println(replace);
			}
			else{
				System.out.println(mes);
			}

		}
		in.close();
	}

}
