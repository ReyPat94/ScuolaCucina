package dao;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Categoria;
import entity.Corso;
import entity.Feedback;

public interface CatalogoDAO extends Closeable{

	void insert(Corso corso) throws SQLException;
	void update(Corso corso) throws SQLException;
	void delete(int idCorso) throws SQLException;
	ArrayList<Corso> select() throws SQLException;
	Corso select(int idCorso) throws SQLException;

}