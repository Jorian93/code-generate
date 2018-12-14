package cn.jorian.handle;
import cn.jorian.handle.configure.*;

/**
 * 项目启动
 */
public class StartRun{
    private OpenConfigure openConfigure=null;
    private PackageNameConfigure packageNameConfigure=null;
    private JdbcConfigure jdbcConfigure=null;
    public StartRun(){
        openConfigure=OpenConfigure.getInstance();
        packageNameConfigure=PackageNameConfigure.getInstance();
        jdbcConfigure=JdbcConfigure.getInstance();
    }

    /**
     * 开始导入
     *  位于项目根路径下
     */
    public void run() {
        if(openConfigure.isScan()){
            System.out.println("启动自动导入");
            AutoMaticApp.getInstance().startScan();
        }else {
            System.out.println("未启动自动导入");
        }
    }

    /**
     * 设置开启的功能
     * @return
     */
    public OpenConfigure setOpen(){
        return openConfigure;
    }

    /**
     * 自定义java数据类型与sql数据类型对应关系
     * 提供常见数据类型对应
     * @param javaType
     * @param sqlType
     * @return
     */
    public StartRun setTypeJavaToSql(String javaType,String sqlType){
        VarTypeConfigure.TYPEMAP.put(javaType,sqlType);
        return this;
    }

    /**
     * 设置各个层次的包名与项目到包的路径 如/src/main/java/
     * 所有层次都有默认名称
     * @return
     */
    public PackageNameConfigure setPageName(){
        return packageNameConfigure;
    }

    /**
     * 设置dao service serviceImp阶段的方法名称格式
     * @param i  用MethodNameConfigure中的常量定义
     * @param format -用{}代替实体类类名
     *
     * @return
     */
    public StartRun setMethodFormat(Integer i,String format){
        MethodNameConfigure.MethodType.put(i,format);
        return this;
    }

    /**
     * 设置类名格式
     * @param i 使用ClassNameConfigure里面的常量
     * @param format 参照 I{}Service.java
     *           -用{}代替实体类类名
     * @return
     */
    public StartRun setClassFormat(Integer i,String format){
        ClassNameConfigure.className.put(i,format);
        return this;
    }

    public void setRootPath(String path){
        AutoMaticApp.codePath=path;
    }

    /**
     * 设置数据库连接参数
     * @return
     */
    public JdbcConfigure setJdbcField(){
        return jdbcConfigure;
    }
public void xiha(){
        try{
            throw new RuntimeException("");
        }catch (RuntimeException e){

        }
}

    public static void main(String[] args) {
        StartRun start=new StartRun();
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
        //注意，并非是指当前项目的根目录！而是目标类所在项目的根目录！
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






    }

}
