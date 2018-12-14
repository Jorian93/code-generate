# code-generate
|--根据POJO类自动生成数据库表   
|--根据POJO类自动生成Dao接口  
|--根据POJO类自动生成Service接口  
|--根据POJO类自动生成Serice接口实现类  
|--根据POJO类自动生成Mapper.xml文件


使用方法：
|--1.clone项目到本地，使用任意IDE打开
|--2.按需配置项目相关参数
     |--  配置方式：打开工程下的主程序：startRun.java，按照详细注释进行配置，所有配置都在此处进行
|--3.启动主程序，自动生成各类文件
|--4.一些问题：
  |--Q:找不到目标类，找不到目标类所在的包   A:仔细按照注释检查目标类的磁盘路径
  |--Q:默认是mysql，能否生成oracle，sqlserver等数据库类型的表  A:可以生成mysql后，自行用navicat等工具传输到oracle等库
  |--Q:表或者字段大小写不一致     A:将上一步oracle表导出成sql脚本，用notepad++ 打开，全选 crl+shift+u  全文转换为大写，重新导入。
 
|--附部分配置内容 ：    

        start.setOpen()  //进入工具包设置
                .setScan(true)		//是否开启扫描 该扫描是扫描实体类包
               // .setMapper(true)	//是否开启生成mybatis xml文件
               // .setDao(true)		//是否生成数据库操作接口
               // .setService(true)	//是否生成service的接口
               // .setServiceImp(true)//是否生成service的实现类  与是否生成接口没有关联
                .setThreadPool(10)	//设置线程池大小  默认为10
                .setPrimaryKeyUUID(true) // 是否设置主键为uuid 若开启 则插入操作会设置主键值为uuid
                .setCreateTab(true);//是否创建数据库表  若需要实现该功能需要设置数据库属性与数据库连接池等       
        start.setRootPath("E:\\workspace-git\\code-generate");
       // rootpath是指目标类所在的项目根目录
        //注意，并非是指当前项目的根目录！而是目标类所在项目的根目录！ 目标类在任意磁盘路径下都可以
        //例如，目标类person.java在当前项目E:\workspace-git\code-generate\src\main\java\cn.jorian.handle.beans下
        //rootpath填写：E:\workspace-git\code-generate


        start.setPageName()		 // 进入包名的设置
                .setRootPackage("cn.jorian.handle.")  //设置目标类 所在包的父包 没有为空 注意注意最后要有一个点
                .setBeans("beans")		// 设置目标类所在的包名 所有生成代码都根据该包下的实体类生成该属性值如果有.则表明只添加实体包下的一个类不支持子包
                                     //注意
                                     //如果只需要生产一个实体类的代码 这设置为beans.BeanName（实体类名）
		       // .setMapper("")// 该设置为mybatis xml的生成位置 如果为maven项目建议不设置该属性 注意是不设置，不是设置为空
               // .setMiddleMapp("")	// maven建议不用设置，没使用maven建议设置为"src/"
               // .setMiddle("")		//  maven建议不用设置，没使用maven建议设置为"src/"
                .setDao("dao")			// 设置dao接口的父包
                .setService("service")		// 设置service接口父包
                .setServiceImp("service.imp");	//设置service实现类父包

        start.setJdbcField()
                .setConcurrencyPool(5)   //设置数据库连接池
                .setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8")  //url
                .setUser("root")		//用户名
                .setPassword("root");		//密码
        start.setTypeJavaToSql("String","varchar") //前面为java数据类型后面为mysql数据类型
                ;


        start.run();



