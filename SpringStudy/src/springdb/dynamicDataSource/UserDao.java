package springdb.dynamicDataSource;

import org.springframework.stereotype.Repository;


public interface UserDao {
    public void find();
    public void insert();
    public void update();
    public void delete();
}
