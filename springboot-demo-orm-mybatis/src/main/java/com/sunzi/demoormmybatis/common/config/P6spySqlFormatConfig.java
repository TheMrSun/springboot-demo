package com.sunzi.demoormmybatis.common.config;


import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import com.sunzi.demoormmybatis.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * 自定义 p6spy sql输出格式配置类
 *
 * @author Coder
 */
public class P6spySqlFormatConfig implements MessageFormattingStrategy {

	/**
	 * 过滤掉定时任务的 SQL
	 */
	@Override
	public String formatMessage(int connectionId, String now, long eltrped, String category, String prepared,
			String sql, String url) {
		return 
		StringUtils.isNotBlank(sql)
		? new StringBuilder(DateUtil.formatFullTime(LocalDateTime.now(), DateUtil.FULL_TIME_SPLIT_PATTERN))
		.append(" | 耗时 ").append(eltrped).append(" ms | SQL 语句：").append(StringUtils.LF).append(sql.replaceAll("[\\s]+", StringUtils.SPACE)).append(";").toString()
		: "";
	}
}
