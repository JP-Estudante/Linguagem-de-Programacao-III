package mercadofx;

import DAO.CategoriaDAO;
import javafx.util.Callback;

public class DinheiroControllerFactory implements Callback<Class<?>, Object> {

    private CategoriaDAO categoriaDAO;

    public DinheiroControllerFactory(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public Object call(Class<?> type) {
        try {
            // Procura um construtor que aceite um CategoriaDAO como parâmetro
            return type.getConstructor(CategoriaDAO.class).newInstance(categoriaDAO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
