### 组件注册
    - 用配置类替换xml文件
    - @ComponentScan
        - 可以同时写多个@ComponentScan，也可写多个@ComponentScan.Filter
        - 过滤有includeFilters、excludeFilters
        - FilterType.ANNOTATION：按注解过滤
        - FilterType.GEGEX：按正则表达式过滤
        - FilterType.CUSTOM：自定义过滤规则