# configuration
mybatis约束文件的根标签

## properties
resource：指定连接池配置文件位置

## typeAliases
子标签的typeAlias用于给全限定类名起别名。简化冗余
> typeAlias type=全限定类名 alias=别名

## environments
配置多个环境
> default：用于指定当前环境用哪个environment的id

### environment
在这里配置环境信息 

id属性用于命名当前环境，以便指定

> transactionManager 事务管理器。type=当前事务管理类型

> datasource 数据连接池信息。type=当前连接池类型
> property 配置文件信息。name指定properties文件的K，value指定V。用${}占位


## mappers
注册mapper文件
> mapper