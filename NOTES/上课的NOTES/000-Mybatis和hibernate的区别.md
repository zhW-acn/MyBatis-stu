| Mybatis          | hibernate          |
|------------------|--------------------|
| 半自动              | 全自动                |
| 数据库表自建 【没有关联类和表】 | 建库无需建表【只要类变了，表自动变】 |
| 轻量，适用中小型项目       | 重量，适用中大型项目         |
| 原生SQL            | 自带接口，支持HQL和SQL     |


sqlSessionFactory是二级缓存，默认关闭缓存。一旦创建，除非项目关闭否则不能将他销毁。
sqlSession一级缓存，默认开启缓存。开启事务。autocommit=false