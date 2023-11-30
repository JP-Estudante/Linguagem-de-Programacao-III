package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;

    public static Categoria fromResultSet(ResultSet resultSet) throws SQLException {
        return new Categoria(
                resultSet.getInt("id_categoria"),
                resultSet.getString("nome_categoria"));
    }

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public String toString() {
        return " Categoria {" +
                "idCategoria=" + idCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                "} ";
    }

}
