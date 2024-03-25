package study.kyh.principle3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import study.kyh.principle3.config.AppV1Config;
import study.kyh.principle3.config.AppV2Config;

@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "study.kyh.principle3.app.v3")
public class Principle3Application {

    public static void main(String[] args) {
        SpringApplication.run(Principle3Application.class, args);
    }

}
