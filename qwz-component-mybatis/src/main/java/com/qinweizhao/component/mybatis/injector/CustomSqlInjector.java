package com.qinweizhao.component.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.List;

/**
 * 默认的注入器，提供属性来注入自定义方法
 *
 * @author lingting 2020/5/27 11:46
 */
public class CustomSqlInjector extends DefaultSqlInjector {

	private final List<AbstractMethod> methods;

	public CustomSqlInjector(List<AbstractMethod> methods) {
		this.methods = methods;
	}

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		List<AbstractMethod> list = super.getMethodList(mapperClass, tableInfo);
		list.addAll(this.methods);
		return list;
	}

}
