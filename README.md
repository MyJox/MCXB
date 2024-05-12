# MCXB 简介
MCXB是由 My_Jox 开发(个人)的一个Java启动器

-Time 2024年5月12日22点10分

# MCXB 功能
 * 启动Minecraft
 * 下载Minecraft
 * 开发中

暂支持Minecraft 1.20.2版本下载和启动，其他版本暂未测试

# 环境搭建
  语言：JAVA
  
  构建系统：Maven

  JMCCC是由 [@yushijinhun](https://github.com/yushijinhun) 和 [@Darkyoooooo](https://github.com/Darkyoooooo) 开发的Java启动器核心
 * 启动Minecraft
 * 正版验证（以及Yggdrasil的其它API）
 * 下载Minecraft
 * 下载并安装Forge/Liteloader

  JMCCC是开源的（[MIT许可证](https://to2mbn.github.io/jmccc/LICENSE.txt)），JMCCC在GitHub上的项目：[to2mbn/JMCCC](https://github.com/to2mbn/JMCCC)。

``` java
<dependency>
  <groupId>dev.3-3</groupId>
  <artifactId>jmccc-mojang-api</artifactId>
  <version>3.1.4</version>
</dependency>
<dependency>
  <groupId>dev.3-3</groupId>
  <artifactId>jmccc</artifactId>
  <version>3.1.4</version>
</dependency>
<dependency>
  <groupId>org.to2mbn</groupId>
  <artifactId>jmccc-mojang-api</artifactId>
  <version>2.5-beta-1</version>
</dependency>
<dependency>
  <groupId>org.to2mbn</groupId>
  <artifactId>jmccc-mcdownloader</artifactId>
  <version>2.5-beta-1</version>
</dependency>
<dependency>
  <groupId>org.json</groupId>
  <artifactId>json</artifactId>
  <version>20240303</version>
</dependency>
<dependency>
  <groupId>org.tukaani</groupId>
  <artifactId>xz</artifactId>
  <version>1.9</version>
</dependency>
<dependency>
  <groupId>org.apache.logging.log4j</groupId>
  <artifactId>log4j-slf4j-impl</artifactId>
  <version>3.0.0-beta2</version>
</dependency>
<dependency>
  <groupId>taglibs</groupId>
  <artifactId>application</artifactId>
  <version>1.0.1</version>
</dependency>
```
# Dubug
  * 写着玩
