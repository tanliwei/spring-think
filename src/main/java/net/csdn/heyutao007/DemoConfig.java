package net.csdn.heyutao007;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DemoService.class)//在spring 4.2之前是不不支持的
public class DemoConfig {

}