package com.qlvk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.qlvk.common.tag.BaseTag;

@SpringBootApplication
@EnableScheduling
public class SeinoSpringApplication extends SpringBootServletInitializer {
	//@Autowired
	//JobLauncher jobLauncher;

	//@Autowired
	//Job job;


	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SeinoSpringApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SeinoSpringApplication.class, args);
    }
	@Bean(name = "baseTag")
	public BaseTag baseTag() {
		return new BaseTag();
	}

	//@Scheduled(cron = "0 */1 * * * ?")
	//public void perform() throws Exception {
	//	JobParameters params = new JobParametersBuilder()
	//			.addString("TaskDaily", String.valueOf(System.currentTimeMillis())).toJobParameters();
	//	jobLauncher.run(job, params);
	//}
}