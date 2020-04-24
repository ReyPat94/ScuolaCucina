package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Categoria;
import entity.Corso;
import entity.Feedback;
import exceptions.ConnessioneException;

public class CatalogoDAOImpl implements CatalogoDAO {

	private Connection conn;

	public CatalogoDAOImpl() throws ConnessioneException {
		conn = SingletonConnection.getInstance();
	}

	/*
	 * registrazione di un nuovo corso nel catalogo dei corsi
	 */
	@Override
	public void insert(Corso corso) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"INSERT into catalogo(id_corso, titolo, id_categoria, numeroMaxPartecipanti, costo, descrizione) values( ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, corso.getCodice());
		stmt.setString(2, corso.getTitolo());
		stmt.setInt(3, corso.getIdCategoria());
		stmt.setInt(4, corso.getMaxPartecipanti());
		stmt.setDouble(5, corso.getCosto());
		stmt.setString(6, corso.getDescrizione());
		stmt.executeUpdate();
	}

	/*
	 * modifica di tutti i dati di un corso nel catalogo dei corsi il corso viene
	 * individuato in base al idCorso se il corso non esiste si solleva una
	 * eccezione
	 */
	@Override
	public void update(Corso corso) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"UPDATE into catalogo(titolo, id_categoria, numeroMaxPartecipanti, costo, descrizione) values( ?, ?, ?, ?, ?) WHERE id_corso = ?");
		ArrayList<Corso> allcourses = select();   //select to implement
		if (allcourses.contains(corso)) {
			stmt.setInt(6, corso.getCodice());
			stmt.setString(1, corso.getTitolo());
			stmt.setInt(2, corso.getIdCategoria());
			stmt.setInt(3, corso.getMaxPartecipanti());
			stmt.setDouble(4, corso.getCosto());
			stmt.setString(5, corso.getDescrizione());
		} else {
			throw new IllegalArgumentException("Il corso che vuoi UPDATE non esiste.");
		}
	}
	/*
	 * cancellazione di un nuovo corso nel catalogo dei corsi 
	 * questo potr� essere cancellato solo se non vi sono edizioni di quel corso o qualsiasi altro
	 * legame con gli altri dati.
	 * Se il corso non esiste si solleva una eccezione 
	 * Se non � cancellabile si solleva una eccezione
	 */
	@Override
	public void delete(int idCorso) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE from catalogo WHERE id_corso = ?");
		
		
	}

	/*
	 * lettura di tutti i corsi dal catalogo se non ci sono corsi nel catalogo il
	 * metodo torna una lista vuota
	 */
	@Override
	public ArrayList<Corso> select() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * lettura di un singolo corso dal catalogo dei corsi se il corso non � presente
	 * si solleva una eccezione
	 */
	@Override
	public Corso select(int idCorso) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
