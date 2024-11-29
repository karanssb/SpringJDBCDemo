package com.example.SpringJDBCDemo.repo;

import com.example.SpringJDBCDemo.model.Tabletest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TabletestRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
     @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Tabletest tabletest){
        System.out.println("added");
        String sql = "insert into tabletest (id, name, tech) values (?,?,?)";
        int rows = template.update(sql,tabletest.getId(), tabletest.getName(), tabletest.getTech());
        System.out.println(rows + "rows/s affected" );
      //  template.update(sql,tabletest.getId(), tabletest.getName(), tabletest.getTech());
    }

    public List<Tabletest> findAll(){
 //       return new ArrayList<>();

        String sql = "select * from tabletest";
        return template.query(sql, (rs, rowNum) -> {
            Tabletest tabletest = new Tabletest();
            tabletest.setId(rs.getInt("id"));
            tabletest.setName(rs.getString("name"));
            tabletest.setTech(rs.getString("tech"));
            System.out.println("1:" + tabletest );

            return tabletest;});
/*

            RowMapper<Tabletest> mapper = new RowMapper<Tabletest>() {
           @Override
            public Tabletest mapRow(ResultSet rs,int rowNum) throws SQLException {
               Tabletest a = new Tabletest();
               a.setId(rs.getInt(1));
               a.setName(rs.getString(2));
               a.setTech(rs.getString(3));
               return a;
*/
            }
        };
        /*List <Tabletest> tabletest = template.query(sql,mapper);
     //   return new ArrayList<Tabletest>();
        return tabletest;*/


