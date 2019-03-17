package com.restart.spmaster;

import com.restart.spmaster.common.CommonMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableCaching
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true) // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = "com.restart.spmaster.mapper", markerInterface = CommonMapper.class)
public class SpMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpMasterApplication.class, args);
	}

}
