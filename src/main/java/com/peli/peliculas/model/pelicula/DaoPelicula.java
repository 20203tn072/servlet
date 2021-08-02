package com.peli.peliculas.model.pelicula;

import com.peli.peliculas.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPelicula {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoPelicula.class);

    public List<BeanPelicula> findAll(){
        List<BeanPelicula> listPeliculas = new ArrayList<>();
        try {
            // SELECT * FROM peliculas;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanPelicula pelicula = new BeanPelicula();


                pelicula.setId(rs.getLong("idPelicula"));
                pelicula.setNombre(rs.getString("nombre"));
                pelicula.setDescripcion(rs.getString("descricion"));
                pelicula.setEstreno(rs.getString("estreno"));
                pelicula.setRecaudacion(rs.getInt("recaudacion"));
                pelicula.setStatus(rs.getInt("status"));


                listPeliculas.add(pelicula);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listPeliculas;
    }

    public BeanPelicula findById(long id){
        BeanPelicula pelicula = null;
        try {
            // SELECT * FROM peliculas;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM pelicula");
            rs = cstm.executeQuery();

            if(rs.next()){
                pelicula = new BeanPelicula();

                pelicula.setId(rs.getLong("idPelicula"));
                pelicula.setNombre(rs.getString("nombre"));
                pelicula.setDescripcion(rs.getString("descricion"));
                pelicula.setEstreno(rs.getString("estreno"));
                pelicula.setRecaudacion(rs.getInt("recaudacion"));
                pelicula.setStatus(rs.getInt("status"));

            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return pelicula;
    }

    public boolean create(BeanPelicula pelicula){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?,?,?)}");
            cstm.setString(1, pelicula.getNombre());
            cstm.setString(2, pelicula.getDescripcion());
            cstm.setString(3, pelicula.getEstreno());
            cstm.setInt(4, pelicula.getRecaudacion());
            cstm.setInt(5, pelicula.getStatus());
            cstm.setInt(6, (int) pelicula.getId());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanPelicula pelicula){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?)}");
            cstm.setString(1, pelicula.getNombre());
            cstm.setString(2, pelicula.getDescripcion());
            cstm.setString(3, pelicula.getEstreno());
            cstm.setInt(4, pelicula.getRecaudacion());
            cstm.setInt(5, pelicula.getStatus());
            cstm.setInt(6, (int) pelicula.getId());

            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(long idpelicula){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete2(?)}");
            cstm.setLong(1, idpelicula);

            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}
