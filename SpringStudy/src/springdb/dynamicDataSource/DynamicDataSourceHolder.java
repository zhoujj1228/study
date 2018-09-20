package springdb.dynamicDataSource;

public class DynamicDataSourceHolder {

    public static final ThreadLocal<String> currDataSource = new ThreadLocal<>();
    
    public static String getDataSource() {
        return currDataSource.get();
    }
    
    public static void removeDataSource(){
        currDataSource.remove();
    }
    
    public static void setDataSource(String dataSource){
        currDataSource.set(dataSource);
    }
}
