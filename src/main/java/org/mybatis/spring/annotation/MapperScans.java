/*
 * Copyright 2010-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mybatis.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 聚合多个MapperScan注释的注解
 * 可以原生使用，声明几个嵌套的MapperScan注解。还可以与Java 8对可重复注解的支持结合使用，其中MapperScan可以简单地在同一个方法上声明几次，隐式地生成这个注注解
 *
 * The Container annotation that aggregates several {@link MapperScan} annotations.
 *
 * <p>
 * Can be used natively, declaring several nested {@link MapperScan} annotations. Can also be used in conjunction with
 * Java 8's support for repeatable annotations, where {@link MapperScan} can simply be declared several times on the
 * same method, implicitly generating this container annotation.
 *
 * @author Kazuki Shimizu
 * @since 2.0.0
 * @see MapperScan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MapperScannerRegistrar.RepeatingRegistrar.class)
public @interface MapperScans {
  MapperScan[] value();
}
