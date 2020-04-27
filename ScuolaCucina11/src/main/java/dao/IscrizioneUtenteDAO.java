package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Edizione;
import entity.Utente;

public interface IscrizioneUtenteDAO {

	void iscriviUtente(int idEdizione, String idUtente) throws SQLException;
	void cancellaIscrizioneUtente(int idEdizione, String idUtente) throws SQLException;
	List<Edizione> selectIscrizioniUtente(String idUtente) throws SQLException;
	List<Utente> selectUtentiPerEdizione(int idEdizione) throws SQLException;
	int getNumeroIscritti(int idEdizione) throws SQLException;
}