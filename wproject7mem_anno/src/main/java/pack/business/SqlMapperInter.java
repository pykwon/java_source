package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInter {
	//MyBatis annotation 사용
	
	@Select("select * from memberteb")
	public List<DataDto> selectDataAll();
	
	@Select("select id,name,passwd,reg_date from memberteb where id=#{id}")
	public DataDto selectDataPart(String id);
	
	@Insert("insert into memberteb values(#{id},#{name},#{passwd},now())")
	public int insertData(DataFormBean form);
	
	@Update("update memberteb set name=#{name} where id=#{id}")
	public int updateData(DataFormBean form);
	
	@Delete("delete from memberteb where id=#{id}")
	public int deleteData(String id);
}
